/**
 * // 14：剪绳子
 * // 题目：给你一根长度为n绳子，请把绳子剪成m段（m、n都是整数，n>1并且m≥1）。
 * // 每段的绳子的长度记为k[0]、k[1]、……、k[m]。k[0]*k[1]*…*k[m]可能的最大乘
 * // 积是多少？例如当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此
 * // 时得到最大的乘积18。
 * Created by wangcheng on 9/12/2019
 */
public class CuttingRope {
    //动态规划解法
    public int maxAfterCutting(int length){
        if (length < 2){
            return 0;
        }
        if( length == 2){
            return 1;
        }
        //当长度是3时，可能把绳子剪成长度1,2的两段，或者长度都为1，由于1 * 2 > 1 * 1 * 1，因此f（3） = 2
        if(length == 3){
            return 2;
        }
        int[] products = new int[length + 1];
        //子问题的最优解存在数组products中
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;
        int max;
        for(int i = 4; i <= length; i ++){
            max = 0;
            // 算不同子长度的乘积，找出最大的乘积
            //因为求了j及 i - j的products值，所以j最大i/2
            for(int j = 1; j <= i / 2; j ++){
                max = Math.max(max, products[j] * products[i - j]);
                products[i] = max;
            }
        }
        max = products[length];
        return max;
    }

    //贪婪算法
    /*
       按照如下策略，得到的乘积将最大：当n>=5时，我们尽可能多地剪长度为3的绳子；当剩下的绳子长度为4时，把绳子剪成两段长度为2的绳子。
     */
    public int maxAfterCutting2(int length){
        if (length < 2){
            return 0;
        }
        if (length == 2){
            return 1;
        }
        if (length == 3){
            return 2;
        }

        //尽可能多的剪去长度为3的绳子段
        int timesOf3 = length / 3;

        //当绳子最后剩下的长度为4的时候，不能在剪去长度为3的绳子段。
        //此时更好的方法是把绳子剪长长度为2的两段，因为2 * 2 > 3 * 1
        if (length - timesOf3 * 3 == 1) {
            timesOf3 -= 1;
        }
        int timeOf2 = (length - timesOf3 * 3) / 2;

        return (int) (Math.pow(3, timesOf3)) * (int) (Math.pow(2, timeOf2));
    }

    public static void main(String[] args) {
        CuttingRope cuttingRope = new CuttingRope();
        System.out.println(cuttingRope.maxAfterCutting2(9));
        System.out.println(cuttingRope.maxAfterCutting2(7));
    }
}

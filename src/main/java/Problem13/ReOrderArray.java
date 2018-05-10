package Problem13;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于
 * 数组的前半部分，所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 * Created by wangcheng  on 2018/5/8.
 */

//类似插入排序，当前数是奇数，就往前找，遇到偶数就往它前面插
public class ReOrderArray {
    public  boolean isOdd(int n){
        n = Math.abs(n);
        if(n % 2 == 0){
            return false;
        }
        return true;
    }
    public void ReOrderArray(int[] arr){
        for(int i = 0;i < arr.length;i++){
            int temp = arr[i];
            if(isOdd(temp)){
                for(int j = i;j > 0;j--){
                    if(!isOdd(arr[j - 1])){
                        int t = arr[j];
                        arr[j] = arr[j-1];
                        arr[j-1] = t;
                    }
                }
            }
        }
        for(int i = 0; i < arr.length;i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public static void main(String[] args){
        ReOrderArray r = new ReOrderArray();
        int[] arr = {2,3,1,5,6,9,11,28,20,3};
        r.ReOrderArray(arr);
    }
}

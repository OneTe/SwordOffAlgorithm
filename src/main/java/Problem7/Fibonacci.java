package Problem7;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。n<=39
 *
 *
 * Created by wangcheng  on 2018/4/19.
 */
public class Fibonacci {
    //采用尾递归，但是好像java没有对尾递归做优化
    public static int fibonacci(int n){
        return fibonacci(n,0,1);
    }
    private static int fibonacci(int n ,int acc1,int acc2){
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return acc2;
        }else {
            return fibonacci(n-1,acc2,acc1 + acc2);
        }
    }
    //使用迭代
    public static int fibonacciIn(int n){
        if(n<=1){
            return n;
        }
        int preNum = 0;
        int afterNum = 1;
        int current = 0;
        for(int i = 2;i<=n;i++){
            current = preNum + afterNum;
            preNum = afterNum;
            afterNum = current;
        }
        return current;
    }
    //另一种方法
    public static int fibonacciDo(int n){
        int f = 0,g = 1;
        //g表示f(n+1), f表示f(n)
        while (n-- > 0){
            g += f;
            f = g - f;
        }
        return f;
    }
    public static void main(String[] args){
        for(int i = 1;i<9;i++) {
            System.out.println(fibonacciDo(i));
        }
    }
}
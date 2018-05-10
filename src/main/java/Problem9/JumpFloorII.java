package Problem9;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 *
 * Created by wangcheng  on 2018/4/20.
 *
 */

/*
解析：设跳上n级总共有f（n）种跳法，n-1级总共有f（n-1）,n-2级总共有f（n-2）种跳法种跳法。。。则：

  f(n) = 1+f(n-1)+f(n-2)+...+f(2)+f(1);//1代表的意思是n级台阶跳n级的跳法只有一种
  f(1) = 1;
  所以：
  f(2)=1+f(1)=1+1=2=2^1;
  f(3)=1+f(2)+f(1)=1+2+1=4=2^2;
  f(4)=1+f(3)+f(2)+f(1)=1+4+2+1=8=2^3;
  ......

  归纳：
  f(n) = 2^(n-1);（n>=1的整数）

 */
public class JumpFloorII {
    private static int jumpFloorII(int n){
        return 2<<--n;//n<32，int类型32位，超过32位，该值变为负值
    }
    private static int jumpFloorLoop(int n){
        int init = 1;
        while (--n > 0){
            init *= 2;
        }
        return init;
    }
    public static void main(String[] args){
        System.out.println(jumpFloorLoop(4));
    }
}

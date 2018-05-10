package Problem8;

/**
 *
 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 * Created by wangcheng  on 2018/4/20.
 */

/*
对于本题,前提只有 一次 1阶或者2阶的跳法。

a.如果两种跳法，1阶或者2阶，那么假定第一次跳的是一阶，那么剩下的是n-1个台阶，跳法是f(n-1);

b.假定第一次跳的是2阶，那么剩下的是n-2个台阶，跳法是f(n-2)

c.由a\b假设可以得出总跳法为: f(n) = f(n-1) + f(n-2) 

d.然后通过实际的情况可以得出：只有一阶的时候 f(1) = 1 ,只有两阶的时候可以有 f(2) = 2

e.可以发现最终得出的是一个斐波那契数列：

           | 1, (n=1)

f(n) =     | 2, (n=2)

           | f(n-1)+f(n-2) ,(n>2,n为整数)

 */
public class JumpFloor {
    //参考斐波那契数列写法，这里使用尾递归，只是第二个参数初始变成1了
    public int jumpFloor(int target) {
        return jumpFloor(target,1,1);
    }
    private int jumpFloor(int n,int type1,int type2){
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return type2;
        }else{
            return jumpFloor(n-1,type2,type1+type2);
        }
    }
    public static void main(String[] args){
        JumpFloor jf = new JumpFloor();
        System.out.println(jf.jumpFloor(5));
    }
}

package Problem12;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方
 *
 * Created by wangcheng  on 2018/5/8.
 */
public class Power {
    public static double power(double base,int exponent){
        if(exponent == 0){
            return 1;
        }

        if(exponent > 0){
            double curr = 1;
            while (exponent!=0){
                curr = curr * base;
                exponent--;
            }
            return curr;
        }
        int n = -exponent;
        double curr1 = 1;
        while (n != 0){
            curr1 *= base;
            n--;
        }
        return 1/curr1;
    }
    public static void main(String[] args){
        System.out.println(Power.power(1.21,-3));
    }
}

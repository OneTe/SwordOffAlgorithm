package math;

/**
 * // 16：数值的整数次方
 * // 题目：实现函数double Power(double base, int exponent)，求base的exponent
 * // 次方。不得使用库函数，同时不需要考虑大数问题。
 * Created by wangcheng on 9/12/2019
 */
public class Power {
    public double power(double base, int exponent){
        if (equal(base, 0.0) && exponent < 0){
            //数学上0的0次方没有意义
            return 0.0;
        }
        int absEx = Math.abs(exponent);
        double result = powerWithExponent1(base, absEx);
        if (exponent < 0){
            result = 1.0 / result;
        }
        return result;
    }

    //简单写法
    private double powerWithExponent(double base, int exponent){
        double result = 1.0;
        for (int i = 1; i <= exponent ; i++){
            result *= base;
        }
        return result;
    }

    //高效写法：采用递归
    private double powerWithExponent1(double base, int exponent){
        if (exponent == 0){
            return 1;
        }
        if(exponent == 1){
            return base;
        }
        //用右移运算符代替除以2
        double result = powerWithExponent1(base, exponent >> 1);
        result *= result;
        //用位与运算符代替求余运算符（%）来判断一个是奇数还是偶数
        if ((exponent & 0x1) == 1){
            result *= base;
        }
        return result;
    }

    private boolean equal(double num1, double num2) {
        return (num1 - num2 > -0.0000001) && (num1 - num2 < 0.0000001);
    }

    public static void main(String[] args) {
        Power p = new Power();
        System.out.println(p.power(2, 5));
        System.out.println((5 & 0x1) == 1);
    }
}

package string;

/**
 * // 20：表示数值的字符串
 * // 题目：请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，
 * // 字符串“+100”、“5e2”、“-123”、“3.1416”及“-1E-16”都表示数值，但“12e”、
 * // “1a3.14”、“1.2.3”、“+-5”及“12e+5.4”都不是
 *
 * Created by wangcheng on 9/16/2019
 */
public class NumericStrings {
    private static int currentIndex;

    private static boolean isNumeric(char[] str) {
        if (str == null || str.length == 0) return false;
        currentIndex = 0;
        //判断整数部分
        boolean isNumber = isSignedInteger(str);

        //判断小数部分
        if (currentIndex < str.length && str[currentIndex] == '.') {
            currentIndex++;
            // 下面一行代码用||的原因：
            // 1. 小数可以没有整数部分，例如.123等于0.123；
            // 2. 小数点后面可以没有数字，例如233.等于233.0；
            // 3. 当然小数点前面和后面可以有数字，例如233.666
            isNumber = isUnsignedInteger(str) || isNumber;
        }
        //判断指数部分
        if (currentIndex < str.length && (str[currentIndex] == 'e' || str[currentIndex] == 'E')) {
            currentIndex++;
            //e或E前后都要有整数
            // 下面一行代码用&&的原因：
            // 1. 当e或E前面没有数字时，整个字符串不能表示数字，例如.e1、e1；
            // 2. 当e或E后面没有整数时，整个字符串不能表示数字，例如12e、12e+5.4
            isNumber = isNumber && isSignedInteger(str);
        }
        return isNumber && (currentIndex == str.length);
    }

    /**
     * 是否是有符号整数
     *
     * @param chars
     * @return
     */
    private static boolean isSignedInteger(char[] chars) {
        if (currentIndex < chars.length && (chars[currentIndex] == '+' || chars[currentIndex] == '-'))
            currentIndex++;
        return isUnsignedInteger(chars);
    }

    /**
     * 是否是无符号整数
     *
     * @param chars
     * @return
     */
    private static boolean isUnsignedInteger(char[] chars) {
        int before = currentIndex;
        while (currentIndex < chars.length &&
                chars[currentIndex] >= '0' && chars[currentIndex] <= '9') {
            currentIndex++;
        }
        return currentIndex > before; //至少存在一个数字
    }
}

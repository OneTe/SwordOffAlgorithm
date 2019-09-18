package string;

/**
 * // 19：正则表达式匹配
 * // 题目：请实现一个函数用来匹配包含'.'和'*'的正则表达式。模式中的字符'.'
 * // 表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。在本题
 * // 中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"
 * // 和"ab*ac*a"匹配，但与"aa.a"及"ab*a"均不匹配。
 *
 * Created by wangcheng on 9/16/2019
 */

/*
    当模式中的第二个字符不是“*”时：
    a1、如果字符串第一个字符和模式中的第一个字符相匹配，那么字符串和模式都后移一个字符，然后匹配剩余的。
    a2、如果 字符串第一个字符和模式中的第一个字符相不匹配，直接返回false。

    而当模式中的第二个字符是“*”时：
    c1、如果字符串第一个字符跟模式第一个字符不匹配，则模式后移2个字符，继续匹配。

    如果字符串第一个字符跟模式第一个字符匹配，可以有3种匹配方式：
    b1、模式后移2字符，相当于x*被忽略；
    b2、字符串后移1字符，模式后移2字符；
    b3、字符串后移1字符，模式不变，即继续匹配字符下一位，因为*可以匹配多位；
 */
public class RegularExpressions {
    public static boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null)
            return false;
        int strIndex = 0;
        int patternIndex = 0;
        return matchCore(str, strIndex, pattern, patternIndex);

    }
    private static boolean matchCore(char[] str,int strIndex, char[] pattern,int patternIndex) {
        //如果都匹配到尾了成功
        if(strIndex==str.length && patternIndex==pattern.length)
            return true;
        //如果模式到尾，字符串没到尾，匹配失败
        if(strIndex!=str.length&&patternIndex==pattern.length)
            return false;

        //模式第二个字符是*
        if(patternIndex+1<pattern.length&&pattern[patternIndex+1]=='*'){
            //第一个位置相同 或者 模式第一个位置为. 即任意字符
            if(str[strIndex]==pattern[patternIndex]&&strIndex!=str.length||pattern[patternIndex]=='.'&&strIndex!=str.length){
                //分三种情况递归
                return matchCore(str,strIndex,pattern,patternIndex+2)//视x*匹配0个字符，即*前一个字符出现0次 情况b1
                        ||matchCore(str, strIndex+1, pattern, patternIndex+2)//匹配1个字符，即*前一个字符仅出现1次 情况b2
                        ||matchCore(str, strIndex+1, pattern, patternIndex);//匹配1个字符，模式保持不变 情况b3
            }else{
                //第一个位置不匹配，模式后移两位  也就是视x*匹配0个字符 情况c1
                return matchCore(str, strIndex, pattern, patternIndex+2);
            }
        }

        //第一个字符匹配，但模式第二个不是* 模式和字符串上都后移一位 情况a1
        if(strIndex!=str.length&&(str[strIndex]==pattern[patternIndex]||pattern[patternIndex]=='.')){
            return matchCore(str, strIndex+1, pattern, patternIndex+1);
        }else{
            return false;//第一个字符不匹配并且模式第二个位置不是* 情况a2
        }

    }
}

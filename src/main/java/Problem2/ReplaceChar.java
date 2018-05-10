package Problem2;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

/**
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy.
 * 则经过替换之后的字符串为We%20Are%20Happy
 *
 * Created by wangcheng  on 2018/4/19.
 */
public class ReplaceChar {
    public static void replaceSpace(StringBuffer stringBuffer){
        String str = stringBuffer.toString();
        char[] chars = str.toCharArray();
        StringBuffer sb = new StringBuffer();
        for(int i = 0;i < chars.length;i++){
            if(chars[i] == ' '){
                sb.append("%20");
            }else {
                sb.append(chars[i]);
            }
        }
        System.out.println(sb.toString());
    }
    public static void main(String[] args){
        replaceSpace(new StringBuffer("We Are Happy"));
    }
}

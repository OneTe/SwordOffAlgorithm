package util;

/**
 * Created by wangcheng  on 2019/6/21.
 */
public class ArrayTool {
    public static int maxValue(int[] arr){
        int max = Integer.MIN_VALUE;
        if(arr == null || arr.length < 1) return max;
        for(int i = 0; i< arr.length;i++){
            max = Math.max(max, arr[i]);
        }
        return max;
    }

    public static String charArrToString(char[] chars){
        String res = "";
        if(chars == null || chars.length < 1) return res;

        for(int i = 0; i < chars.length; i++){
            res += chars[i];
        }
        return res;
    }
    public static void swap(int[] arr ,int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

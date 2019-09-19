package array;

import util.PrintTool;

import static util.ArrayTool.swap;

/**
 * // 21：调整数组顺序使奇数位于偶数前面
 * // 题目：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有
 * // 奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * Created by wangcheng on 9/18/2019
 */
public class ReorderArray {
    public void reorder(int[] arr, int n){
        if ( arr == null || arr.length < 2) {
            return;
        }
        int i = 0;
        int j = n;

        while (i < j) {
            if((arr[i] & 1) == 1){
                i++;
            } else {
                swap(arr, i, j - 1);
                j --;
            }
        }
    }

    public static void main(String[] args) {
        ReorderArray reorderArray = new ReorderArray();
        int[] t = {58,38,34,5,6,10,2,1};
        reorderArray.reorder(t,8);
        PrintTool.printArr(t);
    }
}

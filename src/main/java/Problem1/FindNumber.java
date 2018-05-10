package Problem1;

/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * Created by wangcheng  on 2018/4/18.
 */
public class FindNumber {
    private static boolean isInArr(int[][] array,int target){
        for(int i = 0;i < array.length;i++){
            int low = 0;
            int high = array[i].length - 1;
            while (low <= high){
                int mid = (low + high)/2;
                if(target > array[i][mid]){
                    low = mid + 1;
                }else if (target < array[i][mid]){
                    high = mid - 1;
                }else {
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args){
        int[][] array = {{1,4,7,9},{2,7,8,11},{4,8,12,19}};
        int target = 100;
        if(isInArr(array,target)){
            System.out.println("You are here!");
        }
    }
}

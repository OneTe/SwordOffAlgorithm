package util;

/**
 * Created by wangcheng  on 2019/6/19.
 */
public class PrintTool {
    public static void printArr(int[][] temp){
        System.out.println();
        System.out.print("[ ");
        for(int i = 0; i < temp.length; i++){
            System.out.print("[ ");
            for(int j = 0 ; j < temp[i].length;j++){
                if(j != temp[i].length - 1) {
                    System.out.print(temp[i][j] + ",");
                }else {
                    System.out.print(temp[i][j]);
                }
            }
            System.out.print(" ]");
        }
        System.out.print(" ]");
    }
    public static void printArr(int[] temp){
        System.out.println();
        System.out.print("[ ");
        for(int i = 0; i < temp.length; i++){

                if(i != temp.length - 1) {
                    System.out.print(temp[i] + ",");
                }else {
                    System.out.print(temp[i]);
                }
        }
        System.out.print(" ]");
        System.out.println();
    }

}

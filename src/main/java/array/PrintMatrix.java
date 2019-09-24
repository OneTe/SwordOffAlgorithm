package array;

/**
 *
 * 29：顺时针打印矩阵
 * // 题目：输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * Created by wangcheng on 9/23/2019
 */
public class PrintMatrix {

    /*
    假设这个矩阵的行数是rows，列数是columns。打印第一个圈是左上角元素的坐标是（0，0），第二圈的左上角的坐标是（1，1），以此类推。
    我们注意到，左上角的坐标中行标和列标总是相同的，于是可以在矩阵中选取左上角为（start，start）的一圈为我们分析的目标。
    对一个5*5的矩阵而言，最后一圈只有一个数字，对应的坐标为（2，2）。我们发现5>2*2.对于一个6*6的矩阵而言，最后一圈有4个数字，
    其左上角的坐标仍然为（2，2）。我们发现6>2*2依然成立。于是我们可以得出继续循环的条件是columns>startX*2并且rows>startY*2.

    接着我们考虑如何打印一圈的功能。如图所示，我们可以把打印一圈分为四步：第一步从做到右打印一行，第二步从上到下打印一行，第三步从右到左
    打印一行，第四步从下到上打印一列。每一步我们根据起始坐标用一个循环就能打印出一行或者一列。

    不过值得注意的是，最后一圈有可能退化成只有一行、只有一列，甚至只有一个数字，因此打印这样的一圈就不再需要四步。图是几个退化的例子，
    打印一圈分别只需要三步、两步甚至只有一步。
     */
    public void printMatrixClockwisely(int[][] numbers, int columns, int rows){
        if(numbers == null || columns <= 0 || rows <= 0){
            return;
        }

        int start = 0;

        while (columns > start * 2 && rows > start * 2){
            printMatrixInCircle(numbers, columns, rows, start);

            ++ start;
        }
    }

    private void printMatrixInCircle(int[][] numbers, int columns, int rows, int start){
        int endX = columns - 1 - start;
        int endY = rows - 1 - start;

        //从左到右打印一行
        for(int i = start; i <= endX; i ++){
            int number = numbers[start][i];
            printNumber(number);
        }

        //如果只有一行，就不需要打印第二行了，所以打印第二步的条件是终止行号大于起止行号
        //从上到下打印一列
        if (start < endY){
            for(int i = start + 1; i <= endY; i ++){
                int number = numbers[i][endY];
                printNumber(number);
            }
        }

        //打印第三步前提条件是圈内至少有两行两列，也就是终止行号大于起止行号，终止列号大于起始列号
        // 从右到左打印一行
        if(start < endX && start < endY){
            for(int i = endX - 1; i >= start; i--){
                int numer = numbers[endX][i];
                printNumber(numer);
            }
        }
        //1	2	3	4	8	12	16	15	14	13	9	5	6	7	11	10
        //打印第四步，至少需要3行2列，即要求终止行号比起始行号至少大2，同时终止列号大于起始列号
        // 从下到上打印一行
        if(start < endX && start < endY - 1){
            for(int i = endY - 1; i >= start + 1; i --){
                int number = numbers[i][start];
                printNumber(number);
            }
        }
    }

    private void printNumber(int number){
        System.out.print(number + "\t");
    }

    public static void main(String[] args) {
        int[][] numbers = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        PrintMatrix pm = new PrintMatrix();
        pm.printMatrixClockwisely(numbers, 4, 4);
    }
}

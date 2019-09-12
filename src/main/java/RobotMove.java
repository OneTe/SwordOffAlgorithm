/**
 * // 13：机器人的运动范围
 * // 题目：地上有一个m行n列的方格。一个机器人从坐标(0, 0)的格子开始移动，它
 * // 每一次可以向左、右、上、下移动一格，但不能进入行坐标和列坐标的数位之和
 * // 大于k的格子。例如，当k为18时，机器人能够进入方格(35, 37)，因为3+5+3+7=18。
 * // 但它不能进入方格(35, 38)，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * <p>
 * <p>
 * Created by wangcheng on 9/11/2019
 */
public class RobotMove {
    private int[][] dirs = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
    private boolean[] visited;
    private int R;
    private int C;

    public int moveCount(int M, int N, int k) {
        if (k < 0 || M <= 0 || N <= 0) {
            return 0;
        }
        this.R = M;
        this.C = N;
        visited = new boolean[R * C];
        int count = 0;
        count = moveCountCore(0, 0, k);
        return count;
    }

    private int moveCountCore(int x, int y, int k) {

        visited[x * C + y] = true;
        int count = 1;
        for (int d = 0; d < 4; d++) {
            int nextx = x + dirs[d][0], nexty = y + dirs[d][1];
            if (inArea(nextx, nexty, k) && !visited[nextx * C + nexty]) {
                count += moveCountCore(nextx, nexty, k);
            }
        }
        return count;
    }

    private boolean inArea(int x, int y, int k) {
        return x >= 0 && x < R && y >= 0 && y < C && (getDigitSum(x) + getDigitSum(y)) <= k;
    }

    private int getDigitSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }

        return sum;
    }

    public static void main(String[] args) {
        RobotMove r = new RobotMove();
        System.out.println(r.moveCount(10, 10, 5));
    }
}

package ch12;

/**
 * 12.5
 * 有一个矩阵map，它每个格子有一个权值。从左上角的格子开始每次只能向右或者向下走，最后到达右下角的位置，路径上所有的数字累加起来就是路径和，返回所有的路径中最小的路径和。
 * 给定一个矩阵map及它的行数n和列数m，请返回最小路径和。保证行列数均小于等于100.
 * 测试样例：
 * [[1,2,3],[1,1,1]],2,3
 * 返回：4
 */
public class MinimumPath {
    public int getMin(int[][] map, int n, int m) {
        // write code here
        int[][] dp = new int[n][m];
        for (int row = 0; row < n; row++) {
            if (row == 0)
                dp[row][0] = map[row][0];
            else
                dp[row][0] = dp[row - 1][0] + map[row][0];
        }
        for (int col = 1; col < m; col++)
            dp[0][col] = dp[0][col - 1] + map[0][col];

        for (int row = 1; row < n; row++) {
            for (int col = 1; col < m; col++) {
                dp[row][col] = map[row][col] + Math.min(dp[row - 1][col], dp[row][col - 1]);
            }
        }

        return dp[n - 1][m - 1];
    }

    public static void main(String[] args) {
        int[][] map = {{613, 0, 93, 463}, {101, 369, 112, 255}, {42, 67, 86, 543}, {485, 452, 393, 461}};
        MinimumPath minimumPath = new MinimumPath();
        int res = minimumPath.getMin(map, 4, 4);
        System.out.println(res);
    }
}

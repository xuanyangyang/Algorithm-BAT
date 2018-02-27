package ch12;

/**
 * 12.9
 * 对于两个字符串str1和str2，我们需要进行插入、删除和修改操作将str1串变为str2串，定义ic，dc，rc分别为三种操作的代价，请设计一个高效算法，求出将A串变为B串所需要的最少代价。
 * 给定两个字符串str1和str2，及它们的长度和三种操作代价，请返回将str1串变为str2串所需要的最小代价。保证两串长度均小于等于300，且三种代价值均小于等于100。
 * 测试样例：
 * "abc",3,"adc",3,5,3,100
 * 返回：8
 */
public class MinCost {
    public int findMinCost(String str1, int n, String str2, int m, int ic, int dc, int rc) {
        // write code here
        int[][] dp = new int[n + 1][m + 1];

        int col = 0;
        int row = 0;

        // 初始化列
        while (row <= n) {
            dp[row][0] = row * dc;
            row++;
        }

        // 初始化行
        while (col <= m) {
            dp[0][col] = col * ic;
            col++;
        }

        for (row = 1; row <= n; row++) {
            for (col = 1; col <= m; col++) {
                if (str1.charAt(row - 1) == str2.charAt(col - 1))
                    dp[row][col] = Math.min(dp[row - 1][col] + dc, Math.min(dp[row][col - 1] + ic, dp[row - 1][col - 1]));
                else
                    dp[row][col] = Math.min(dp[row - 1][col] + dc, Math.min(dp[row][col - 1] + ic, dp[row - 1][col - 1] + rc));
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        String str1 = "bbca";
        String str2 = "cabacab";
        MinCost minCost = new MinCost();
        int res = minCost.findMinCost(str1,str1.length(),str2,str2.length(),1,2,7);
        System.out.println(res);
    }
}

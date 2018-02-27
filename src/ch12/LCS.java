package ch12;

/**
 * 12.7
 * 给定两个字符串A和B，返回两个字符串的最长公共子序列的长度。例如，A="1A2C3D4B56”，B="B1D23CA45B6A”，”123456"或者"12C4B6"都是最长公共子序列。
 * 给定两个字符串A和B，同时给定两个串的长度n和m，请返回最长公共子序列的长度。保证两串长度均小于等于300。
 * 测试样例：
 * "1A2C3D4B56",10,"B1D23CA45B6A",12
 * 返回：6
 */
public class LCS {
    public int findLCS(String A, int n, String B, int m) {
        // write code here
        if (A == null || A.length() == 0 || B == null || B.length() == 0)
            return 0;

        int[][] dp = new int[n][m];

        // 初始化列
        int row = 0;
        while (row < n) {
            if (B.charAt(0) == A.charAt(row)) {
                dp[row][0] = 1;
                row++;
                break;
            } else
                dp[row][0] = 0;
            row++;
        }
        while (row < n)
            dp[row++][0] = 1;

        // 初始化行
        int col = 0;
        while (col < m) {
            if (A.charAt(0) == B.charAt(col)) {
                dp[0][col] = 1;
                col++;
                break;
            } else
                dp[0][col] = 0;
            col++;
        }
        while (col < m)
            dp[0][col++] = 1;

        for (row = 1; row < n; row++) {
            for (col = 1; col < m; col++) {
                int max = Math.max(dp[row - 1][col], dp[row][col - 1]);
                if (A.charAt(row) == B.charAt(col))
                    max = Math.max(max, dp[row - 1][col - 1] + 1);
                dp[row][col] = max;
            }
        }

        return dp[row - 1][col - 1];
    }

    public static void main(String[] args) {
        String A = "1A2C3D4B56";
        String B = "B1D23CA45B6A";
        LCS lcs = new LCS();

        int res = lcs.findLCS(A, A.length(), B, B.length());

        System.out.println(res);
    }

}

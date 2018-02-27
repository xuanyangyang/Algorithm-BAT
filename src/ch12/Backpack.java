package ch12;

/**
 * 12.8
 * 一个背包有一定的承重cap，有N件物品，每件都有自己的价值，记录在数组v中，也都有自己的重量，记录在数组w中，每件物品只能选择要装入背包还是不装入背包，要求在不超过背包承重的前提下，选出物品的总价值最大。
 * 给定物品的重量w价值v及物品数n和承重cap。请返回最大总价值。
 * 测试样例：
 * [1,2,3],[1,2,3],3,6
 * 返回：6
 */
public class Backpack {
    public int maxValue(int[] w, int[] v, int n, int cap) {
        // write code here
        int[][] dp = new int[n][cap + 1];

        int row;
        int col = 0;

        // 初始化列
        while (col <= cap) {
            if (col >= w[0])
                break;
            col++;
        }
        while (col <= cap)
            dp[0][col++] = v[0];


        for (row = 1; row < n; row++) {
            for (col = 1; col <= cap; col++) {
                if (col - w[row] < 0)
                    dp[row][col] = dp[row - 1][col];
                else
                    dp[row][col] = Math.max(dp[row - 1][col - w[row]] + v[row], dp[row - 1][col]);
            }
        }

        return dp[n - 1][cap];
    }

    public static void main(String[] args) {
        int[] w = {1, 2, 3};
        int[] v = {1, 2, 3};
        Backpack backpack = new Backpack();
        int res = backpack.maxValue(w, v, w.length, 6);
        System.out.println(res);
    }
}

package ch12;

/**
 * 12.2
 * 有数组money，money中所有的值都为正数且不重复。每个值代表一种面值的货币，每种面值的货币可以使用任意张，再给定一个整数aim(小于等于1000)代表要找的钱数，求换钱有多少种方法。
 * 给定数组money及它的大小(小于等于50)，同时给定一个整数aim，请返回有多少种方法可以凑成aim。
 * 测试样例：
 * [1,2,4],3,3
 * 返回：2
 */
public class Exchange {
    public int countWays(int[] money, int n, int aim) {
        // write code here
        if (money == null || money.length == 0 || aim <= 0)
            return 0;

        // 暴力搜索
//        return process1(money, 0, aim);

        // 记忆搜索
//        int[][] map = new int[n + 1][aim + 1];
//        return process2(money, 0, aim, map);

        // 由记忆搜索引出的动态规划
//        return process3(money, n, aim);

        // 动态规划
        return process4(money, n, aim);
    }

    /**
     * 暴力搜索
     * 用money[index...money.length-1]这里的钱组成aim，有几种方法
     *
     * @param money
     * @param index
     * @param aim
     * @return
     */
    public int process1(int[] money, int index, int aim) {
        int res = 0;
        if (index == money.length)
            res = aim == 0 ? 1 : 0; // 是否成功组成aim
        else {
            for (int i = 0; money[index] * i <= aim; i++) {
                res += process1(money, index + 1, aim - money[index] * i);
            }
        }

        return res;
    }

    /**
     * 记忆搜索
     * 用money[index...money.length-1]这里的钱组成aim，有几种方法
     *
     * @param money
     * @param index
     * @param aim
     * @return
     */
    public int process2(int[] money, int index, int aim, int[][] map) {
        int res = 0;
        if (index == money.length)
            res = aim == 0 ? 1 : 0;
        else {
            int row = index + 1;
            int col;
            int cacheWays;
            for (int i = 0; money[index] * i <= aim; i++) {
                col = aim - money[index] * i;
                cacheWays = map[row][col];
                if (cacheWays != 0) {
                    res += cacheWays == -1 ? 0 : cacheWays;
                } else
                    res += process2(money, row, col, map);
            }
        }

        map[index][aim] = res == 0 ? -1 : res;

        return res;
    }

    /**
     * 由记忆搜索引出的动态规划
     * @param money
     * @param index
     * @param aim
     * @return
     */
    public int process3(int[] money, int index, int aim) {
        int[][] dp = new int[money.length][aim + 1];

        for (int i = 0; i < money.length; i++) { // 组成0的方法只有1种那就是不用
            dp[i][0] = 1;
        }

        for (int i = 0; i <= aim; i++) { // 只使用money[0]货币的情况下组成i的方法有几种
            if (i % money[0] == 0)
                dp[0][i] = 1;
            else
                dp[0][i] = 0;
        }

        for (int i = 1; i < money.length; i++) {
            for (int j = 1; j <= aim; j++) {
                for (int k = 0; k * money[i] <= j; k++)
                    dp[i][j] += dp[i - 1][j - money[i] * k];
            }
        }

        return dp[money.length - 1][aim];
    }

    /**
     * 优化后的动态规划
     * @param money
     * @param index
     * @param aim
     * @return
     */
    public int process4(int[] money, int index, int aim) {
        int[][] dp = new int[money.length][aim + 1];

        for (int i = 0; i < money.length; i++) { // 组成0的方法只有1种那就是不用
            dp[i][0] = 1;
        }

        for (int i = 0; i <= aim; i++) { // 只使用money[0]货币的情况下组成i的方法有几种
            if (i % money[0] == 0)
                dp[0][i] = 1;
            else
                dp[0][i] = 0;
        }

        for (int i = 1; i < money.length; i++) {
            for (int j = 1; j <= aim; j++) {
                if (j - money[i] >= 0)
                    dp[i][j] = dp[i][j - money[i]] + dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[money.length - 1][aim];
    }

    public static void main(String[] args) {
        int[] money = {1, 2, 5};
        Exchange exchange = new Exchange();
        int ways = exchange.countWays(money, 3, 100);
        System.out.println(ways);
    }
}

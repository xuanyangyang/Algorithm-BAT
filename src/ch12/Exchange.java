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
        int[][] map = new int[n + 1][aim + 1];
        return process2(money, 0, aim, map);
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
            res = aim == 0 ? 1 : 0;
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
            int row;
            int col;
            int cacheWays;
            for (int i = 0; money[index] * i <= aim; i++) {
                row = index + 1;
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

    public static void main(String[] args) {
        int[] money = {1, 2, 4};
        Exchange exchange = new Exchange();
        int ways = exchange.countWays(money, 3, 3);
        System.out.println(ways);
    }
}

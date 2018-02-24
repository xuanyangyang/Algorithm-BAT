package ch09;

/**
 * 9.9
 * 2n个人排队买票，n个人拿5块钱，n个人拿10块钱，票价是5块钱1张，每个人买一张票，售票员手里没有零钱，问有多少种排队方法让售票员可以顺利卖票。
 * 给定一个整数n，请返回所求的排队方案个数。保证结果在int范围内。
 * 测试样例：
 * 1
 * 返回：1
 */
public class BuyTickets {
    public int countWays(int n) {
        // write code here

        return C(2 * n, n) / (n + 1);
    }

    /**
     * 模拟C运算
     *
     * @param down 下标
     * @param up   上标
     * @return
     */
    public int C(int down, int up) {
        return A(down, up) / A(up, up);
    }

    /**
     * 模拟A运算
     *
     * @param down 下标
     * @param up   上标
     * @return
     */
    public int A(int down, int up) {
        int data = 1;
        for (int i = 0; i < up; i++)
            data *= down--;
        return data;
    }
}

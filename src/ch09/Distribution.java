package ch09;

/**
 * 9.5
 * n颗相同的糖果，分给m个人，每人至少一颗，问有多少种分法。
 * 给定n和m，请返回方案数，保证n小于等于12，且m小于等于n。
 * 测试样例：
 * 10,3
 * 返回：36
 */
public class Distribution {
    public int getWays(int n, int m) {
        // write code here

        return C(n - 1, m - 1);
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

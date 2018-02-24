package ch09;

/**
 * 9.8
 * n个数进出栈的顺序有多少种？假设栈的容量无限大。
 * 给定一个整数n，请返回所求的进出栈顺序个数。保证结果在int范围内。
 * 测试样例：
 * 1
 * 返回：1
 */
public class Stack {
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

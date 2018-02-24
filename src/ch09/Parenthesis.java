package ch09;

/**
 * 9.7
 * 假设有n对左右括号，请求出合法的排列有多少个？合法是指每一个括号都可以找到与之配对的括号，比如n=1时，()是合法的，但是)(为不合法。
 * 给定一个整数n，请返回所求的合法排列数。保证结果在int范围内。
 * 测试样例：
 * 1
 * 返回：1
 */
public class Parenthesis {
    public int countLegalWays(int n) {
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

package ch09;

/**
 * 9.11
 * 12个高矮不同的人，排成两排，每排必须是从矮到高排列，而且第二排比对应的第一排的人高，问排列方式有多少种？
 * 给定一个偶数n，请返回所求的排列方式个数。保证结果在int范围内。
 * 测试样例：
 * 1
 * 返回：1
 */
public class HighAndShort {
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

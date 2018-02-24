package ch10;

import ch07.CheckCompletion;

/**
 * 10.2
 * 有2k只球队，有k-1个强队，其余都是弱队，随机把它们分成k组比赛，每组两个队，问两强相遇的概率是多大？
 * 给定一个数k，请返回一个数组，其中有两个元素，分别为最终结果的分子和分母，请化成最简分数
 * 测试样例：
 * 4
 * 返回：[3,7]
 */
public class Championship {
    public int[] calc(int k) {
        // write code here
        int all = 1; // 分组全部情况
        int k2 = 2 * k;
        while (k2 != 0) {
            all *= k2 - 1;
            k2 -= 2;
        }

        int noTowStrong = C(k + 1, k - 1) * A(k - 1, k - 1); // 两强不相遇的情况

        int[] res = new int[2];
        res[0] = all - noTowStrong;
        res[1] = all;

        int g = gcd(res[0], res[1]);
        res[0] /= g;
        res[1] /= g;

        return res;
    }

    // 最大公约数
    int gcd(int x, int y) {
        while (y != 0) {
            int t = y;
            y = x % y;
            x = t;
        }
        return x;
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

    public static void main(String[] args) {
        Championship championship = new Championship();
        int[] res = championship.calc(4);
        for (int r : res)
            System.out.print(r + " ");
    }
}

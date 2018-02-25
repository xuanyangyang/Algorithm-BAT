package ch10;

/**
 * 10.3
 * n只蚂蚁从正n边形的n个定点沿着边移动，速度是相同的，问它们碰头的概率是多少？
 * 给定一个正整数n，请返回一个数组，其中两个元素分别为结果的分子和分母，请化为最简分数。
 * 测试样例：
 * 3
 * 返回：[3,4]
 */
public class Ants {
    public int[] collision(int n) {
        // write code here
        int all = (int) Math.pow(2, n);

        int g = gcd(all, all - 2);

        int[] res = new int[2];
        res[0] = (all - 2) / g;
        res[1] = all / g;

        return res;
    }

    // 最大公约数
    public int gcd(int x, int y) {
        int temp;
        while (y != 0) {
            temp = y;
            y = x % y;
            x = temp;
        }

        return x;
    }
}

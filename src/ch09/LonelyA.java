package ch09;

/**
 * 9.4
 * A(A也是他的编号)是一个孤傲的人，在一个n个人(其中编号依次为1到n)的队列中，他于其中的标号为b和标号c的人都有矛盾，所以他不会和他们站在相邻的位置。现在问你满足A的要求的对列有多少种？
 * 给定人数n和三个人的标号A,b和c，请返回所求答案，保证人数小于等于11且大于等于3。
 * 测试样例：
 * 6,1,2,3
 * 288
 */
public class LonelyA {
    public int getWays(int n, int a, int b, int c) {
        // write code here
        int ab = A(n - 1, n - 1) * 2; // ab相邻的情况分为ab,ba两种
        int bac = A(n - 2, n - 2) * 2; // bac相邻的情况有bac,cab两种
        int all = A(n, n); // 全排列

        return all - ab * 2 + bac; // ac与ab一致所以ab*2
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

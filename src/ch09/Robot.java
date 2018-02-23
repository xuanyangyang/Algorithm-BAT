package ch09;

/**
 * 9.2
 * 在XxY的方格中，以左上角格子为起点，右下角格子为终点，每次只能向下走或者向右走，请问一共有多少种不同的走法
 * 给定两个正整数int x,int y，请返回走法数目。保证x＋y小于等于12。
 * 测试样例：
 * 2,2
 * 返回：2
 */
public class Robot {
    public int countWays(int x, int y) {
        // write code here
        --x;
        --y;

        return C(x + y, y);
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
        Robot robot = new Robot();
        int value = robot.C(7, 2);
        System.out.println(value);
    }
}

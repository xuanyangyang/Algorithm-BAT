package ch09;

/**
 * 9.12
 * 有n个信封，包含n封信，现在把信拿出来，再装回去，要求每封信不能装回它原来的信封，问有多少种装法?
 * 给定一个整数n，请返回装发个数，为了防止溢出，请返回结果Mod 1000000007的值。保证n的大小小于等于300。
 * 测试样例：
 * 2
 * 返回：1
 */
public class CombineByMistake {
    public int countWays(int n) {
        // write code here
        if (n == 1) return 0;
        else if (n == 2) return 1;
        else {
            int pre = 0, last = 1;
            for (int i = 3; i <= n; ++i) {
                int tmp = (int) ((long) (i - 1) * (long) (pre + last) % 1000000007);
                pre = last;
                last = tmp;
            }
            return last;
        }
    }

    public static void main(String[] args) {
        CombineByMistake combineByMistake = new CombineByMistake();
        System.out.println(combineByMistake.countWays(300));
    }
}

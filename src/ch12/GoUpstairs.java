package ch12;

/**
 * 12.4
 * 有n级台阶，一个人每次上一级或者两级，问有多少种走完n级台阶的方法。为了防止溢出，请将结果Mod 1000000007
 * 给定一个正整数int n，请返回一个数，代表上楼的方式数。保证n小于等于100000。
 * 测试样例：
 * 1
 * 返回：1
 */
public class GoUpstairs {
    public int countWays(int n) {
        // write code here
        if (n == 1)
            return 1;
        else if (n == 2)
            return 2;
        else {
            int[] a = new int[n + 1];
            a[1] = 1;
            a[2] = 2;
            for (int i = 3; i <= n; i++) {
                a[i] = (a[i - 1] + a[i - 2]) % 1000000007;
            }

            return a[n];
        }
    }
}

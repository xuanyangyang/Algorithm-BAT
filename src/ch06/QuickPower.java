package ch06;

import java.math.BigInteger;

/**
 * 6.8
 * 如果更快的求一个整数k的n次方。如果两个整数相乘并得到结果的时间复杂度为O(1)，得到整数k的N次方的过程请实现时间复杂度为O(logN)的方法。
 * 给定k和n，请返回k的n次方，为了防止溢出，请返回结果Mod 1000000007的值。
 * 测试样例：
 * 2,3
 * 返回：8
 */
public class QuickPower {
    public int getPower(int a, int n) {
        BigInteger res = BigInteger.valueOf(1);
        BigInteger temp = BigInteger.valueOf(a);

        while (n != 0) {
            if ((n & 1) == 1) {
                res = res.multiply(temp);
            }
            temp = temp.multiply(temp);
            res = res.mod(BigInteger.valueOf(1000000007));
            temp = temp.mod(BigInteger.valueOf(1000000007));
            n >>= 1;
        }

        return res.intValue();
    }

    public static void main(String[] args) {
        QuickPower quickPower = new QuickPower();
        System.out.println(quickPower.getPower(2, 10));
    }
}

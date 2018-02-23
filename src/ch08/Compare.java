package ch08;

/**
 * 8.4
 * 对于两个32位整数a和b，请设计一个算法返回a和b中较大的。但是不能用任何比较判断。若两数相同，返回任意一个。
 * 给定两个整数a和b，请返回较大的数。
 * 测试样例：
 * 1,2
 * 返回：2
 */
public class Compare {
    public int getMax(int a, int b) {
        // write code here
        int c = a - b;
        int as = sign(a); // 1表示非负，0表示负数
        int bs = sign(b);
        int cs = sign(c);
        int disab = as ^ bs; // ab符号不相同为1，相同为0
        int sameab = flip(disab); // ab符号相同为1，不相同为0
        int returnA = disab * as + sameab * cs;
        int returnB = flip(returnA);

        return returnA * a + returnB * b;
    }

    // 获取int符号位
    public int sign(int n) {
        return flip((n >> 31) & 1);
    }

    // 反转位
    public int flip(int n) {
        return n ^ 1;
    }
}

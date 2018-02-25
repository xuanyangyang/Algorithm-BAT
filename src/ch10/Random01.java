package ch10;

import java.util.Random;

/**
 * 10.4
 * 给定一个以p概率产生0，以1-p概率产生1的随机函数RandomP::f()，p是固定的值，但你并不知道是多少。除此之外也不能使用任何额外的随机机制，
 * 请用RandomP::f()实现等概率随机产生0和1的随机函数。
 */
public class Random01 {
    private static double p = new Random().nextFloat();

    // 随机概率p
    public static int f() {
        return new Random().nextFloat() < p ? 0 : 1;
    }

    public int random01() {
        // 通过f函数实现01等概率返回
        int a;
        int b;
        while (true) {
            a = f();
            b = f();
            if (a != b)
                return a > b ? 1 : 0;
        }
    }
}

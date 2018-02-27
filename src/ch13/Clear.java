package ch13;

import java.util.HashMap;

/**
 * 13.5
 * 现在有一个整数数组，其元素值均为1-n范围内的某个整数，现在你和你的朋友在玩一个游戏，游戏的目的是把数组清空，你们轮流操作，你是先手，每次操作你可以删除数组中值为某个数的元素任意多个(当然数组中值为这个数的元素个数应大于等于你删除的个数,且你至少要删除一个数)。最先把数组清空的人获得胜利。假设你们都采取最优策略，请你计算你能否获得胜利。
 * 给定一个整数数组A和元素个数n。请返回一个整数，1代表你能获胜，0代表你不能获胜。
 * 测试样例：
 * [1,1,1]
 * 返回：1
 */
public class Clear {
    public int getWinner(int[] A, int n) {
        // write code here
        HashMap<Integer, Integer> map = new HashMap<>();

        // 统计所有数字出现次数
        for (int num : A)
            map.merge(num, 1, (a, b) -> a + b);

        // 将所有次数进行异或运算
        int res = 0;
        for (int count : map.values()) {
            res ^= count;
        }

        // 出现次数成对则为0
        return res != 0 ? 1 : 0;
    }

    public int getWinner2(int[] A, int n) {
        // write code here
        int[] count = new int[n + 1];
        for (int i = 0; i < n; i++) {
            count[A[i]]++;
        }
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res ^= count[i];
//            System.out.print(count[i] + " ");
        }
//        System.out.println();
        return res != 0 ? 1 : 0;
    }

    public static void main(String[] args) {
        int[] arr = {15, 41, 21, 21, 21, 6, 29, 42, 19, 60, 22, 63, 42, 49, 32, 22, 24, 57, 35, 54, 22, 31, 12, 15, 31, 15, 2, 12, 24, 40, 58, 16, 49, 60, 59, 58, 6, 63, 20, 42, 14, 31, 1, 21, 20, 38, 47, 1, 25, 50, 52, 20, 14, 40, 5, 12, 24, 36, 28, 35, 4, 49, 20};
        Clear clear = new Clear();
        int res1 = clear.getWinner(arr, arr.length);
        int res2 = clear.getWinner2(arr, arr.length);
        System.out.println(res1);
    }
}

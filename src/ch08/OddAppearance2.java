package ch08;

/**
 * 8.6
 * 给定一个整型数组arr，其中有两个数出现了奇数次，其他的数都出现了偶数次，找到这两个数。要求时间复杂度为O(N)，额外空间复杂度为O(1)。
 * 给定一个整形数组arr及它的大小n，请返回一个数组，其中两个元素为两个出现了奇数次的元素,请将他们按从小到大排列。
 * 测试样例：
 * [1,2,4,4,2,1,3,5],8
 * 返回：[3,5]
 */
public class OddAppearance2 {
    public int[] findOdds(int[] arr, int n) {
        // write code here
        int k1 = 0;
        int k2 = 0;

        for (int a : arr) // 假设出现奇数次的两个数为a,b则，k1 = a ^ b
            k1 ^= a;

        int rightOne = k1 & (~k1 + 1); // 获取k1的二进制最右边第一个1

        for (int a : arr) // 最后k2为a或者b
            if ((rightOne & a) != 0) // 只有和rightOne在相同位一致的数才有可能是a或b
                k2 ^= a;

        int small = Math.min(k2, k1 ^ k2);
        int big = Math.max(k2, k1 ^ k2);

        int[] res = new int[2];
        res[0] = small;
        res[1] = big;

        return res;
    }
}

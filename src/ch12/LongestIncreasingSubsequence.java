package ch12;

/**
 * 12.6
 * 这是一个经典的LIS(即最长上升子序列)问题，请设计一个尽量优的解法求出序列的最长上升子序列的长度。
 * 给定一个序列A及它的长度n(长度小于等于500)，请返回LIS的长度。
 * 测试样例：
 * [1,4,2,5,3],5
 * 返回：3
 */
public class LongestIncreasingSubsequence {
    public int getLIS(int[] arr, int n) {
        // write code here
        if (arr == null || arr.length == 0)
            return 0;

        int[] maxs = new int[n];
        maxs[0] = 1;
        int maxLen = 1;
        for (int i = 1; i < n; i++) {
            int max = 1;
            for (int k = 0; k < i; k++) {
                if (arr[i] > arr[k])
                    max = Math.max(max, maxs[k] + 1);
            }
            maxs[i] = max;
            maxLen = Math.max(maxLen, max);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] tests = {2, 1, 5, 3, 6, 4, 8, 9, 7, 7,9};
        LongestIncreasingSubsequence longestIncreasingSubsequence = new LongestIncreasingSubsequence();
        int res = longestIncreasingSubsequence.getLIS(tests, tests.length);
        System.out.println(res);
    }
}

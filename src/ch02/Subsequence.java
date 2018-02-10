package ch02;

/**
 * 2.19
 * 对于一个数组，请设计一个高效算法计算需要排序的最短子数组的长度。
 * 给定一个int数组A和数组的大小n，请返回一个二元组，代表所求序列的长度。(原序列位置从0开始标号,若原序列有序，返回0)。保证A中元素均为正整数。
 */
public class Subsequence {
    public int shortestSubsequence(int[] A, int n) {
        int maxIndex = 0;
        int max = A[maxIndex];
        int minIndex = n - 1;
        int min = A[n - 1];

        for (int i = maxIndex + 1; i < n; i++) {
            if (max <= A[i])
                max = A[i];
            else
                maxIndex = i;
        }

        for (int i = minIndex - 1; i >= 0; i--) {
            if (min >= A[i])
                min = A[i];
            else
                minIndex = i;
        }

        if (maxIndex == 0 && minIndex == n - 1)
            return 0;
        else
            return maxIndex - minIndex + 1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 8, 9};
        Subsequence subsequence = new Subsequence();
        int length = subsequence.shortestSubsequence(arr, arr.length);
        System.out.println(length);
    }
}

package ch02;

/**
 * O(n^2)
 */

/**
 * 对于一个int数组，请编写一个冒泡排序算法，对数组元素排序。
 * 给定一个int数组A及数组的大小n，请返回排序后的数组。
 */

public class BubbleSort {
    public int[] bubbleSort(int[] A, int n) {
        // write code here
        int temp;

        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (A[j] > A[j + 1]) {
                    temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                }
            }
        }

        return A;
    }

    public static void main(String[] args) {
        int[] testData = {1, 2, 3, 5, 2, 3};
        BubbleSort bubbleSort = new BubbleSort();
        testData = bubbleSort.bubbleSort(testData, 6);
        for (int test : testData) {
            System.out.println(test);
        }
    }
}

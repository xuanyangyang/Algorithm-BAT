package ch02;

/**
 * O(n^2)
 */

/**
 * 对于一个int数组，请编写一个插入排序算法，对数组元素排序。
 * 给定一个int数组A及数组的大小n，请返回排序后的数组。
 */

public class InsertionSort {
    public int[] insertionSort(int[] A, int n) {
        // write code here
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (A[j] < A[j - 1]) {
                    int temp = A[j];
                    A[j] = A[j - 1];
                    A[j - 1] = temp;
                } else
                    break;
            }
        }

        return A;
    }

    public static void main(String[] args) {
        int[] testData = {1, 2, 3, 5, 2, 3};
        InsertionSort insertionSort = new InsertionSort();
        testData = insertionSort.insertionSort(testData, 6);
        for (int test : testData) {
            System.out.println(test);
        }
    }
}

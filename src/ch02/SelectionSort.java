package ch02;

/**
 * O(n^2)
 */

/**
 * 对于一个int数组，请编写一个选择排序算法，对数组元素排序。
 * 给定一个int数组A及数组的大小n，请返回排序后的数组。
 */

public class SelectionSort {
    public int[] selectionSort(int[] A, int n) {
        // write code here
        int maxIndex;
        int temp;

        for (int i = n - 1; i > 0; i--) {
            maxIndex = i;
            for (int j = 0; j < i; j++) {
                if (A[maxIndex] < A[j]) {
                    maxIndex = j;
                }
            }
            if (maxIndex != i) {
                temp = A[i];
                A[i] = A[maxIndex];
                A[maxIndex] = temp;
            }
        }

        return A;
    }

    public static void main(String[] args) {
        int[] testData = {1, 2, 3, 5, 2, 3};
        SelectionSort selectionSort = new SelectionSort();
        testData = selectionSort.selectionSort(testData, 6);
        for (int test : testData) {
            System.out.println(test);
        }
    }
}

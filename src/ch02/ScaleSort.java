package ch02;

/**
 * 2.13
 * 已知一个几乎有序的数组，几乎有序是指，如果把数组排好顺序的话，每个元素移动的距离可以不超过k，并且k相对于数组来说比较小。请选择一个合适的排序算法针对这个数据进行排序。
 * 给定一个int数组A，同时给定A的大小n和题意中的k，请返回排序后的数组。
 * 样例：[2,1,4,3,6,5,8,7,10,9],10,2
 * 返回：[1,2,3,4,5,6,7,8,9,10]
 */

public class ScaleSort {
    public int[] sortElement(int[] A, int n, int k) {
        // write code here
        if (A == null || n < 2 || n < k)
            return A;

        // 获取大小为k的小根堆
        int[] heap = getHeap(A, k);

        for (int i = k; i < n; i++) {
            A[i - k] = heap[0];
            heap[0] = A[i];
            adjustHeap(heap, 0, k);
        }

        // 把剩余堆的值一个一个弹出
        int temp;
        for (int i = n - k; i < n; i++) {
            A[i] = heap[0];

            temp = heap[0];
            heap[0] = heap[k - 1];
            heap[k - 1] = temp;

            adjustHeap(heap, 0, --k);
        }

        return A;
    }

    public int[] getHeap(int[] arr, int size) {
        int[] heap = new int[size];

        for (int i = 0; i < size; i++) {
            heap[i] = arr[i];
        }

        adjustHeap(heap, 0, size);

        for (int i = size / 2 - 1; i >= 0; i--) {
            adjustHeap(heap, i, size);
        }

        return heap;
    }

    // 调整堆
    public void adjustHeap(int[] arr, int i, int length) {
        int min = arr[i];
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] > arr[k + 1]) {
                k++;
            }
            if (min > arr[k]) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = min;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 3, 6, 5, 8, 7, 10, 9};
        ScaleSort scaleSort = new ScaleSort();
        scaleSort.sortElement(arr, 10, 2);
        for (int a : arr) {
            System.out.print(a + " ");
        }
    }
}

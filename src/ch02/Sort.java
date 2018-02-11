package ch02;

import java.util.ArrayList;
import java.util.List;

/**
 * 对于一个int数组，请编写一个排序算法，对数组元素排序。
 * 给定一个int数组A及数组的大小n，请返回排序后的数组。
 */

public class Sort {
    /**
     * 冒泡排序
     * O(n^2)
     */
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

    /**
     * 插入排序
     * O(n^2)
     */
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

    /**
     * 选择排序
     * O(n^2)
     */
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

    /**
     * 归并排序
     * O(nlogn)
     */
    public int[] mergeSort(int[] A, int n) {
        // write code here
        if (A == null || A.length < 2)
            return null;

        mergeSort(A, 0, n - 1);

        return A;
    }

    public void mergeSort(int[] array, int left, int right) {
        if (left == right)
            return;

        int mid = (left + right) / 2;
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    public void merge(int[] array, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        int l = left;
        int r = mid + 1;
        int index = 0;
        while (l <= mid && r <= right) {
            if (array[l] <= array[r])
                help[index++] = array[l++];
            else
                help[index++] = array[r++];
        }
        while (l <= mid) {
            help[index++] = array[l++];
        }
        while (r <= right) {
            help[index++] = array[r++];
        }
        for (int i = 0; i < help.length; i++) {
            array[left + i] = help[i];
        }
    }


    /**
     * 快速排序
     * O(nlogn)
     */
    public int[] quickSort(int[] A, int n) {
        // write code here
        if (A == null || A.length < 2)
            return null;

        quickSort(A, 0, n - 1);

        return A;
    }

    public void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = partition(arr, left, right);
            quickSort(arr, left, mid - 1);
            quickSort(arr, mid + 1, right);
        }
    }

    public int partition(int[] arr, int left, int right) {
        int random = left + (int) (Math.random() * (right - left + 1));
        swap(arr, random, right);
        int leftIndex = left - 1;
        int index = left;
        while (index <= right) {
            if (arr[index] <= arr[right]) {
                swap(arr, ++leftIndex, index);
            }
            index++;
        }
        return leftIndex;
    }


    /**
     * 堆排序
     * O(nlogn)
     */
    public int[] heapSort(int[] A, int n) {
        //建堆
        for (int i = A.length / 2 - 1; i >= 0; i--) {
            adjustHeap(A, i, A.length);
        }

        int temp;
        //调整堆
        for (int i = A.length - 1; i > 0; i--) {
            temp = A[0];
            A[0] = A[i];
            A[i] = temp;
            adjustHeap(A, 0, i);
        }

        return A;
    }

    public void adjustHeap(int[] arr, int i, int length) {
        int max = arr[i];
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }
            if (arr[k] > max) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = max;
    }

    /**
     * 希尔排序
     * O(nlogn)
     */
    public int[] shellSort(int[] A, int n) {
        int feet = A.length / 2;
        int temp;
        int index;
        while (feet > 0) {
            for (int i = feet; i < A.length; i++) {
                index = i;
                while (index >= feet) {
                    if (A[index - feet] > A[index]) {
                        temp = A[index];
                        A[index] = A[index - feet];
                        A[index - feet] = temp;
                        index -= feet;
                    } else {
                        break;
                    }
                }
            }
            feet /= 2;
        }
        return A;
    }

    /**
     * 计数排序
     * O(n)
     */
    public int[] countingSort(int[] A, int n) {
        int min = A[0];
        int max = A[0];

        for (int a : A) {
            min = Math.min(min, a);
            max = Math.max(max, a);
        }

        int[] arr = new int[max - min + 1];

        for (int a : A) {
            arr[a - min]++;
        }

        int index = 0;

        for (int i = 0; i < arr.length; i++) {
            while (arr[i]-- > 0) {
                A[index++] = i + min;
            }
        }

        return A;
    }

    /**
     * 基数排序
     * O(n)
     */
    public int[] radixSort(int[] A, int n) {
        int max = A[0];

        for (int a : A) {
            max = Math.max(max, a);
        }

        List<List<Integer>> boxs = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            boxs.add(new ArrayList<>());
        }

        int k = 1;
        int index;

        while (max > 0) {

            for (int a : A) {
                boxs.get(a / k % 10).add(a);
            }

            index = 0;

            for (int i = 0; i < 10; i++) {
                List<Integer> box = boxs.get(i);
                for (int j = 0; j < box.size(); j++) {
                    A[index++] = box.get(j);
                }
                box.clear();
            }

            k *= 10;
            max /= 10;
        }

        return A;
    }

    public static void main(String[] args) {
        Sort sort = new Sort();
        int len = 50;
        int range = 100;
        int testTimes = 50000;
        boolean isSuccess = true;
        for (int i = 0; i < testTimes; i++) {
            int[] arr = generateArray(len, range);
//            sort.bubbleSort(arr, arr.length);
//            sort.insertionSort(arr, arr.length);
//            sort.selectionSort(arr, arr.length);
//            sort.mergeSort(arr, arr.length);
            sort.quickSort(arr, arr.length);
//            sort.heapSort(arr, arr.length);
//            sort.shellSort(arr, arr.length);
//            sort.countingSort(arr, arr.length);
//            sort.radixSort(arr,arr.length);
            if (!isSorted(arr)) {
                System.out.println("Wrong Case:");
                printArray(arr);
                isSuccess = false;
                break;
            }
        }
        if (isSuccess)
            System.out.println("OK");
    }

    public static int[] generateArray(int len, int range) {
        if (len < 1) {
            return null;
        }
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = (int) (Math.random() * range);
        }
        return arr;
    }

    public static void printArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static boolean isSorted(int[] arr) {
        if (arr == null || arr.length < 2) {
            return true;
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                return false;
            }
        }
        return true;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

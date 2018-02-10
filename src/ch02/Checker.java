package ch02;

/**
 * 请设计一个高效算法，判断数组中是否有重复值。必须保证额外空间复杂度为O(1)。
 * 给定一个int数组A及它的大小n，请返回它是否有重复值。
 * 样例：[1,2,3,4,5,5,6],7
 * 返回：true
 */
public class Checker {

    public boolean checkDuplicate(int[] arr, int n) {
        // write code here

        makeHeap(arr);

        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            adjustHeap(arr, 0, i);
        }

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1])
                return true;
        }

        return false;
    }

    public void makeHeap(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
    }

    public void adjustHeap(int[] arr, int index, int size) {
        int max = arr[index];

        for (int k = index * 2 + 1; k < size; k = k * 2 + 1) {
            if (k + 1 < size && arr[k] < arr[k + 1]) {
                k++;
            }
            if (max < arr[k]) {
                arr[index] = arr[k];
                index = k;
            } else
                break;
        }

        arr[index] = max;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Checker checker = new Checker();
        int[] arr = {1, 2, 3, 4, 5, 5, 6};
        System.out.println(checker.checkDuplicate(arr, arr.length));
    }
}

package ch02;

/**
 * 2.17
 * 有一个只由0，1，2三种元素构成的整数数组，请使用交换、原地排序而不是使用计数进行排序。
 * 给定一个只含0，1，2的整数数组A及它的大小，请返回排序后的数组。保证数组大小小于等于500。
 */
public class ThreeColor {
    public int[] sortThreeColor(int[] arr, int n) {
        // write code here
        int right = n;
        int left = 0;
        int i = 0;
        while (i != right) {
            if (arr[i] == 0) {
                swap(arr, left++, i);
            } else if (arr[i] == 2) {
                swap(arr, --right, i--);
            }
            i++;
        }

        return arr;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        ThreeColor threeColor = new ThreeColor();
        int[] arr = {0, 1, 1, 0, 2, 2};
        threeColor.sortThreeColor(arr, 6);
        for (int a : arr) {
            System.out.print(a + " ");
        }
    }
}

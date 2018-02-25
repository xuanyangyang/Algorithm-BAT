package ch10;

import java.util.Random;

/**
 * 10.8
 * 给定一个长度为N且没有重复元素的数组arr和一个整数M，实现函数等概率随机打印arr中的M个数。
 */
public class RandomPrint {
    public int[] print(int[] arr, int N, int M) {
        Random random = new Random();
        int[] res = new int[M];
        int randomValue;
        for (int i = 0; i < M; i++) {
            randomValue = random.nextInt(N - i);
            res[0] = arr[randomValue];
            swap(arr, randomValue, N - i - 1);
        }

        return res;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

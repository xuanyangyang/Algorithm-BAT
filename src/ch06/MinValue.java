package ch06;

/**
 * 6.4
 * 对于一个有序循环数组arr，返回arr中的最小值。有序循环数组是指，有序数组左边任意长度的部分放到右边去，右边的部分拿到左边来。比如数组[1,2,3,3,4]，是有序循环数组，[4,1,2,3,3]也是。
 * 给定数组arr及它的大小n，请返回最小值。
 * 测试样例：
 * [4,1,2,3,3],5
 * 返回：1
 */
public class MinValue {
    public int getMin(int[] arr, int n) {
        // write code here
        if (arr == null || arr.length == 0)
            return -1;
        else {
            int left = 0;
            int right = arr.length - 1;
            int mid;
            while (left < right) {
                mid = left + (right - left) / 2;
                if (left == right - 1) // 只剩2个数时直接比较其大小
                    break;
                else if (arr[left] < arr[right]) // 当局部列表有序返回头
                    return arr[left];
                else if (arr[left] > arr[mid]) // 当局部列表头元素大于中间元素，这里有循环，也就是有最小值，搜索左边
                    right = mid;
                else if (arr[mid] > arr[right]) // 当局部列表中间元素大于尾元素，这里有循环，也就是有最小值，搜索右边
                    left = mid;
                else {
                    // 当局部列表头元素等于中间元素等于尾元素，遍历寻找最小值
                    while (left < right) {
                        if (arr[left] == arr[mid])
                            left++;
                        else if (arr[left] < arr[mid])
                            return arr[left];
                        else {
                            right = mid;
                            break;
                        }
                    }
                }
            }
            return Math.min(arr[left], arr[right]);
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 1, 2, 3, 3};
        MinValue minValue = new MinValue();
        System.out.println(minValue.getMin(arr, arr.length));
    }
}

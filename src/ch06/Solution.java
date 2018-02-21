package ch06;

/**
 * 6.2
 * 定义局部最小的概念。arr长度为1时，arr[0]是局部最小。arr的长度为N(N>1)时，如果arr[0]<arr[1]，那么arr[0]是局部最小；
 * 如果arr[N-1]<arr[N-2]，那么arr[N-1]是局部最小；如果0<i<N-1，既有arr[i]<arr[i-1]又有arr[i]<arr[i+1]，那么arr[i]是局部最小。
 * 给定无序数组arr，已知arr中任意两个相邻的数都不相等，写一个函数，只需返回arr中任意一个局部最小出现的位置即可。
 */
public class Solution {
    public int getLessIndex(int[] arr) {
        if (arr == null || arr.length == 0)
            return -1;
        if (arr.length == 1 || arr[0] < arr[1])
            return 0;
        if (arr[arr.length - 1] < arr[arr.length - 2])
            return arr.length - 1;
        int left = 1;
        int right = arr.length - 2;
        int mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            // 如果mid大于左边的值，从中间往左边看是递减的，则局部最小值就在左边
            if (arr[mid] > arr[mid - 1])
                right = mid - 1;
            // 如果mid大于右边的值，从中间往右边看是递减的，则局部最小值就在右边
            else if (arr[mid] > arr[mid + 1])
                left = mid + 1;
            // 小于相邻值就是局部最小值
            else
                return mid;
        }
        return left;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 9, 2, 1, 4, 0, 10, 9, 0, 8, 3, 5, 6, 7, 1, 9, 2, 4, 0, 7};
        Solution solution = new Solution();
        System.out.println(solution.getLessIndex(arr));
    }
}

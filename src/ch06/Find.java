package ch06;

/**
 * 有一个有序数组arr，其中不含有重复元素，请找到满足arr[i]==i条件的最左的位置。如果所有位置上的数都不满足条件，返回-1。
 * 给定有序数组arr及它的大小n，请返回所求值。
 * 测试样例：
 * [-1,0,2,3],4
 * 返回：2
 */
public class Find {
    public int findPos(int[] arr, int n) {
        // write code here
        if (arr == null || arr.length == 0)
            return -1;
        int left = 0;
        int right = n - 1;
        int mid;
        int result = -1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (arr[mid] == mid) { // 继续搜索左边
                result = mid;
                right = mid - 1;
            } else if (arr[mid] > mid) // 由于数组有序，从左往右元素每次递增>=1，下标每次递增1，所以右边不会出现arr[i]==i的情况
                right = mid - 1;
            else // 由于数组有序，从右往左元素每次递减>=1，下标每次递减1，所以左边不会出现arr[i]==i的情况
                left = mid + 1;
        }

        return result;
    }
}

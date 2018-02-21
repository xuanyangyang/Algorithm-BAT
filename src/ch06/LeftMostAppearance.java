package ch06;

/**
 * 6.3
 * 对于一个有序数组arr，再给定一个整数num，请在arr中找到num这个数出现的最左边的位置。
 * 给定一个数组arr及它的大小n，同时给定num。请返回所求位置。若该元素在数组中未出现，请返回-1。
 * 测试样例：
 * [1,2,3,3,4],5,3
 * 返回：2
 */
public class LeftMostAppearance {
    public int findPos(int[] arr, int n, int num) {
        // write code here
        if (arr == null || n == 0)
            return -1;

        int left = 0;
        int right = n - 1;
        int mid;
        int result = -1;

        while (left <= right) {
            mid = left + (right - left) / 2;
            // 如果找到num，则对其左边继续搜索
            if (arr[mid] == num) {
                result = mid;
                right = mid - 1;
            } else if (arr[mid] > num)
                right = mid - 1;
            else
                left = mid + 1;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] data = {1, 2, 3, 3, 4};
        LeftMostAppearance leftMostAppearance = new LeftMostAppearance();
        int result = leftMostAppearance.findPos(data, data.length, 4);
        System.out.println(result);
    }
}

package ch02;


/**
 * 2.20
 * 有一个整形数组A，请设计一个复杂度为O(n)的算法，算出排序后相邻两数的最大差值。
 * 给定一个int数组A和A的大小n，请返回最大的差值。保证数组元素多于1个。
 */
public class Gap {
    public int maxGap(int[] nums, int n) {
        // write code here
        if (nums == null || nums.length < 2)
            return 0;

        int len = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        if (max == min)
            return 0;

        boolean[] hasNums = new boolean[len + 1];
        int[] maxs = new int[len + 1];
        int[] mins = new int[len + 1];
        int bid;

        for (int num : nums) {
            bid = bucket(num, len, min, max);
            mins[bid] = hasNums[bid] ? Math.min(mins[bid], num) : num;
            maxs[bid] = hasNums[bid] ? Math.max(maxs[bid], num) : num;
            hasNums[bid] = true;
        }

        int lastMax = 0;
        int index = 0;

        while (index <= len) {
            if (hasNums[index]) {
                lastMax = maxs[index];
                break;
            }
            index++;
        }

        int result = 0;
        while (index <= len) {
            if (hasNums[index]) {
                result = Math.max(result, mins[index] - lastMax);
                lastMax = maxs[index];
            }
            index++;
        }

        return result;
    }

    // 使用long类型是为了防止相乘时溢出
    public int bucket(long num, long len, long min, long max) {
        return (int) ((num - min) * len / (max - min));
    }
}

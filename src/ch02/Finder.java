package ch02;

/**
 * 2.18
 * 现在有一个行和列都排好序的矩阵，请设计一个高效算法，快速查找矩阵中是否含有值x。
 * 给定一个int矩阵mat，同时给定矩阵大小nxm及待查找的数x，请返回一个bool值，代表矩阵中是否存在x。所有矩阵中数字及x均为int范围内整数。保证n和m均小于等于1000。
 */
public class Finder {
    public boolean findX(int[][] mat, int n, int m, int x) {
        // write code here
        int row = 0;
        int col = m - 1;

        while (row < n && col >= 0) {
            if (mat[row][col] == x)
                return true;
            // 比它大往下走
            else if (x <= mat[row][col]) {
                col--;
            }
            // 比它小往左走
            else if (x >= mat[row][col]) {
                row++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {109, 204, 260, 270},
                {452, 602, 671, 917},
                {1106, 1343, 1467, 1585},
                {1627, 1866, 1948, 1980},
                {2108, 2164, 2295, 2577},
                {2681, 2749, 2915, 3026},
                {3187, 3250, 3465, 3518},
                {3562, 3773, 3966, 4101}
        };
        Finder finder = new Finder();
        boolean result = finder.findX(arr, 8, 4, 2108);
        System.out.println(result);
    }
}

package ch03;

/**
 * 3.7
 * 对于一个字符串，请设计一个算法，将字符串的长度为len的前缀平移到字符串的最后。
 * 给定一个字符串A和它的长度，同时给定len，请返回平移后的字符串。
 */
public class Translation {
    public String stringTranslation(String A, int n, int len) {
        // write code here
        char[] chars = A.toCharArray();

        reverse(chars, 0, len - 1);
        reverse(chars, len, n - 1);
        reverse(chars, 0, n - 1);

        return String.valueOf(chars);
    }

    public void reverse(char[] chars, int start, int end) {
        while (start < end) {
            swap(chars, start, end);
            start++;
            end--;
        }
    }

    public void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}

package ch03;

/**
 * 3.12
 * 对于一个字符串,请设计一个高效算法，找到字符串的最长无重复字符的子串长度。
 * 给定一个字符串A及它的长度n，请返回它的最长无重复字符子串长度。保证A中字符全部为小写英文字符，且长度小于等于500。
 */
public class DistinctSubstring {
    public int longestSubstring(String A, int n) {
        if (A == null || n == 0) {
            return 0;
        }

        int[] map = new int[256];
        for (int i = 0; i < 256; i++)
            map[i] = -1;

        char[] chars = A.toCharArray();
        int len = 0;
        int pre = -1;//之前出现的地方
        int cur;//当前最长无重复字符子串长度

        for (int i = 0; i < chars.length; i++) {
            pre = Math.max(pre, map[chars[i]]);
            cur = i - pre;
            len = Math.max(len, cur);
            map[chars[i]] = i;
        }

        return len;
    }

    public static void main(String[] args) {
        String str = "abcdec";
        DistinctSubstring distinctSubstring = new DistinctSubstring();
        int len = distinctSubstring.longestSubstring(str, str.length());
        System.out.println(len);
    }

}

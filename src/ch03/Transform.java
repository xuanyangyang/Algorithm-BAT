package ch03;

/**
 * 3.3
 * 对于两个字符串A和B，如果A和B中出现的字符种类相同且每种字符出现的次数相同，则A和B互为变形词，请设计一个高效算法，检查两给定串是否互为变形词。
 * 给定两个字符串A和B及他们的长度，请返回一个bool值，代表他们是否互为变形词。
 */
public class Transform {
    public boolean chkTransform(String str1, int lena, String str2, int lenb) {
        // write code here
        if (str1 == null || str2 == null || lena != lenb)
            return false;

        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        int[] map = new int[256];

        for (char char1 : chars1)
            map[char1]++;

        for (char char2 : chars2) {
            if (map[char2]-- == 0)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Transform transform = new Transform();
        String A = "DHJSKTQHEIXDEOE";
        String B = "XHIHOQSDTDEEJEK";
        boolean result = transform.chkTransform(A, 15, B, 15);
        System.out.println(result);
    }
}

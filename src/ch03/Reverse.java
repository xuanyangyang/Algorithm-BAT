package ch03;

/**
 * 3.6
 * 对于一个字符串，请设计一个算法，只在字符串的单词间做逆序调整，也就是说，字符串由一些由空格分隔的部分组成，你需要将这些部分逆序。
 * 给定一个原字符串A和他的长度，请返回逆序后的字符串。
 */
public class Reverse {
    public String reverseSentence(String A, int n) {
        // write code here
        char[] chars = A.toCharArray();

        // 反转整个字符串
        reverse(chars, 0, chars.length - 1);
        int l = -1;
        int r = -1;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ') {
                if (i == 0 || chars[i - 1] == ' ')  // 寻找需要局部反转的单词的起始下标
                    l = i;
                if (i == chars.length - 1 || chars[i + 1] == ' ')  // 寻找需要局部反转的单词的末尾下标
                    r = i;
            }
            if (l != -1 && r != -1) {
                reverse(chars, l, r);
                l = -1;
                r = -1;
            }
        }

        return String.valueOf(chars);
    }

    // 反转字符串
    public void reverse(char[] chars, int start, int end) {
        while (start < end) {
            swap(chars, start, end);
            start++;
            end--;
        }
    }

    // 交换
    public void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void main(String[] args) {
        Reverse reverse = new Reverse();
        String result = reverse.reverseSentence("dog loves pig", 13);
        System.out.println(result);
    }

}

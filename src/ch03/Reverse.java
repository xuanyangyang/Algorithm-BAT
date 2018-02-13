package ch03;

/**
 * 3.6
 * 对于一个字符串，请设计一个算法，只在字符串的单词间做逆序调整，也就是说，字符串由一些由空格分隔的部分组成，你需要将这些部分逆序。
 * 给定一个原字符串A和他的长度，请返回逆序后的字符串。
 */
public class Reverse {
    public String reverseSentence(String A, int n) {
        // write code here
        StringBuilder result = new StringBuilder(reverseSingle(A.toCharArray()));
        String[] results = result.toString().split(" ");
        result = new StringBuilder();
        for (int i = 0; i < results.length; i++){
            result.append(reverseSingle(results[i].toCharArray()));
            if(i!= results.length-1)
                result.append(" ");
        }

        return result.toString();
    }

    public String reverseSingle(char[] chars) {
        int mid = chars.length / 2;
        for (int i = 0; i < mid; i++) {
            swap(chars, i, chars.length - i - 1);
        }
        return String.valueOf(chars);
    }

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

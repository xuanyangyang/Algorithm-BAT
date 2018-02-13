package ch03;

/**
 * 3.11
 * 对于一个字符串，请设计一个算法，判断其是否为一个合法的括号串。
 * 给定一个字符串A和它的长度n，请返回一个bool值代表它是否为一个合法的括号串。
 */
public class Parenthesis {
    public boolean chkParenthesis(String A, int n) {
        // write code here
        int num = 0;

        char[] chars = A.toCharArray();
        for (char ch : chars) {
            if (ch == '(')
                num++;
            if (ch == ')')
                num--;
            if (num < 0)
                return false;
        }

        return num == 0;
    }
}

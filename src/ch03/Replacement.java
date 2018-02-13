package ch03;

/**
 * 3.10
 * 请编写一个方法，将字符串中的空格全部替换为“%20”。假定该字符串有足够的空间存放新增的字符，并且知道字符串的真实长度(小于等于1000)，同时保证字符串由大小写的英文字母组成。
 * 给定一个string iniString 为原始的串，以及串的长度 int len, 返回替换后的string。
 * 关键点：从后往前替换
 */
public class Replacement {
    public String replaceSpace(String iniString, int length) {
        // write code here
        if (iniString == null || iniString.length() == 0)
            return iniString;

        char[] chars = iniString.toCharArray();
        int space = 0;
        for (char ch : chars)
            if (ch == ' ')
                space++;

        int resultLen = length + space * 2;
        char[] result = new char[resultLen];
        for (int i = length - 1; i >= 0; i--) {
            if (chars[i] == ' ') {
                result[--resultLen] = '0';
                result[--resultLen] = '2';
                result[--resultLen] = '%';
            } else
                result[--resultLen] = chars[i];
        }

        return String.valueOf(result);
    }

}

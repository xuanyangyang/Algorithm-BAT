package ch03;

import java.util.Arrays;

/**
 * 3.8
 * 对于一个给定的字符串数组，请找到一种拼接顺序，使所有小字符串拼接成的大字符串是所有可能的拼接中字典序最小的。
 * 给定一个字符串数组strs，同时给定它的大小，请返回拼接成的串。
 * 关键点：a+b < b+a 则a在前，b在后
 */
public class Prior {
    public String findSmallest(String[] strs, int n) {
        // write code here
        if (strs == null)
            return null;
        if (strs.length == 1)
            return strs[0];

        Arrays.sort(strs, (a, b) -> (a + b).compareTo(b + a));
        String result = "";
        for (int i = 0; i < strs.length; i++)
            result += strs[i];

        return result;
    }

}

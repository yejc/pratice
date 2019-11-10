package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    /**
     * 反转字符串
     *
     * @param s
     */
    public void reverseString(char[] s) {
        int n = s.length;
        for (int i = 0; i < n / 2; i++) {
            char tmp = s[i];
            s[i] = s[n - 1 - i];
            s[n - 1 - i] = tmp;
        }
    }

    /**
     * 整数反转
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     *
     * @param x
     * @return
     */
    public int reverse(int x) {
        int result = 0, a = 0;
        while (x != 0) {
            a = x % 10;
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && a > Integer.MAX_VALUE % 10)) {
                return 0;
            }
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && a < Integer.MIN_VALUE % 10)) {
                return 0;
            }
            result = result * 10 + a;
            x = x / 10;
        }
        return result;
    }

    /**
     * 字符串中的第一个唯一字符
     *
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        // 一次遍历，如果map存在当前字符，则移除indexs中的当前下标，否则往indexs中插入当前下标
        // 最后如果indexs为空，说明不存在第一个唯一字符，返回-1，否则返回第一个元素
        if (s == null || s.length() == 0) {
            return -1;
        }
        List<Integer> indexs = new ArrayList<>(s.length());
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                indexs.remove(map.get(s.charAt(i)));
            } else {
                indexs.add(i);
            }
            map.put(s.charAt(i), i);
        }
        return indexs.size() == 0 ? -1 : indexs.get(0);
    }

}

package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2 {
    /**
     * 反转字符串
     *
     * @param s
     */
    public void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char tmp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = tmp;
        }
    }

    /**
     * 整数反转
     *
     * @param x
     * @return
     */
    public int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            int a = x % 10;
            if (ans > Integer.MAX_VALUE / 10
                    || ans < Integer.MIN_VALUE / 10
                    || (ans == Integer.MAX_VALUE / 10 && a > Integer.MAX_VALUE % 10)
                    || (ans == Integer.MIN_VALUE / 10 && a < Integer.MIN_VALUE % 10)) {
                return 0;
            }
            ans = ans * 10 + a;
            x = x / 10;

        }
        return ans;
    }

    /**
     * 字符串中的第一个唯一字符
     *
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        List<Integer> list = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Integer index = map.get(s.charAt(i));
            if (index == null) {
                list.add(i);
            } else {
                list.remove(map.get(s.charAt(i)));
            }
            map.put(s.charAt(i), i);
        }
        return list.isEmpty() ? -1 : list.get(0);
    }

    /**
     * 有效的字母异位词
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            if (!map.containsKey(t.charAt(i))) {
                return false;
            }
            map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
            if (map.get(t.charAt(i)) == 0) {
                map.remove(t.charAt(i));
            }
        }
        return map.isEmpty();
    }

    /**
     * 验证回文字符串
     *
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return true;
        }
        int i = 0, j = s.length() - 1;
        while (i < j) {
            while (i < s.length() && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while (j >= 0 && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            if (i < j && Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    /**
     * 实现 strStr()
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
                if (j == needle.length() - 1) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * 最长公共前缀
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != c) {
                    return sb.toString();
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }
}

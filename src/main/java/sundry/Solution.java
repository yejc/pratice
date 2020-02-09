package sundry;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yejc
 * @date 2020/2/9 17:28
 */
public class Solution {
    /**
     * 最长公共前缀
     * 编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，返回空字符串 ""。
     *
     * @param strs
     * @return
     */
    public String longestPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            minLength = Math.min(str.length(), minLength);
        }
        String res = "";
        for (int i = 0; i < minLength; i++) {
            char tmp = strs[0].charAt(i);
            boolean flag = true;
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != tmp) {
                    return res;
                }
                if (j == strs.length - 1) {
                    res += tmp;
                }
            }
        }
        return res;
    }

    /**
     * 最长回文串
     * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。在构造过程中，请注意区分大小写。比如"Aa"不能当做一个回文字符串。注 意:假设字符串的长度不会超过 1010。
     * 输入:
     * "abccccdd"
     * <p>
     * 输出:
     * 7
     * <p>
     * 解释:
     * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
     *
     * @param s
     * @return
     */
    public int longestPalindrome(String s) {
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        boolean isOdd = false;// 是否存在奇数个的字母
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                isOdd = true;
                res += entry.getValue() - 1;
            } else {
                res += entry.getValue();
            }
        }
        return isOdd ? res + 1 : res;
    }

    /**
     * 验证回文串
     * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 说明：本题中，我们将空字符串定义为有效的回文串。
     * 示例 1:
     * 输入: "A man, a plan, a canal: Panama"
     * 输出: true
     *
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int i = 0, j = s.length() - 1;
        while (i < j) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            if (i >= j) {
                break;
            }
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    /**
     * 最长回文子串
     * 最长回文子串 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
     * 示例 1：
     * 输入: "babad"
     * 输出: "bab"
     * 注意: "aba"也是一个有效答案。
     *
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        if (s.length() == 0) {
            return "";
        }
        // 中心扩展法
        int len = 0;
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = longestPalindromeHelper(s, i, i);
            int len2 = longestPalindromeHelper(s, i, i + 1);
            int maxLen = Math.max(len1, len2);
            if (maxLen > len) {
                start = i - (maxLen - 1) / 2;
                end = i + maxLen / 2;
                len = maxLen;
            }
        }
        return s.substring(start, end + 1);
    }

    private int longestPalindromeHelper(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }


    // 测试
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome2("babad"));// c
    }
}

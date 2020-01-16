package leetcode.middle.backtracking;

import java.util.*;

/**
 * @author yejc
 * @date 2020/1/16 21:43
 */
public class Solution2 {
    /**
     * 电话号码的字母组合
     *
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }

        Map<Character, List<String>> map = new HashMap<>();
        map.put('2', Arrays.asList("a", "b", "c"));
        map.put('3', Arrays.asList("d", "e", "f"));
        map.put('4', Arrays.asList("g", "h", "i"));
        map.put('5', Arrays.asList("j", "k", "l"));
        map.put('6', Arrays.asList("m", "n", "o"));
        map.put('7', Arrays.asList("p", "q", "r", "s"));
        map.put('8', Arrays.asList("t", "u", "v"));
        map.put('9', Arrays.asList("w", "x", "y", "z"));

        letterCombinationsHelper(digits, 0, "", result, map);
        return result;
    }

    private void letterCombinationsHelper(String digits, int i, String str, List<String> result, Map<Character, List<String>> map) {
        if (i == digits.length()) {
            result.add(str);
            return;
        }
        char c = digits.charAt(i);
        List<String> list = map.get(c);
        for (String s : list) {
            letterCombinationsHelper(digits, i + 1, str + s, result, map);
        }
    }
}

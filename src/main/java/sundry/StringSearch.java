package sundry;

/**
 * 字符串搜索
 *
 * @program: pratice
 * @description:
 * @author: yejc
 * @create: 2020-02-21 13:48
 **/
public class StringSearch {
    public boolean search(String text, String str) {
        for (int i = 0; i <= text.length() - str.length(); i++) {
            for (int j = 0; j < str.length(); j++) {
                if (text.charAt(i + j) != str.charAt(j)) {
                    break;
                }
                if (j == str.length() - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        StringSearch stringSearch = new StringSearch();
        boolean index = stringSearch.search("abc", "bc2");
        System.out.println(index);
    }
}

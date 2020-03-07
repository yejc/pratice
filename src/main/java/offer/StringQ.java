package offer;

/**
 * @author yejc
 * @date 2020/3/7 13:37
 */
public class StringQ {

    /**
     * 替换空格为%20
     *
     * @param strs
     */
    public void replaceBlank(char[] strs, int length) {
        if (strs == null || length == 0) {
            return;
        }
        int p1 = length - 1, p2 = strs.length - 1;
        while (p1 >= 0) {
            if (strs[p1] == ' ') {
                strs[p2--] = '0';
                strs[p2--] = '2';
                strs[p2--] = '%';
                p1--;
            } else {
                strs[p2--] = strs[p1--];
            }
        }
    }

    public static void main(String[] args) {
        StringQ stringQ = new StringQ();
        String s = "We are happy.";
        char[] strs = new char[s.length() + 4];
        for (int i = 0; i < s.length(); i++) {
            strs[i] = s.charAt(i);
        }
        stringQ.replaceBlank(strs, s.length());
        System.out.println(strs);
    }

}

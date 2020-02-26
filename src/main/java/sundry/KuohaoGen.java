package sundry;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 *
 * @program: pratice
 * @description:
 * @author: yejc
 * @create: 2020-02-22 22:52
 **/
public class KuohaoGen {

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generateParenthesisHelper(list, "", n, n);
        return list;
    }

    private void generateParenthesisHelper(List<String> list, String letter, int left, int right) {
        if (right == 0) {
            list.add(letter);
            return;
        }
        if (left > 0) {
            generateParenthesisHelper(list, letter + "(", left - 1, right);
        }
        if (right > left) {
            generateParenthesisHelper(list, letter + ")", left, right - 1);
        }
    }

    public static void main(String[] args) {
        KuohaoGen kuohaoGen = new KuohaoGen();
        List<String> list = kuohaoGen.generateParenthesis(3);
        System.out.println(list);
    }
}

package sundry;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author yejc
 * @date 2020/2/17 18:01
 */
public class TaskSeq {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String string = in.nextLine();
        String[] result = string.split(",");
        LinkedList<Integer> a = new LinkedList<Integer>();
        LinkedList<Integer> b = new LinkedList<Integer>();
        for (int i = 0; i < result.length; i++) {
            b.add(i);
            a.add(Integer.valueOf(result[i].trim()));
        }
        System.out.println("原数组：" + a);
        System.out.println("原下标：" + b);
        sort(a, b);
        System.out.println("新数组：" + a);
        System.out.println("新下标：" + b);
    }

    public static void sort(LinkedList<Integer> a, LinkedList<Integer> b) {
        for (int i = 0; i < a.size(); i++) {
            for (int j = i + 1; j < a.size(); j++) {
                if (a.get(i) < a.get(j)) {
                    a.add(a.remove(i));
                    b.add(b.remove(i));
                    i -= 1;
                    break;
                }
            }
        }
    }
}

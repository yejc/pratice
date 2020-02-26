package sundry;

import java.util.*;

public class add2 {
    public static void addThreeNumbers(ArrayList<Integer> lst, int a, int b, int c) {
        lst.add(a);
        lst.add(b);
        lst.add(c);
        lst.add(a * 10 + b);
        lst.add(a * 10 + c);
        lst.add(b * 10 + a);
        lst.add(b * 10 + c);
        lst.add(c * 10 + a);
        lst.add(c * 10 + b);

        lst.add(a * 100 + b * 10 + c);
        lst.add(a * 100 + c * 10 + b);
        lst.add(b * 100 + a * 10 + c);
        lst.add(b * 100 + c * 10 + a);
        lst.add(c * 100 + b * 10 + a);
        lst.add(c * 100 + a * 10 + b);
    }

    public static void remove(ArrayList<Integer> lst) {     //去除重复数字
        Set<Integer> set = new HashSet<Integer>();
        for (Integer x : lst)
            set.add(x);
        lst.removeAll(lst);
        for (Integer x : set)
            lst.add(x);
    }

    public static boolean check(String line) {        //判断输入的字符是否为合法的字符：只能为数字和，
        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            if (!(Character.isDigit(ch) || ch == ','))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String line = scan.nextLine();
        String[] numbers = line.split(",");
        if (!check(line) || numbers.length != 3) {
            System.out.println(-1);
            return;
        }
        int a = 0, b = 0, c = 0;
        try {
            a = Integer.parseInt(numbers[0]);
            b = Integer.parseInt(numbers[1]);
            c = Integer.parseInt(numbers[2]);
        } catch (Exception ex) {
            System.out.println(-1);
            return;
        }

        if (a <= 0 || a > 9 || b <= 0 || b > 9 || c <= 0 || c > 9) {
            System.out.println(-1);
            return;
        }

        if (a == b || a == c || b == c) {       //判断是否有相同数字的情况
            System.out.println(-1);
            return;
        }

        Set<Integer> set = new HashSet<>();    //判断是否有同时存在2和5、6和9的情况
        set.add(a);
        set.add(b);
        set.add(c);
        if ((set.contains(2) && set.contains(5)) || (set.contains(6) && set.contains(9))) {
            System.out.println(-1);
            return;
        }
//        int m = -1;
//        if(s.contains(2))
//            m = 5;
//        if(s.contains(6))
//            m = 9;

        int max = Math.max(a, Math.max(c, b));

        ArrayList<Integer> lst = new ArrayList<>();

        addThreeNumbers(lst, a, b, c);          // 对2和5、6和9的转换
        if (a == 2 || a == 5)
            addThreeNumbers(lst, 7 - a, b, c);
        if (b == 2 || b == 5)
            addThreeNumbers(lst, a, 7 - b, c);
        if (c == 2 || c == 5)
            addThreeNumbers(lst, a, b, 7 - c);

        if (a == 6 || a == 9)
            addThreeNumbers(lst, 15 - a, b, c);
        if (b == 6 || b == 9)
            addThreeNumbers(lst, a, 15 - b, c);
        if (c == 6 || c == 9)
            addThreeNumbers(lst, a, b, 15 - c);

        //考虑2和6、9或者5和6、9同时存在的情况
        if ((set.contains(2) || set.contains(5)) && (set.contains(6) || set.contains(9))) {
            int x = set.contains(2) ? 2 : 5;
            int y = set.contains(6) ? 6 : 9;
            int z = a + b + c - x - y;
            addThreeNumbers(lst, 7 - x, 15 - y, z);
        }

        remove(lst);

        Collections.sort(lst);
//        System.out.println(lst);
        System.out.println(lst.get(max - 1));
    }
}
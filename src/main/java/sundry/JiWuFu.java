package sundry;

import java.util.*;

/**
 * 题目：以0和1组成的长度为5的字符串代表每个人所得到的福卡，每一位代表一种福卡，1表示已经获得该福卡，单类型福卡不超过1张，随机抽取一个小于10人团队，求该团队最多可以集齐多少套五福？
 *
 * @author yejc
 * @date 2020/2/17 18:04
 */
public class JiWuFu {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < 10; i++) {
                String input = scan.next();
                char[] chs = input.toCharArray();
                for (int j = 0; j < chs.length; j++) {
                    if (chs[j] == '1') {
                        if (map.get(j) != null && map.get(j) > 0) {
                            map.put(j, map.get(j) + 1);
                        } else {
                            map.put(j, 1);
                        }
                    }
                }
            }
            //map中value值最小的就是最多能集齐的套数
            List<Integer> list = new ArrayList<>(map.values());
            Collections.sort(list);
            System.out.println(list.get(0));
        }
    }
}

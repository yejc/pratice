package sundry;

import java.util.*;

/**
 * 抢票系统
 * 标题：抢票系统 | 时间限制：1秒 | 内存限制：32768K | 语言限制：不限
 * 输入年月日时分秒，输出多少人能抢到票；
 * 规则：
 * （1） 同一秒内，若时间不同，选最早的，若存在时间相同，选择多个；
 * （2） 不同时间，选则时间最早的；
 * 收起
 * 输入描述:
 * n行字符串
 * 输出描述:
 * 整数
 * 示例1
 * 输入
 * 1992-08-20 12:12:12.001
 * 1992-08-20 12:12:12.003
 * 1992-08-20 12:12:12.203
 * 1992-08-21 12:12:12.001
 * 1992-08-21 12:12:12.003
 * 输出
 * 2
 * <p>
 * 说明
 * 1992-08-20 12:12:12.001   8月20号12点12分12秒，这一秒内最早的
 * 1992-08-21 12:12:12.001   8月21号12点12分12秒，这一秒内最早的
 *
 * @author yejc
 * @date 2020/2/17 14:01
 */
public class QiangPiao {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            List<String> subList = map.getOrDefault(s.substring(0, 19), new ArrayList<>());
            subList.add(s);
            map.put(s.substring(0, 19), subList);
        }

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            List<String> value = entry.getValue();
            Collections.sort(value);
            String first = value.get(0);
            System.out.println(first);
            for (int i = 1; i < value.size(); i++) {
                if(!value.get(i).equals(first)){
                    break;
                }
                System.out.println(value.get(0));
            }
        }
    }
}

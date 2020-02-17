package sundry;

import java.util.Scanner;

/**
 * JS如何判断一组数字是否连续
 * 标题：JS如何判断一组数字是否连续 | 时间限制：1秒 | 内存限制：32768K | 语言限制：不限
 * 判断一组数字是否连续
 * 当出现连续数字的时候以‘-’输出，比如：对于数组[1, 2, 3, 4, 6, 8, 9, 10]，期望输出：["1-4", 6, "8-10"]
 * 输入描述:
 * 数字数组：比如[1, 2, 3, 4, 6, 8, 9, 10]
 * 输出描述:
 * 对于连续的用'-‘拼接，其他的输出原数字["1-4", 6, "8-10"]
 * 示例1
 * 输入
 * 1,2,3,4,6,8,9,10
 * 输出
 * 1-4,6,8-10
 *
 * @author yejc
 * @date 2020/2/17 10:11
 */
public class JudgecontinuousArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] splits = line.split(",");
        System.out.print(splits[0]);
        boolean isContinue = false;
        for (int i = 1; i < splits.length; i++) {
            if (Integer.parseInt(splits[i]) == Integer.parseInt(splits[i - 1]) + 1) {
                isContinue = true;
                if (i == splits.length - 1) {
                    System.out.print("-" + splits[i]);
                }
            } else {
                if (isContinue) {
                    System.out.print("-" + splits[i - 1]);
                }
                System.out.print(",");
                System.out.print(splits[i]);
                isContinue = false;
            }
        }
    }
}

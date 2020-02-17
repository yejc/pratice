package sundry;

import java.util.Scanner;

/**
 * 九宫格按键输入
 * 标题：九宫格按键输入 | 时间限制：1秒 | 内存限制：32768K | 语言限制：不限
 * 九宫格按键输入，判断输出，有英文和数字两个模式，默认是数字模式，数字模式直接输出数字，英文模式连续按同一个按键会依次出现这个按键上的字母，如果输入"/"或者其他字符，则循环中断
 * 1（,.）2（abc）3（def）
 * 4（ghi）5（jkl）6（mno）
 * 7（pqrs）8（tuv）9（wxyz）
 * # 0（空格）/
 * 要求输入一串按键，输出屏幕显示
 * 输入描述:
 * 输入范围为数字0~9和字符 '#'、’/’，输出屏幕显示，例如，
 * 在数字模式下，输入1234，显示 1234
 * 在英文模式下，输入1234，显示 ,adg
 * 输出描述:
 * 1、#用于切换模式，默认是数字模式，执行#后切换为英文模式；
 * 2、/表示延迟，例如在英文模式下，输入22/222，显示为bc；
 * 3、英文模式下，多次按同一键，例如输入22222，显示为b；
 * 示例1
 * 输入
 * 123#222235/56
 * 输出
 * 123adjjm
 *
 * @author yejc
 * @date 2020/2/17 14:34
 */
public class JiuGongGe {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = "";
        String next = sc.next();
        input += next;
        // 将相同字符分在一组，中间以空格分割
        String s = "";
        int index = 1;
        s += input.charAt(0);
        while (index < input.length()) {
            if (input.charAt(index) != input.charAt(index - 1)) {
                s += " ";
            }
            s += input.charAt(index);
            index++;
        }
        String[] split = s.split(" ");
        int mod = 1;
        for (String item : split) {
            if ("#".equals(item)) {
                if (mod == 1) {
                    mod = 2;
                } else {
                    mod = 1;
                }
            } else if ("/".equals(item)) {
                continue;
            } else {
                if (mod == 1) {
                    System.out.print(item);
                } else {
                    switch (item.charAt(0)) {
                        case '0':
                            System.out.print(" ");
                            break;
                        case '1':
                            if (item.length() % 2 == 1) {
                                System.out.print(",");
                            } else if (item.length() % 2 == 0) {
                                System.out.print(' ');
                            }
                            break;
                        case '2':
                            if (item.length() % 3 == 1) {
                                System.out.print("a");
                            } else if (item.length() % 3 == 2) {
                                System.out.print('b');
                            } else {
                                System.out.print("c");
                            }
                            break;
                        case '3':
                            if (item.length() % 3 == 1) {
                                System.out.print("d");
                            } else if (item.length() % 3 == 2) {
                                System.out.print('e');
                            } else {
                                System.out.print("f");
                            }
                            break;
                        case '4':
                            if (item.length() % 3 == 1) {
                                System.out.print("g");
                            } else if (item.length() % 3 == 2) {
                                System.out.print('h');
                            } else {
                                System.out.print("i");
                            }
                            break;
                        case '5':
                            if (item.length() % 3 == 1) {
                                System.out.print("j");
                            } else if (item.length() % 3 == 2) {
                                System.out.print('k');
                            } else {
                                System.out.print("l");
                            }
                            break;
                        case '6':
                            if (item.length() % 3 == 1) {
                                System.out.print("m");
                            } else if (item.length() % 3 == 2) {
                                System.out.print('n');
                            } else {
                                System.out.print("o");
                            }
                            break;
                        case '7':
                            if (item.length() % 4 == 1) {
                                System.out.print("p");
                            } else if (item.length() % 4 == 2) {
                                System.out.print('q');
                            } else if (item.length() % 4 == 3) {
                                System.out.print("r");
                            } else {
                                System.out.print("s");
                            }
                            break;
                        case '8':
                            if (item.length() % 3 == 1) {
                                System.out.print("t");
                            } else if (item.length() % 3 == 2) {
                                System.out.print('u');
                            } else {
                                System.out.print("v");
                            }
                            break;
                        case '9':
                            if (item.length() % 4 == 1) {
                                System.out.print("w");
                            } else if (item.length() % 4 == 2) {
                                System.out.print('x');
                            } else if (item.length() % 4 == 3) {
                                System.out.print("y");
                            } else {
                                System.out.print("z");
                            }
                            break;
                    }
                }
            }
        }
    }
}

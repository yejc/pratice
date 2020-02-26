package sundry.huawei;

import java.util.Scanner;

/**
 * @program: pratice
 * @description:
 * @author: yejc
 * @create: 2020-02-17 20:07
 **/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        // 重复的字符为一组，以空格分割
        StringBuilder s = new StringBuilder(String.valueOf(line.charAt(0)));
        int i = 1;
        while (i < line.length()) {
            if (line.charAt(i) != line.charAt(i - 1)) {
                s.append(" ");
            }
            s.append(line.charAt(i));
            i++;
        }

        String[] split = s.toString().split(" ");
        int mod = 1;// 1为数字模式，2为英文模式
        for (String item : split) {
            if ("#".equals(item)) {
                mod = mod == 1 ? 2 : 1;
            } else if (!"/".equals(item)) {
                if (mod == 1) {
                    System.out.print(item);
                } else {
                    int n = item.length();
                    switch (item.charAt(0)) {
                        case '1':
                            if (n % 2 == 1) {
                                System.out.print(",");
                            } else {
                                System.out.print(".");
                            }
                            break;
                        case '2':
                            if (n % 3 == 1) {
                                System.out.print("a");
                            } else if (n % 3 == 2) {
                                System.out.print("b");
                            } else {
                                System.out.print("c");
                            }
                            break;
                        case '3':
                            if (n % 3 == 1) {
                                System.out.print("d");
                            } else if (n % 3 == 2) {
                                System.out.print("e");
                            } else {
                                System.out.print("f");
                            }
                            break;
                        case '4':
                            if (n % 3 == 1) {
                                System.out.print("g");
                            } else if (n % 3 == 2) {
                                System.out.print("h");
                            } else {
                                System.out.print("i");
                            }
                            break;
                        case '5':
                            if (n % 3 == 1) {
                                System.out.print("j");
                            } else if (n % 3 == 2) {
                                System.out.print("k");
                            } else {
                                System.out.print("l");
                            }
                            break;
                        case '6':
                            if (n % 3 == 1) {
                                System.out.print("m");
                            } else if (n % 3 == 2) {
                                System.out.print("n");
                            } else {
                                System.out.print("o");
                            }
                            break;
                        case '7':
                            if (n % 4 == 1) {
                                System.out.print("p");
                            } else if (n % 4 == 2) {
                                System.out.print("q");
                            } else if (n % 4 == 3) {
                                System.out.print("r");
                            } else {
                                System.out.print("s");
                            }
                            break;
                        case '8':
                            if (n % 3 == 1) {
                                System.out.print("t");
                            } else if (n % 3 == 2) {
                                System.out.print("u");
                            } else {
                                System.out.print("v");
                            }
                            break;
                        case '9':
                            if (n % 4 == 1) {
                                System.out.print("w");
                            } else if (n % 4 == 2) {
                                System.out.print("x");
                            } else if (n % 4 == 3) {
                                System.out.print("y");
                            } else {
                                System.out.print("z");
                            }
                            break;
                        default:
                    }
                }
            }
        }
    }
}

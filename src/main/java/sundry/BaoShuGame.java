package sundry;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class BaoShuGame {


    /**
     *  报数游戏 
     * 有n个孩子站成一圈，从第一个孩子开始顺时针方向报数，报到3的人出列，下一个人继续从1报数， 
     * 直到最后剩下一个孩子为止。问剩下第几个孩子。下面的程序以n（可以自己输入）个孩子为例，报到m（可以自己输入）的出列。模拟了这个过程， 
     *  
     */
    public static void main(String[] args) {
// TODO Auto-generated method stub
        List list = new ArrayList<>();


        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入人数：");
        int n = scanner.nextInt();
        System.out.print("请输入报到m的出列（m）：");
        int m = scanner.nextInt();

//初始化list列表
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        numberOff(list, m);
    }


    public static void numberOff(List list, int m) {
        /**
         * 
         * remove(int index)用来清除集合中制定索引位置的对象，后面的元素自动全部向前移动
         * void add(int index, E element) index - 要在其中插入指定元素处的索引    element - 要插入的元素
         * index可省略 ，但是添加元素的时候，需要添加到已有数据的后面*/
        while (list.size() > 1) {
            for (int i = 0; i < m - 1; i++) {
                list.add(list.remove(0));
            }
            System.out.println("移除：" + list.remove(0));
        }
        System.out.println("剩下最后一个人：" + list);
    }
}
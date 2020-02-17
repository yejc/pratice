package sundry;

/**
 * @author yejc
 * @date 2020/2/17 19:56
 */
public class Fenzidan {
    public static void fenZiDan(int[] shibing) {
        int total = 0;//子弹总数
        int times = 0;//次数
        int[] temp = new int[shibing.length];//临时记录士兵第一次交出子弹后的数量
        for (int i = 0; i < shibing.length; i++) {
            total += shibing[i];
        }
        while (true) {//循环执行任务
            times++;
            for (int i = 0; i < shibing.length; i++) {
                if (shibing[i] % 2 != 0) {
                    total++;//向班长要一颗子弹
                    temp[i] = (shibing[i] + 1) / 2;
                } else {
                    temp[i] = shibing[i] / 2;
                }
            }
            for (int i = 0; i < shibing.length; i++) {
                if (i > 0) {
                    shibing[i] = temp[i - 1] + temp[i];
                } else {
                    shibing[i] = temp[i] + temp[temp.length - 1];
                }
                if (i != shibing.length - 1) {
                    System.out.print(shibing[i] + " ");
                } else {
                    System.out.println(shibing[i] + " ");
                }
            }

            if (total % shibing.length == 0) {//表示可以平均分,是子弹都相等的必要不充分条件,只有此时才会进行检查
                boolean isEnd = true;
                for (int i = 1; i < shibing.length; i++) {
                    if (shibing[0] != shibing[i]) {
                        isEnd = false;
                        break;
                    }
                }
                if (isEnd) {
                    break;
                }
            }
        }
        System.out.println("总共进行了" + times + "次");
    }
}

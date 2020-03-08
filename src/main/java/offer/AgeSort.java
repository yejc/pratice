package offer;

import java.util.Arrays;

/**
 * 年龄排序
 * 规定年龄范围为0~99，可以使用一个辅助数组记录每个年龄的出现次数，数组的下标就是年龄，值为该年龄出现的次数
 *
 * @author yejc
 * @date 2020/3/8 11:13
 */
public class AgeSort {
    public void sort(int[] ages) {
        if (ages == null || ages.length == 0) {
            return;
        }
        int oldestAge = 99;
        int[] timesOfAges = new int[oldestAge + 1];
        for (int i = 0; i < ages.length; i++) {
            int age = ages[i];
            if (age < 0 || age > oldestAge) {
                throw new RuntimeException("Age is out of bound.");
            }
            timesOfAges[age]++;
        }
        int index = 0;
        for (int i = 0; i <= oldestAge; i++) {
            for (int j = 0; j < timesOfAges[i]; j++) {
                ages[index++] = i;
            }
        }
    }

    public static void main(String[] args) {
        int[] ages = {59, 8, 99, 42, 10, 18, 25};
        AgeSort ageSort = new AgeSort();
        ageSort.sort(ages);
        System.out.println(Arrays.toString(ages));
    }
}

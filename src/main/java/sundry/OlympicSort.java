package sundry;

import java.util.Scanner;

/**
 * 奥运会排行榜
 *
 * @program: pratice
 * @description:
 * @author: yejc
 * @create: 2020-02-21 20:31
 **/
public class OlympicSort {
    static class Country {
        int goldNum;
        int medalNum;
        int people;
        double goldRate;
        double medalRate;
        int rank;
        int style;

        public Country(int goldNum, int medalNum, int people) {
            this.goldNum = goldNum;
            this.medalNum = medalNum;
            this.people = people;
            goldRate = goldNum / (people * 1.0);
            medalRate = medalNum / (people * 1.0);
            rank = Integer.MAX_VALUE;
            style = Integer.MAX_VALUE;
        }
    }

    public static boolean more(Country c1, Country c2, int flag) {
        switch (flag) {
            case 1:
                return c1.goldNum > c2.goldNum;
            case 2:
                return c1.medalNum > c2.medalNum;
            case 3:
                return c1.goldRate > c2.goldRate;
            case 4:
                return c1.medalRate > c2.medalRate;
        }
        return false;
    }

    public static void selectSort(Country[] staySort, int flag) {
        int length = staySort.length;
        int max;
        Country[] temp = staySort.clone(); //克隆一下待排数组
        for (int i = 0; i < length - 1; i++) {
            max = i;
            for (int j = i + 1; j < length; j++) {
                if (more(temp[j], temp[max], flag)) {
                    max = j;
                }
            }
            if (max != i) {
                Country item = temp[i];
                temp[i] = temp[max];
                temp[max] = item;
            }
        }
        int rank = 1;
        if (temp[0].rank > rank || (temp[0].rank == rank && temp[0].style > flag)) {
            temp[0].rank = rank;
            temp[0].style = flag;
        }
        for (int i = 1; i < length; i++) {
            if (more(temp[i - 1], temp[i], flag)) {
                rank = i + 1;
            }
            if (temp[i].rank > rank || (temp[i].rank == rank && temp[i].style > flag)) {
                temp[i].rank = rank;
                temp[i].style = flag;
            }
        }

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            int n = input.nextInt();
            int m = input.nextInt();
            Country[] countries = new Country[n];
            for (int i = 0; i < n; i++) {
                countries[i] = new Country(input.nextInt(), input.nextInt(), input.nextInt());
            }
            Country[] staySort = new Country[m];
            for (int i = 0; i < m; i++) {
                staySort[i] = countries[input.nextInt()];
            }
            selectSort(staySort, 1);
            selectSort(staySort, 2);
            selectSort(staySort, 3);
            selectSort(staySort, 4);
            for (int i = 0; i < m; i++) {
                System.out.println(staySort[i].rank + ":" + staySort[i].style);
            }
            System.out.println();
        }
    }
}

package primary.math;

import java.util.*;

/**
 * @author yejc
 * @date 2019/12/23 21:31
 */
public class Solution2 {

    /**
     * Fizz Buzz
     * 写一个程序，输出从 1 到 n 数字的字符串表示。
     * <p>
     * 1. 如果 n 是3的倍数，输出“Fizz”；
     * <p>
     * 2. 如果 n 是5的倍数，输出“Buzz”；
     * <p>
     * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
     *
     * @param n
     * @return
     */
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                result.add("FizzBuzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(Integer.toString(i));
            }
        }
        return result;
    }

    /**
     * 计数质数
     *
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        boolean[] primes = new boolean[n];
        Arrays.fill(primes, true);
        for (int i = 2; i * i < n; i++) {
            for (int j = i * i; j < n; j += i) {
                if (primes[i]) {
                    primes[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (primes[i]) {
                count++;
            }
        }
        return count;
    }

    /**
     * 3的幂
     *
     * @param n
     * @return
     */
    public boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    /**
     * 罗马数字转整数
     *
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);

        int i = 0;
        int result = 0;
        while (i < s.length()) {
            if (i < s.length() - 1 && map.containsKey(s.substring(i, i + 2))) {
                result += map.get(s.substring(i, i + 2));
                i += 2;
            } else {
                result += map.get(s.substring(i, i + 1));
                i++;
            }
        }
        return result;
    }

}

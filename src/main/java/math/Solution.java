package math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: pratice
 * @description:
 * @author: yejc
 * @create: 2019-12-07 11:09
 **/
public class Solution {
    /**
     * Fizz Buzz
     *
     * @param n
     * @return
     */
    public List<String> fizzBuzz(int n) {
        if (n < 1) {
            return null;
        }
        List<String> result = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 != 0) {
                result.add("Fizz");
            } else if (i % 3 != 0 && i % 5 == 0) {
                result.add("Buzz");
            } else if (i % 3 == 0 && i % 5 == 0) {
                result.add("FizzBuzz");
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
        boolean[] isPrimes = new boolean[n];
        Arrays.fill(isPrimes, true);
        for (int i = 2; i * i < n; i++) {
            for (int j = i * i; j < n; j += i) {
                if (isPrimes[i]) {
                    isPrimes[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrimes[i]) {
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

}

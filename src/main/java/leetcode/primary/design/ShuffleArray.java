package leetcode.primary.design;

import java.util.Random;

/**
 * 打乱数组
 *
 * @program: pratice
 * @description:
 * @author: yejc
 * @create: 2019-12-04 20:42
 **/
public class ShuffleArray {
    private int[] nums;

    public ShuffleArray(int[] nums) {
        this.nums = nums;
    }

    /**
     * Resets the leetcode.primary.array to its original configuration and return it.
     */
    public int[] reset() {
        return nums;
    }

    /**
     * Returns a random shuffling of the leetcode.primary.array.
     */
    public int[] shuffle() {
        Random random = new Random();
        int n = nums.length;
        int[] shuffleArr = new int[n];
        System.arraycopy(nums, 0, shuffleArr, 0, n);
        for (int i = 0; i < n; i++) {
            int r = random.nextInt(n - i) + i;
            swap(shuffleArr, i, r);
        }
        return shuffleArr;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

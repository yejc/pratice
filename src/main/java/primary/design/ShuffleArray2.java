package primary.design;

import java.util.Random;

/**
 * Shuffle an Array
 */
public class ShuffleArray2 {
    private int[] nums;

    public ShuffleArray2(int[] nums) {
        this.nums = nums;
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return nums;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        Random random = new Random();
        int n = nums.length;
        int[] result = new int[n];
        System.arraycopy(nums, 0, result, 0, n);
        for (int i = 0; i < n; i++) {
            int r = random.nextInt(n - i) + i;
            swap(result, i, r);
        }
        return result;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

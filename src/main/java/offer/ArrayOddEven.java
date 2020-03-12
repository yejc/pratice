package offer;

import java.util.Arrays;

/**
 * 调整数组顺序使奇数位于偶数前面
 *
 * @author yejc
 * @date 2020/3/12 21:34
 */
public class ArrayOddEven {
    public void adjust(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int i = -1, j = nums.length;
        while (true) {
            while (nums[++i] % 2 == 1) {
                if (i == nums.length - 1) {
                    break;
                }
            }
            while (nums[--j] % 2 == 0) {
                if (j == 0) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 6, 2, 1, 2, 7, 8};
        ArrayOddEven arrayOddEven = new ArrayOddEven();
        arrayOddEven.adjust(nums);
        System.out.println(Arrays.toString(nums));
    }
}

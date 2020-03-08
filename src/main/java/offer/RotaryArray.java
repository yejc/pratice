package offer;

/**
 * 旋转数组中的最小元素
 *
 * @author yejc
 * @date 2020/3/8 11:34
 */
public class RotaryArray {
    public int min(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new RuntimeException("Array is empty.");
        }
        int lo = 0, hi = nums.length - 1, mid = lo;
        while (nums[lo] >= nums[hi]) {
            if (hi - lo == 1) {
                mid = hi;
                break;
            }
            mid = lo + (hi - lo) / 2;
            // 如果下标i, j, middle 指向的三个数字相等，就只能顺序查找
            if (nums[lo] == nums[mid] && nums[mid] == nums[hi]) {
                return minNumberArray(nums, lo, hi);
            }
            if (nums[mid] >= nums[lo]) {
                // 中间元素位于后面的递增数组
                lo = mid;
            } else if (nums[mid] <= nums[hi]) {
                // 中间元素位于前面的递增数组
                hi = mid;
            } else {
                return mid;
            }
        }
        return nums[mid];
    }

    private int minNumberArray(int[] nums, int lo, int hi) {
        int result = nums[lo];
        for (int i = lo + 1; i <= hi; i++) {
            if (nums[i] < nums[i - 1]) {
                result = nums[i];
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0, 1};
        RotaryArray rotaryArray = new RotaryArray();
        int min = rotaryArray.min(nums);
        System.out.println(min);

    }
}

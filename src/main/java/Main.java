import java.util.Arrays;

/**
 * @program: pratice
 * @description:
 * @author: yejc
 * @create: 2020-02-25 19:23
 **/
public class Main {
    static int remove(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int write = 1;
        int count = 1;
        for (int read = 1; read < nums.length; read++) {
            if (nums[read] != nums[read - 1]) {
                count++;
                nums[write++] = nums[read];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1};
        int count = remove(nums);
        System.out.println("长度是:" + count);
        System.out.println(Arrays.toString(nums));
    }
}

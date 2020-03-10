package offer;

/**
 * 打印从1到最大的n位数，可能会溢出
 *
 * @author yejc
 * @date 2020/3/10 22:11
 */
public class Print1ToNbit {
    public void print(int n) {
        char[] nums = new char[n];
        printHelper(nums, 0);
    }

    private void printHelper(char[] nums, int index) {
        if (index > nums.length - 1) {
            printNum(nums);
            return;
        }
        for (int i = 0; i < 10; i++) {
            nums[index] = (char) (i + '0');
            printHelper(nums, index + 1);
        }
    }

    private void printNum(char[] nums) {
        boolean isBegin0 = true;
        for (int i = 0; i < nums.length; i++) {
            if (isBegin0 && nums[i] != '0') {
                isBegin0 = false;
            }
            if (!isBegin0) {
                System.out.print(nums[i]);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Print1ToNbit print1ToNbit = new Print1ToNbit();
        print1ToNbit.print(3);
    }
}

package offer;

import java.util.Arrays;

/**
 * @author yejc
 * @date 2020/3/7 10:54
 */
public class ArrayQ {
    /**
     * 找出数组中的重复数字
     * 长度为n的数字，里面元素的取值范围为0 ~ n-1，找出数组里的重复数字，如有多个重复数字，找出其中一个即可,如果没有重复数字返回-1
     *
     * @param nums
     * @return
     */
    public int findDuplicateNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                exch(nums, i, nums[i]);
            }
        }
        return -1;
    }

    private void exch(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    /**
     * 查找指定数字是否在二维数组中，二维数组从上到下，从左到右递增
     *
     * @param matrix
     * @param num
     * @return
     */
    public boolean find(int[][] matrix, int num) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        // 选取右上角作为开始点，如果指定值大于当前值，往下走，否则往左走
        int i = 0, j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (num == matrix[i][j]) {
                return true;
            } else if (num < matrix[i][j]) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    /**
     * 合并两个有序数组，使之合并后仍然有序，a1长度能容纳a2
     *
     * @param a1
     * @param a2
     */
    public void merge(int[] a1, int[] a2, int a1Len, int a2Len) {
        int p1 = a1Len - 1, p2 = a2Len - 1, p3 = a1.length - 1;
        while (p1 >= 0 && p2 >= 0) {
            if (a1[p1] > a2[p2]) {
                a1[p3--] = a1[p1--];
            } else {
                a1[p3--] = a2[p2--];
            }
        }
        while (p1 >= 0) {
            a1[p3--] = a1[p1--];
        }
        while (p2 >= 0) {
            a1[p3--] = a2[p2--];
        }
    }

    public static void main(String[] args) {
        ArrayQ array = new ArrayQ();
        int[] a1 = new int[7];
        a1[0] = 1;
        a1[1] = 3;
        a1[2] = 5;
        int[] a2 = {2, 4, 6, 7};

        array.merge(a1, a2, 3, 4);
        System.out.println(Arrays.toString(a1));
    }
}

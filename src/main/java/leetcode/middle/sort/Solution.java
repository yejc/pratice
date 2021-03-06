package leetcode.middle.sort;

import java.util.*;

/**
 * @author yejc
 * @date 2020/1/8 20:26
 */
public class Solution {
    /**
     * 颜色分类
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        // p0表示0的右边界，p2表示2的左边界
        // 当x∈[0,p0),x = 0;
        // 当x∈[p0,curr),x = 1;
        // 当x∈[curr,p2],x = ?;
        // 当x∈(p2,nums.length -1],x = 2;
        int p0 = 0, p2 = nums.length - 1, curr = 0;
        while (curr <= p2) {
            if (nums[curr] == 0) {
                int tmp = nums[p0];
                nums[p0++] = nums[curr];
                nums[curr++] = tmp;
            } else if (nums[curr] == 2) {
                int tmp = nums[curr];
                nums[curr] = nums[p2];
                nums[p2--] = tmp;
            } else {
                curr++;
            }
        }
    }

    /**
     * 前 K 个高频元素
     *
     * @param nums
     * @param k
     * @return
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(map::get));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (queue.size() < k) {
                queue.add(entry.getKey());
            } else {
                Integer peek = queue.peek();
                if (entry.getValue() > map.get(peek)) {
                    queue.poll();
                    queue.add(entry.getKey());
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (Integer integer : queue) {
            result.add(0, integer);
        }
        return result;
    }

    /**
     * 数组中的第K个最大元素
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        int index = partition(nums, 0, nums.length - 1, nums.length - k);
        return nums[index];

    }

    private int partition(int[] nums, int lo, int hi, int k) {
        if (lo == hi) {
            return lo;
        }
        int i = lo;
        int j = hi + 1;
        int v = nums[lo];
        while (i < j) {
            while (nums[++i] < v) {
                if (i == hi) {
                    break;
                }
            }
            while (nums[--j] > v) {
                if (j == lo) {
                    break;
                }
            }
            if (i < j) {
                swap(nums, i, j);
            }
        }
        swap(nums, lo, j);
        if (j > k) {
            return partition(nums, lo, j - 1, k);
        } else if (j < k) {
            return partition(nums, j + 1, hi, k);
        } else {
            return j;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    /**
     * 寻找峰值
     *
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    /**
     * 在排序数组中查找元素的第一个和最后一个位置
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int left = left_bound(nums, target);
        int right = right_bound(nums, target);
        return new int[]{left, right};
    }

    int left_bound(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        if (left >= nums.length) {
            return -1;
        }
        return nums[left] == target ? left : -1;
    }

    int right_bound(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        if (left == 0) {
            return -1;
        }
        return nums[left - 1] == target ? left - 1 : -1;
    }

    /**
     * 搜索旋转排序数组
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 前半部分有序
            if (nums[start] <= nums[mid]) {
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                // 后半部分有序
                if (target <= nums[end] && target > nums[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 搜索二维矩阵 II
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length - 1;
        int col = 0;
        while (row >= 0 && col < matrix[0].length) {
            if (target == matrix[row][col]) {
                return true;
            } else if (target < matrix[row][col]) {
                row--;
            } else if (target > matrix[row][col]) {
                col++;
            }
        }
        return false;
    }
}

package leetcode.middle.sort;

import java.util.*;

/**
 * @author yejc
 * @date 2020/1/20 20:08
 */
public class Solution2 {
    /**
     * 颜色分类
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        int i = 0, k = 0, j = nums.length - 1;
        while (k <= j) {
            if (nums[k] == 0) {
                swap(nums, i++, k++);
            } else if (nums[k] == 1) {
                k++;
            } else if (nums[k] == 2) {
                swap(nums, k, j--);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
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
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((x1, x2) -> x2.getValue().compareTo(x1.getValue()));
        queue.addAll(map.entrySet());

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(queue.poll().getKey());
        }
        return result;
    }

    /**
     * 数组中的第K个最大元素（小顶堆法）
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            if (queue.size() < k) {
                queue.add(num);
            } else {
                Integer peek = queue.peek();
                if (peek < num) {
                    queue.poll();
                    queue.add(num);
                }
            }
        }
        return queue.poll();
    }

    /**
     * 数组中的第K个最大元素（快排分治法）
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest2(int[] nums, int k) {
        int index = partition(nums, 0, nums.length - 1, nums.length - k);
        return nums[index];
    }

    private int partition(int[] nums, int lo, int hi, int k) {
        if (lo == hi) {
            return lo;
        }
        int i = lo, j = hi + 1;
        int v = nums[lo];
        while (true) {
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
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, lo, j);
        if (j == k) {
            return j;
        } else if (j < k) {
            return partition(nums, j + 1, hi, k);
        } else {
            return partition(nums, lo, j - 1, k);
        }
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
        int left = leftBound(nums, target);
        int right = rightBound(nums, target);
        return new int[]{left, right};
    }

    private int leftBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                while (mid > 0 && nums[mid - 1] == target) {
                    mid--;
                }
                return mid;
            }
        }
        return -1;
    }

    private int rightBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                while (mid < nums.length - 1 && nums[mid + 1] == target) {
                    mid++;
                }
                return mid;
            }
        }
        return -1;
    }

}

package sundry;

import java.util.ArrayList;
import java.util.List;

/**
 * 60. 第k个排列
 *
 * @program: pratice
 * @description:
 * @author: yejc
 * @create: 2020-02-21 21:31
 **/
public class KPermutation {
    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        List<String> list = new ArrayList<>();
        boolean[] visited = new boolean[n];
        getPermutationHelper(nums, "", k, list, visited);
        return list.get(k - 1);
    }

    private void getPermutationHelper(int[] nums, String letter, int k, List<String> list, boolean[] visited) {
        if (letter.length() == nums.length) {
            list.add(letter);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            getPermutationHelper(nums, letter + nums[i], k, list, visited);
            if (list.size() == k) {
                break;
            }
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        KPermutation kPermutation = new KPermutation();
        String permutation = kPermutation.getPermutation(3, 3);
        System.out.println(permutation);
    }
}

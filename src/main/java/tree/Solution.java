package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    /**
     * 二叉树的最大深度
     *
     * @param root
     * @return
     */
    int maxDepth = 0;

    public int maxDepth(TreeNode root) {
        maxDepthHelper(root, 0);
        return maxDepth;
    }

    private void maxDepthHelper(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        depth++;
        maxDepth = Math.max(maxDepth, depth);
        maxDepthHelper(node.left, depth);
        maxDepthHelper(node.right, depth);
    }

    /**
     * 验证二叉搜索树
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, null, null);
    }

    private boolean isValidBSTHelper(TreeNode node, Integer lower, Integer upper) {
        if (node == null) {
            return true;
        }
        int val = node.val;
        if (lower != null && val <= lower) {
            return false;
        }
        if (upper != null && val >= upper) {
            return false;
        }
        if (!isValidBSTHelper(node.left, lower, val)) {
            return false;
        }
        if (!isValidBSTHelper(node.right, val, upper)) {
            return false;
        }
        return true;
    }

    /**
     * 对称二叉树
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    private boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        return t1.val == t2.val && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }

    /**
     * 二叉树的层次遍历
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> levelList = new ArrayList<>();
            int levelLength = queue.size();
            for (int i = 0; i < levelLength; i++) {
                TreeNode node = queue.poll();
                levelList.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(levelList);
        }
        return result;
    }

    /**
     * 将有序数组转换为二叉搜索树
     * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
     *
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBSTHelper(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBSTHelper(int[] nums, int lo, int hi) {
        if (lo > hi) {
            return null;
        }
        if (lo == hi) {
            return new TreeNode(nums[lo]);
        }
        int mid = lo + (hi - lo) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBSTHelper(nums, lo, mid - 1);
        node.right = sortedArrayToBSTHelper(nums, mid + 1, hi);

        return node;
    }
}

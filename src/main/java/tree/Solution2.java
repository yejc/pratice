package tree;

/**
 * @program: pratice
 * @description:
 * @author: yejc
 * @create: 2019-12-02 21:58
 **/
public class Solution2 {

    /**
     * 二叉树的最大深度
     *
     * @param root
     * @return
     */
    int maxDepth;

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxDepthHelper(root, 1);
        return maxDepth;
    }

    private void maxDepthHelper(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        if (depth > maxDepth) {
            maxDepth = depth;
        }
        maxDepthHelper(node.left, depth + 1);
        maxDepthHelper(node.right, depth + 1);
    }

    /**
     * 验证二叉搜索树
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBSTHelper(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return isValidBSTHelper(node.left, lower, node.val) && isValidBSTHelper(node.right, node.val, upper);
    }

}

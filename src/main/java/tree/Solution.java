package tree;

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
}

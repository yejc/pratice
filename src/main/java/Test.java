import leetcode.primary.tree.TreeNode;

/**
 * @program: pratice
 * @description:
 * @author: yejc
 * @create: 2020-02-09 15:52
 **/
public class Test {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s == t) {
            return helper(s.left, t.left) && helper(s.right, t.right);
        }
        return isSubtree(s.left, t) && isSubtree(s.right, t);
    }

    private boolean helper(TreeNode node1, TreeNode node2) {
        if (node1 != node2) {
            return false;
        }
        boolean left = false;
        boolean right = false;
        if (node1 != null) {
            left = helper(node1.left, node2.right);
        }
        return helper(node1.left, node2.left) && helper(node1.right, node2.right);
    }
}

package offer;

import leetcode.primary.tree.TreeNode;

/**
 * @author yejc
 * @date 2020/3/7 20:30
 */
public class TreeQ {

    /**
     * 给定数的前序和后序遍历，重建二叉树
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode build(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }
        TreeNode root = buildHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        return root;
    }

    private TreeNode buildHelper(int[] preorder, int preLo, int preHi, int[] inorder, int inLo, int inHi) {
        if (preLo > preHi) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[preLo]);
        // 查找inorder中preorder[preHi]的位置
        int index = 0;
        for (int i = inLo; i <= inHi; i++) {
            if (inorder[i] == preorder[preLo]) {
                index = i;
                break;
            }
        }
        node.left = buildHelper(preorder, preLo + 1, preLo + (index - inLo), inorder, inLo, index - 1);
        node.right = buildHelper(preorder, preLo + (index - inLo) + 1, preHi, inorder, index + 1, inHi);
        return node;
    }

    /**
     * 二叉树的下一个节点
     * 给定二叉树和其中一个节点，如何找出中序遍历序列的下一个节点？
     */
    public TreeNode nextInOrder(TreeNode root, TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode result = null;
        if (node.right != null) {
            result = node.right;
            while (result.left != null) {
                result = result.left;
            }
            return result;
        } else {
            TreeNode pre = node;
            result = node.parent;
            while (result != null && result.right != pre) {
                pre = result;
                result = result.parent;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        int[] preorder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inorder = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeQ treeQ = new TreeQ();
        TreeNode root = treeQ.build(preorder, inorder);
        System.out.println(root);
    }
}

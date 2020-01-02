package leetcode.middle.tree;

import leetcode.primary.tree.TreeNode;

import java.util.*;

/**
 * @author yejc
 * @date 2020/1/1 10:47
 */
public class Solution {

    /**
     * 中序遍历二叉树
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversalHelper(root, result);
        return result;
    }

    private void inorderTraversalHelper(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        inorderTraversalHelper(node.left, result);
        result.add(node.val);
        inorderTraversalHelper(node.right, result);
    }

    /**
     * 二叉树的锯齿形层次遍历
     *
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        // 用两个栈交替存储每层节点
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(root);

        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            if (!stack1.isEmpty()) {
                while (!stack1.isEmpty()) {
                    TreeNode pop = stack1.pop();
                    list.add(pop.val);
                    if (pop.left != null) {
                        stack2.push(pop.left);
                    }
                    if (pop.right != null) {
                        stack2.push(pop.right);
                    }
                }
            } else {
                while (!stack2.isEmpty()) {
                    TreeNode pop = stack2.pop();
                    list.add(pop.val);
                    if (pop.right != null) {
                        stack1.push(pop.right);
                    }
                    if (pop.left != null) {
                        stack1.push(pop.left);
                    }
                }
            }
            result.add(list);
        }
        return result;
    }

    /**
     * 从前序与中序遍历序列构造二叉树
     *
     * @param preorder
     * @param inorder
     * @return
     */
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode buildTreeHelper(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
        if (pStart == pEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pStart]);
        // 找出root节点在inorder中的位置p，p左边为左子树，p右边为右子树
        int p = map.get(preorder[pStart]);
        // 左子树长度
        int leftNum = p - iStart;
        root.left = buildTreeHelper(preorder, pStart + 1, pStart + leftNum + 1, inorder, iStart, p);
        root.right = buildTreeHelper(preorder, pStart + leftNum + 1, pEnd, inorder, p + 1, iEnd);

        return root;
    }

    /**
     * 从中序与后序遍历序列构造二叉树
     *
     * @param inorder
     * @param postorder
     * @return
     */
    Map<Integer, Integer> map2 = new HashMap<>();

    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map2.put(inorder[i], i);
        }
        return buildTreeHelper2(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    private TreeNode buildTreeHelper2(int[] inorder, int iStart, int iEnd, int[] postorder, int pStart, int pEnd) {
        if (pStart == pEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[pEnd - 1]);

        int p = map2.get(postorder[pEnd - 1]);
        // 左子树长度
        int leftNum = p - iStart;

        root.left = buildTreeHelper2(inorder, iStart, p, postorder, pStart, pStart + leftNum);
        root.right = buildTreeHelper2(inorder, p + 1, iEnd, postorder, pStart + leftNum, pEnd - 1);

        return root;
    }

}

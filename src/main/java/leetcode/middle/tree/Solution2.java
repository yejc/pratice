package leetcode.middle.tree;

import leetcode.primary.tree.TreeNode;

import java.util.*;

/**
 * @author yejc
 * @date 2020/1/15 20:15
 */
public class Solution2 {

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
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            if (!stack1.isEmpty()) {
                while (!stack1.isEmpty()) {
                    TreeNode node = stack1.pop();
                    list.add(node.val);

                    if (node.left != null) {
                        stack2.push(node.left);
                    }
                    if (node.right != null) {
                        stack2.push(node.right);
                    }
                }
            } else {
                while (!stack2.isEmpty()) {
                    TreeNode node = stack2.pop();
                    list.add(node.val);

                    if (node.right != null) {
                        stack1.push(node.right);
                    }
                    if (node.left != null) {
                        stack1.push(node.left);
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
    // 存储元素与索引的映射关系
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[preStart]);
        int index = map.get(preorder[preStart]);

        // 左子树长度
        int leftLength = index - inStart;
        // 右子树长度
        int rightLength = inEnd - index;

        node.left = buildTreeHelper(preorder, preStart + 1, preStart + leftLength, inorder, inStart, index - 1);
        node.right = buildTreeHelper(preorder, preStart + leftLength + 1, preEnd, inorder, index + 1, inEnd);
        return node;
    }

    /**
     * 填充每个节点的下一个右侧节点指针
     *
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left != null) {
            root.left.next = root.right;
            if (root.next != null) {
                root.right.next = root.next.left;
            }
        }
        connect(root.left);
        connect(root.right);
        return root;
    }

    /**
     * 二叉搜索树中第K小的元素
     *
     * @param root
     * @param k
     * @return
     */
    int result;
    int k;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        kthSmallestHelper(root);
        return result;
    }

    private void kthSmallestHelper(TreeNode node) {
        if (node == null) {
            return;
        }
        kthSmallestHelper(node.left);
        if (--k == 0) {
            result = node.val;
            return;
        }
        kthSmallestHelper(node.right);
    }
}

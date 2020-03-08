package leetcode.primary.tree;

import lombok.Data;

@Data
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode parent;

    public TreeNode(int x) {
        val = x;
    }

}

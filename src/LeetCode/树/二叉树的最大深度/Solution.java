package LeetCode.树.二叉树的最大深度;

import utils.TreeNode;


public class Solution {
    public int maxDepth(TreeNode root) {
        return sub_maxDepth(root, 0);
    }

    public int sub_maxDepth(TreeNode root, int level) {
        if (root == null) return level;
        return Math.max(sub_maxDepth(root.left, level + 1), sub_maxDepth(root.right, level + 1));
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(2);
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(4);
        TreeNode t6 = new TreeNode(3);
        TreeNode t7 = new TreeNode(4);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t7;
        t3.right = t6;
        System.out.println(s.maxDepth(t1));
    }
}

package LeetCode.树.二叉树的最小深度;

import utils.TreeNode;


public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        return sub_minDepth(root, 1);
    }

    public int sub_minDepth(TreeNode root, int level) {
        if (root == null) return Integer.MAX_VALUE;
        if (root.left == null && root.right == null) return level;//最小深度为叶子节点到根节点的最短距离
        return Math.min(sub_minDepth(root.left, level + 1), sub_minDepth(root.right, level + 1));
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
//        t1.right = t3;
//        t2.left = t4;
//        t2.right = t5;
//        t3.left = t6;
//        t3.right = t7;
        System.out.println(s.minDepth(t1));
    }
}

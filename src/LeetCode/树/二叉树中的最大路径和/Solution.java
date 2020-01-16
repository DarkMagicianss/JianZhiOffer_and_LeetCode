package LeetCode.树.二叉树中的最大路径和;

import utils.TreeNode;

public class Solution {
    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        return Math.max(sub_maxPathSum(root), max);
    }

    public int sub_maxPathSum(TreeNode root) {
        if (root == null) return Integer.MIN_VALUE / 2;
        if (root.left == null && root.right == null) return root.val;
        int left = sub_maxPathSum(root.left);
        int right = sub_maxPathSum(root.right);
        int up_max = Math.max(root.val, Math.max(left + root.val, right + root.val));
        int temp_result = Math.max(left + root.val + right, Math.max(Math.max(left, right), up_max));
        max = Math.max(max, temp_result);
        //System.out.println(root.val + "   " + l_r_single_max + "   " + up_max + "    " + temp_result);
        return up_max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode t1 = new TreeNode(0);
        TreeNode t2 = new TreeNode(5);
        TreeNode t3 = new TreeNode(4);
        TreeNode t4 = new TreeNode(2);
        TreeNode t5 = new TreeNode(-4);
        //t1.left = t2;
        //t2.left = t3;
        //t3.right = t4;
        //t4.left = t5;
        System.out.println(s.maxPathSum(t1));
    }
}

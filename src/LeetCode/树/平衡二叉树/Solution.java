package LeetCode.树.平衡二叉树;

import utils.TreeNode;

public class Solution {
    boolean result = true;
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        sub_depth(root,0);
        return result;
    }
    private int sub_depth(TreeNode root,int level) {
        if (root == null || result == false) return level;
        int left_len = sub_depth(root.left,level + 1);
        int right_len = sub_depth(root.right,level + 1);
        if (Math.abs(left_len - right_len) > 1) result = false;
        return Math.max(left_len, right_len);
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
        TreeNode t8 = new TreeNode(5);
        TreeNode t9 = new TreeNode(6);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t7;
        t3.right = t6;
        //t7.left = t8;
        //t8.left = t9;
        System.out.println(s.isBalanced(t1));
    }
}

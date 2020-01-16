package LeetCode.树.相同的树;

import utils.TreeNode;

public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null && q != null || p != null && q == null || p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    private void in_look(TreeNode root) {
        if (root == null) return;
        in_look(root.left);
        System.out.println(root.val);
        in_look(root.right);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode t11 = new TreeNode(1);
        TreeNode t12 = new TreeNode(2);
        TreeNode t13 = new TreeNode(3);
        TreeNode t21 = new TreeNode(1);
        TreeNode t22 = new TreeNode(2);
        TreeNode t23 = new TreeNode(3);
        TreeNode t4 = new TreeNode(3);
        t11.left = t12;
        t11.right = t13;
        t21.left = t22;
        t21.right = t23;
        System.out.println(s.isSameTree(t11, t21));
    }
}

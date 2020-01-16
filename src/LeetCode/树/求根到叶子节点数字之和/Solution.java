package LeetCode.树.求根到叶子节点数字之和;

import utils.TreeNode;

public class Solution {
    private int result = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) result += root.val;
        if (root.left != null) {
            root.left.val += (10 * root.val);
            sumNumbers(root.left);
        }
        if (root.right != null) {
            root.right.val += (10 * root.val);
            sumNumbers(root.right);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(2);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        t3.right = t5;
        System.out.println(s.sumNumbers(t1));
    }
}

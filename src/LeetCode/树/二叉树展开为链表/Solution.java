package LeetCode.树.二叉树展开为链表;

import utils.TreeNode;

public class Solution {
    TreeNode head = new TreeNode(0);

    public void flatten(TreeNode root) {
        if (root == null) return;
        //保存root节点原先和右子树
        TreeNode src_right = root.right;
        //root左连上一个head head右连这个root
        head.left = null;
        head.right = root;
        head = root;
        if (root.left != null) flatten(root.left);
        if (src_right != null) flatten(src_right);
        return;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(5);
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(4);
        TreeNode t6 = new TreeNode(6);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.right = t6;
        s.flatten(t1);
        while (t1 != null) {
            System.out.println("right:" + t1.val);
            t1 = t1.right;
        }
    }
}

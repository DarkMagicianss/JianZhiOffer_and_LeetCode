package JianZhiOffer.JZ18知识迁移能力.平衡二叉树;


import utils.TreeNode;

public class Solution {
    boolean flag = true;
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) return true;
        search_for_Depth(root);
        return flag;
    }

    public int search_for_Depth(TreeNode root) {
        if(flag == false) return 0;//用于增加判断是否是平衡树的加速 一旦不是平衡树 则不再计算树的深度
        if (root == null) return 0;
        int left_level = search_for_Depth(root.left);
        int right_level = search_for_Depth(root.right);
        if (Math.abs(left_level - right_level) > 1)
            flag = false;
        return left_level > right_level ? (left_level + 1) : (right_level + 1);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.right = t6;
        t5.left = t7;
        Solution s = new Solution();
        System.out.println(s.IsBalanced_Solution(t1));

    }
}

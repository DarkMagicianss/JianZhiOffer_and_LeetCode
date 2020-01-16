package JianZhiOffer.JZ18知识迁移能力.二叉搜索树的第k个节点;


import utils.TreeNode;

public class Solution {
    public int index = 0;
    TreeNode target = null;
    public TreeNode KthNode(TreeNode pRoot, int k) {
        in_lookup(pRoot, k);
        return target;
    }
    private void in_lookup(TreeNode root, int k) {
        if (target != null || root == null) return;
        in_lookup(root.left, k);
        index++;
        if (index == k) target = root;
        in_lookup(root.right, k);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(7);
        TreeNode t4 = new TreeNode(2);
        TreeNode t5 = new TreeNode(4);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(8);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        Solution s = new Solution();
        System.out.println(s.KthNode(t1, 3).val);

    }
}

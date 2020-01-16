package LeetCode.树.对称二叉树;

import utils.TreeNode;

public class Solution {
    //1.这里我采用的方法是先进行镜像转换 再比较镜像前和镜像后的两者是否相同
    //2.可以递归一个方法 参数为两棵树 判断其是否对象
    //则比较完根节点之后比较 tree1的左子树和tree2的右子树 tree2的左子树和tree1的右子树 一直递归下去
    public boolean isSymmetric(TreeNode root) {
        if (root == null || root.left == null && root.right == null) return true;
        if (root.left == null && root.right != null || root.left != null && root.right == null) return false;
        if (root.left.val != root.right.val) return false;
        sub_turn(root.left);
        return sub_isSameTree(root.left,root.right);
    }
    public boolean sub_isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null && q != null || p != null && q == null || p.val != q.val) return false;
        return sub_isSameTree(p.left, q.left) && sub_isSameTree(p.right, q.right);
    }
    private void sub_turn(TreeNode root) {
        if (root == null) return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        sub_turn(root.left);
        sub_turn(root.right);
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
        System.out.println(s.isSymmetric(t1));
    }
}

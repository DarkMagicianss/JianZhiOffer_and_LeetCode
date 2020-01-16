package JianZhiOffer.JZ13画图让抽象问题形象化.对称的二叉树;


import utils.TreeNode;

import java.util.LinkedList;

public class Solution {
    public boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) return true;
        if (pRoot.left == null && pRoot.right == null) return true;
        return sub_isSymmetrical(pRoot.left,pRoot.right);
    }
    public boolean sub_isSymmetrical(TreeNode left,TreeNode right) {
        if(left == null && right == null)return true;
        if(!(left != null && right!= null && left.val == right.val))
            return false;
        return sub_isSymmetrical(left.left,right.right) && sub_isSymmetrical(left.right,right.left);
    }

    //按顺序打印tree 和题目无关
    private static void print_tree(TreeNode root) {
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()) {
            TreeNode temp = list.removeFirst();
            System.out.print(temp.val + " ");
            if (temp.left != null) list.add(temp.left);
            if (temp.right != null) list.add(temp.right);
        }
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(6);
        TreeNode t3 = new TreeNode(6);
        TreeNode t4 = new TreeNode(7);
        TreeNode t5 = new TreeNode(8);
        TreeNode t6 = new TreeNode(8);
        TreeNode t7 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        Solution s = new Solution();
        print_tree(t1);
        System.out.println(s.isSymmetrical(t1));
    }
}

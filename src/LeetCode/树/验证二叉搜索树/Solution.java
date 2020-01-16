package LeetCode.树.验证二叉搜索树;

import utils.TreeNode;


public class Solution {
    long last = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if(root == null)return true;
        if(isValidBST(root.left)){
            //按照中序遍历来进行比较 每次只和上一个值比较
            if(root.val > last){//若小于等于上一个数值 则false
                last = root.val;
                return isValidBST(root.right);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(1);
        t1.right = t2;
        t2.right = t3;
        System.out.println(s.isValidBST(t1));
    }
}

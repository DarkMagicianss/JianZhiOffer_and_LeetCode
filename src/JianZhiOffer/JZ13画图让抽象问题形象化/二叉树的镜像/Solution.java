package JianZhiOffer.JZ13画图让抽象问题形象化.二叉树的镜像;


import utils.TreeNode;

public class Solution {
    public void Mirror(TreeNode root) {
        if(root == null ||(root.left == null && root.right==null))return;
        TreeNode t_temp = root.left;
        root.left = root.right;
        root.right = t_temp;
        if(root.left!=null)Mirror(root.left);
        if(root.right!=null)Mirror(root.right);
        return;
    }
    private static void in_lookup(TreeNode index) {
        if (index.left != null) {
            in_lookup(index.left);
        }
        System.out.println("in:" + index.val);
        if (index.right != null) {
            in_lookup(index.right);
        }
        return;
    }
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(8);
        TreeNode t2 = new TreeNode(6);
        TreeNode t3 = new TreeNode(10);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(7);
        TreeNode t6 = new TreeNode(9);
        TreeNode t7 = new TreeNode(11);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        Solution s = new Solution();
        in_lookup(t1);
        System.out.println("23333");
        s.Mirror(t1);
        in_lookup(t1);
    }
}

package LeetCode.树.二叉树的前序遍历;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        //非递归的前序遍历是真的简单啊
        List<Integer> result = new LinkedList<>();
        if (root == null) return result;
        //LinkedList记录右子树 因为要返回到右子树
        LinkedList<TreeNode> r_list = new LinkedList<>();
        r_list.addLast(root);
        while (!r_list.isEmpty()) {
            TreeNode temp = r_list.removeFirst();
            result.add(temp.val);
            if (temp.right != null) r_list.addFirst(temp.right);
            if (temp.left != null) r_list.addFirst(temp.left);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(20);
        TreeNode t4 = new TreeNode(15);
        TreeNode t5 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        t3.right = t5;
        System.out.println(s.preorderTraversal(t1));
    }
}

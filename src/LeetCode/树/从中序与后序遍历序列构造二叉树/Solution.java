package LeetCode.树.从中序与后序遍历序列构造二叉树;

import utils.TreeNode;

public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0 || inorder.length == 0) return null;
        return sub_buildTree(postorder, 0, inorder, 0, postorder.length);
    }

    public TreeNode sub_buildTree(int[] postorder, int start1, int[] inorder, int start2, int len) {
        if (len == 0) return null;
        int target = postorder[start1 + len - 1];
        TreeNode root = new TreeNode(target);//以后续遍历的最后一个节点为目标点
        if (len == 1) {//只有一个节点的情况下
            return root;
        }
        for (int i = start2 + len - 1; i >= 0 ; i--) {
            if (inorder[i] == target) {
                int left_len = i - start2;
                int right_len = start2 + len - 1 - i;
                //System.out.println((start1 + 1) + "    " + start2 + "   " + left_len);
                //System.out.println((start1 + left_len + 1) + "    " + i + 1 + "   " + right_len);
                root.left = sub_buildTree(postorder, start1, inorder, start2, left_len);
                root.right = sub_buildTree(postorder, start1 + left_len, inorder, i + 1, right_len);
                return root;
            }
        }
        return null;
    }

    private void in_look(TreeNode root) {
        if (root == null) return;
        in_look(root.left);
        System.out.println(root.val);
        in_look(root.right);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] posorder = new int[]{9, 15, 7, 20, 3};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        s.in_look(s.buildTree(inorder, posorder));

    }
}

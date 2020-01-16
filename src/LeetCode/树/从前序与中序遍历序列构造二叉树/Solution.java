package LeetCode.树.从前序与中序遍历序列构造二叉树;

import utils.TreeNode;

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) return null;
        return sub_buildTree(preorder, 0, inorder, 0, preorder.length);
    }

    public TreeNode sub_buildTree(int[] preorder, int start1, int[] inorder, int start2, int len) {
        if (len == 0) return null;
        TreeNode root = new TreeNode(preorder[start1]);
        if (len == 1) {//只有一个节点的情况下
            return root;
        }
        //为神马倒个序列速度差了这么多 肯定是数据的原因
        for (int i = start2 + len - 1; i >= 0 ; i--) {
            if (inorder[i] == preorder[start1]) {
                int left_len = i - start2;
                int right_len = start2 + len - 1 - i;
                System.out.println((start1 + 1) + "    " + start2 + "   " + left_len);
                System.out.println((start1 + left_len + 1) + "    " + i + 1 + "   " + right_len);
                root.left = sub_buildTree(preorder, start1 + 1, inorder, start2, left_len);
                root.right = sub_buildTree(preorder, start1 + left_len + 1, inorder, i + 1, right_len);
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
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        s.in_look(s.buildTree(preorder, inorder));

    }
}

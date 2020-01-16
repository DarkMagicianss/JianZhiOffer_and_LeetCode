package LeetCode.动态规划.不同的二叉搜索树2_____很巧妙;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new LinkedList<>();
        return sub_generateTrees(1, n);
    }

    private LinkedList<TreeNode> sub_generateTrees(int start, int end) {
        LinkedList<TreeNode> result = new LinkedList<>();
        if (start > end) {
            result.add(null);
            return result;
        }
        for (int i = start; i <= end; i++) {
            LinkedList<TreeNode> left_treenode = sub_generateTrees(start, i - 1);
            LinkedList<TreeNode> right_treenode = sub_generateTrees(i + 1, end);
            for (TreeNode t1 : left_treenode) {
                for (TreeNode t2 : right_treenode) {
                    TreeNode root = new TreeNode(i);
                    root.left = t1;
                    root.right = t2;
                    result.add(root);
                }
            }
        }
        return result;
    }

    private void pre_look(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        if (root.left != null) pre_look(root.left);
        if (root.right != null) pre_look(root.right);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<TreeNode> result = s.generateTrees(4);
        for (int i = 0; i < result.size(); i++) {
            s.pre_look(result.get(i));
            System.out.println();
        }
        System.out.println(result.size());
    }
}

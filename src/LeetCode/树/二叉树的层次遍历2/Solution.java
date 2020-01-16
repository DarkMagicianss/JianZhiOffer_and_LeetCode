package LeetCode.树.二叉树的层次遍历2;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.addLast(root);
        while (!list.isEmpty()) {//正向遍历 反向存储
            int next_count = list.size();
            ArrayList<Integer> temp_result = new ArrayList<>();
            while (next_count > 0) {
                TreeNode temp = list.removeFirst();
                temp_result.add(temp.val);
                if (temp.left != null) list.addLast(temp.left);
                if (temp.right != null) list.addLast(temp.right);
                next_count--;
            }
            ((LinkedList<List<Integer>>) result).addFirst(temp_result);
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
        System.out.println(s.levelOrderBottom(t1));
    }
}

package LeetCode.树.路径总和2;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        sub_pathSum(root, sum, new LinkedList<>());
        return result;
    }

    private void sub_pathSum(TreeNode root, int sum, LinkedList<Integer> list) {
        if (root == null) return;
        list.addLast(root.val);
        if (root.val == sum && root.left == null && root.right == null) {
            result.add(new LinkedList<>(list));
        }
        sub_pathSum(root.left, sum - root.val, list);
        sub_pathSum(root.right, sum - root.val, list);
        list.removeLast();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(9);
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(4);
        TreeNode t6 = new TreeNode(2);
        TreeNode t7 = new TreeNode(8);
        TreeNode t8 = new TreeNode(5);
        TreeNode t9 = new TreeNode(6);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t7;
        t3.right = t6;
        t4.left = t8;
        t4.right = t9;
        s.pathSum(t1,12);
        for (int i = 0; i < s.result.size(); i++) {
            System.out.println(s.result.get(i));
        }
    }
}

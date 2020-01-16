package LeetCode.树.二叉树的右视图;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.addLast(root);
        while (!list.isEmpty()) {
            int count = list.size();
            while(count > 0) {
                TreeNode temp = list.removeFirst();
                if (temp.left != null) {
                    list.addLast(temp.left);
                }
                if (temp.right != null) {
                    list.addLast(temp.right);
                }
                count--;
                if (count == 0) {
                    result.add(temp.val);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(4);
        t1.left = t2;
        t1.right = t3;
        t2.right = t4;
        t3.right = t5;
        System.out.println(s.rightSideView(t1));
    }
}

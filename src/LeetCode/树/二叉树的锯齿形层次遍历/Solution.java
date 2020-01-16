package LeetCode.树.二叉树的锯齿形层次遍历;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.addFirst(root);
        int level = 1;
        while (!list.isEmpty()) {
            ArrayList<Integer> temp_result = new ArrayList<>();
            int len = list.size();
            if (level % 2 == 1) {//奇数层 先addLast左 再addLast右 取的话取first
                while (len > 0) {
                    TreeNode temp = list.removeFirst();
                    temp_result.add(temp.val);
                    if (temp.left != null) list.addLast(temp.left);
                    if (temp.right != null) list.addLast(temp.right);
                    len--;
                }
            }else{//奇数层 先addFirst右 再addFirst左 取的话取last
                while (len > 0) {
                    TreeNode temp = list.removeLast();
                    temp_result.add(temp.val);
                    if (temp.right != null) list.addFirst(temp.right);
                    if (temp.left != null) list.addFirst(temp.left);
                    len--;
                }
            }
            result.add(temp_result);
            level++;
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
        System.out.println(s.zigzagLevelOrder(t1));
    }
}

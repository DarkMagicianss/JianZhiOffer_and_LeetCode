package JianZhiOffer.JZ5栈和队列.按之字形顺序打印二叉树;


import utils.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        if (pRoot == null) return result;
        stack1.push(pRoot);
        int level = 1;
        while (!(stack1.isEmpty() && stack2.isEmpty())) {
            result.add(sub_Print(stack1, stack2, level % 2));
            level++;
        }
        return result;
    }
    public ArrayList<Integer> sub_Print(Stack<TreeNode> stack1, Stack<TreeNode> stack2, int level) {
        ArrayList<Integer> temp_list = new ArrayList<>();
        Stack<TreeNode> stack = null;
        stack = level == 1 ? stack1 : stack2;
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();//pop是返回并移除 peek只是返回不移除
            temp_list.add(temp.val);
            if (level == 1) {//奇数层
                if (temp.left != null) stack2.push(temp.left);
                if (temp.right != null) stack2.push(temp.right);
            } else {//偶数层
                if (temp.right != null) stack1.push(temp.right);
                if (temp.left != null) stack1.push(temp.left);
            }
        }
        return temp_list;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);
        TreeNode t9 = new TreeNode(9);
        TreeNode t10 = new TreeNode(10);
        TreeNode t11 = new TreeNode(11);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        t4.left = t8;
        t4.right = t9;
        t5.left = t10;
        t5.right = t11;
        Solution s = new Solution();
        System.out.println(s.Print(t1));
    }
}

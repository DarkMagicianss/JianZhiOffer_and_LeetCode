package LeetCode.树.二叉搜索树迭代器;

import utils.TreeNode;

import java.util.LinkedList;

public class BSTIterator {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    TreeNode tree = null;
    TreeNode step = null;
    LinkedList<TreeNode> list = new LinkedList<>();

    public BSTIterator(TreeNode root) {
        this.tree = root;
        this.step = root;
        while (step != null && step.left != null) {
            list.addFirst(step);
            step = step.left;
        }
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        int result = step.val;
        if (step.right != null) {
            step = step.right;
            while (step.left != null) {
                list.addFirst(step);
                step = step.left;
            }
        } else {
            step = list.isEmpty() ? null : list.removeFirst();
        }
        return result;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return step != null;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(7);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(15);
        TreeNode t4 = new TreeNode(9);
        TreeNode t5 = new TreeNode(20);
        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        t3.right = t5;
        BSTIterator iterator = new BSTIterator(t1);
        int i = 0;
        boolean b = false;
        i = iterator.next();    // 返回 3
        System.out.println(i);
        i = iterator.next();    // 返回 7
        System.out.println(i);
        b = iterator.hasNext(); // 返回 true
        System.out.println(b);
        i = iterator.next();    // 返回 9
        System.out.println(i);
        b = iterator.hasNext(); // 返回 true
        System.out.println(b);
        i = iterator.next();    // 返回 15
        System.out.println(i);
        b = iterator.hasNext(); // 返回 true
        System.out.println(b);
        i = iterator.next();    // 返回 20
        System.out.println(i);
        b = iterator.hasNext(); // 返回 false
        System.out.println(b);

    }
}

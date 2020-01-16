package JianZhiOffer.JZ14举例让抽象问题具体化.从上往下打印二叉树;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (pRoot == null) return list;
        queue.add(pRoot);
        while (!queue.isEmpty()) {
            list.add(sub_Print(queue));
        }
        return list;
    }

    public ArrayList<Integer> sub_Print(LinkedList<TreeNode> queue) {
        ArrayList<Integer> temp_result = new ArrayList<>();
        int temp_num = queue.size();
        while (temp_num-- > 0) {
            TreeNode temp = queue.poll();
            temp_result.add(temp.val);
            if (temp.left != null) queue.add(temp.left);
            if (temp.right != null) queue.add(temp.right);
        }
        return temp_result;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        Solution s = new Solution();
        System.out.println(s.Print(t1));
    }
}

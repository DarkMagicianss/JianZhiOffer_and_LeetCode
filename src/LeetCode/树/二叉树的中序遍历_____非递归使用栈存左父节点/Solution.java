package LeetCode.树.二叉树的中序遍历_____非递归使用栈存左父节点;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        //若不改变原先的树结构的话 使用note里面的方法较好
        //自己写的非递归方法真是又长 又臭啊。。。优化了一点 稍稍好一点1ms
        List<Integer> result = new LinkedList<>();
        if (root == null) return result;
        //LinkedList记录父节点
        LinkedList<TreeNode> last_list = new LinkedList<>();
        TreeNode step = root;
        while (true) {
            if (step.left != null) {
                last_list.addFirst(step);
                step = step.left;
                continue;
            }
            result.add(step.val);
            if (step.right != null) {
                step = step.right;
                continue;
            }
            if (!last_list.isEmpty()) {
                //弹出上一个父节点 让其左节点为null 判断其右节点
                TreeNode temp = last_list.removeFirst();
                temp.left = null;//这里会改变原先的树的结构
                step = temp;
            } else {
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(2);
        t1.right = t2;
        t2.left = t3;
        System.out.println(s.inorderTraversal(t1));
    }
}

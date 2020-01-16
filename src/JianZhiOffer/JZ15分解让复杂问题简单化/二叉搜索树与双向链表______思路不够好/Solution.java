package JianZhiOffer.JZ15分解让复杂问题简单化.二叉搜索树与双向链表______思路不够好;

import utils.TreeNode;

public class Solution {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return null;
        sub_Convert(null, pRootOfTree);
        TreeNode result = pRootOfTree;
        while(result.left!=null)result = result.left;
        return result;
    }

    public TreeNode sub_Convert(TreeNode parent, TreeNode index) {
        if (index.left == null && index.right == null) return index;
        TreeNode left = null;
        TreeNode right = null;
        if (index.left != null) left = sub_Convert(index, index.left);
        if (index.right != null) right = sub_Convert(index, index.right);
        if (left != null) {
            index.left = left;
            left.right = index;
        }
        if (right != null) {
            index.right = right;
            right.left = index;
        }
        if (parent == null) return index;
        if (index == parent.left) {
            TreeNode max = index;
            while (max.right != null) max = max.right;//递归寻找右节点可能会浪费很多时间
            //System.out.println("left:" + max.val);
            return max;
        } else {
            TreeNode min = index;
            while (min.left != null) min = min.left;//递归寻找左节点可能会浪费很多时间
            //System.out.println("right:" + min.val);
            return min;
        }
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(8);
        TreeNode t2 = new TreeNode(6);
        TreeNode t3 = new TreeNode(10);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(7);
        TreeNode t6 = new TreeNode(9);
        TreeNode t7 = new TreeNode(11);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        Solution s = new Solution();
        TreeNode result = s.Convert(t1);
        while (result.left != null) {
            System.out.println(result.val);
            result = result.left;
        }
    }
}

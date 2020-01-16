package JianZhiOffer.JZDiff.二叉搜索树与双向链表______思路不够好;

import utils.TreeNode;

public class BetterSolution {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return null;
        TreeNode result = sub_Convert(null, pRootOfTree);
        while (result != null && result.left != null) result = result.left;
        return result;
    }

    public TreeNode sub_Convert(TreeNode lastNode, TreeNode curNode) {
        //递归遍历左子树
        if (curNode.left != null) {
            lastNode = sub_Convert(lastNode, curNode.left);
        }
        //当前节点的处理
        curNode.left = lastNode;
        if (lastNode != null) {
            lastNode.right = curNode;
        }
        lastNode = curNode;
        //递归遍历右子树
        if (curNode.right != null) {
            lastNode = sub_Convert(lastNode, curNode.right);
        }
        //返回尾节点
        return lastNode;
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
        BetterSolution s = new BetterSolution();
        TreeNode result = s.Convert(t1);
        while (result.right != null) {
            System.out.println(result.val);
            result = result.right;
        }
    }
}

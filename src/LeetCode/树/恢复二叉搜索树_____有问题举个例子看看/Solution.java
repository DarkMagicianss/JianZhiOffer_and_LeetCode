package LeetCode.树.恢复二叉搜索树_____有问题举个例子看看;

import utils.TreeNode;

public class Solution {
    TreeNode err1 = null;
    TreeNode err2 = null;
    TreeNode pre = null;
    public void recoverTree(TreeNode root) {
        sub_in_look(root);
        int temp = err1.val;
        err1.val = err2.val;
        err2.val = temp;
        return;
    }

    private void sub_in_look(TreeNode root) {
        if (root == null) return;
        sub_in_look(root.left);
        //因为中序遍历的 所有数据按理应该顺序排列 但是交换了两个值
        //大的值跑到了前面 小的值跑到了后面
        //例如1 3 8 5 6 7 4 9
        //因此err1是在出现异常时的pre节点8
        //因此err2是在出现异常时的root节点4
        if (pre != null) {
            if (root.val <= pre.val && err1 == null) err1 = pre;
            //这里的err1肯定是一开始最先出现异常的前一个点 而err2则 不确定了 因为会在两处异常 最后一次才是真正的异常
            if (root.val <= pre.val && err1 != null) err2 = root;
        }
        pre = root;
        sub_in_look(root.right);
        return;
    }

    private void in_look(TreeNode root) {
        if (root == null) return;
        in_look(root.left);
        System.out.println(root.val);
        in_look(root.right);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(4);
        TreeNode t4 = new TreeNode(2);
        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        s.recoverTree(t1);
        s.in_look(t1);
    }
}

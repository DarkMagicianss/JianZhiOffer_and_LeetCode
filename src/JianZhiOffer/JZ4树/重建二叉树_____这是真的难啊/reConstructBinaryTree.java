package JianZhiOffer.JZ4树.重建二叉树_____这是真的难啊;

import utils.TreeNode;

public class reConstructBinaryTree {
    //243ms
    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 0 && in.length == 0) return null;
        if (pre.length == 1 && in.length == 1) return new TreeNode(pre[0]);
        TreeNode tree_root = reConstruct(pre, 0, pre.length, in, 0, in.length);
        return tree_root;
    }

    private static TreeNode reConstruct(int[] pre, int pre_start, int pre_len, int[] in, int in_start, int in_len) {
        if (pre_len == 0 && in_len == 0) return null;
        if (pre_len == 1 && in_len == 1) return new TreeNode(pre[pre_start]);
        TreeNode tree_root = new TreeNode(pre[pre_start]);
        for (int i = 0; i < in_len; i++) {
            if (tree_root.val == in[in_start + i]) {
                int left_len = i;
                int right_len = in_len - i - 1;
                tree_root.left = reConstruct(pre, pre_start + 1, left_len, in, in_start, left_len);
                tree_root.right = reConstruct(pre, pre_start + left_len + 1, right_len, in, in_start + i + 1, right_len);
                return tree_root;
            }
        }
        return tree_root;
    }

    private static void pre_lookup(TreeNode index) {
        System.out.println("pre:" + index.val);
        if (index.left != null) {
            pre_lookup(index.left);
        }
        if (index.right != null) {
            pre_lookup(index.right);
        }
        return;
    }

    private static void in_lookup(TreeNode index) {
        if (index.left != null) {
            in_lookup(index.left);
        }
        System.out.println("in:" + index.val);
        if (index.right != null) {
            in_lookup(index.right);
        }
        return;
    }

    public static void main(String[] args) {
        int[] pre = new int[]{1,2,4,3,5,6};
        int[] in = new int[]{4,2,1,5,3,6};
        TreeNode root = reConstructBinaryTree(pre, in);
        pre_lookup(root);
        in_lookup(root);
    }


}

package LeetCode.树.二叉树的后序遍历_____困难题_树的遍历整理在一起;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        //逻辑马马虎虎 还可以 看起来有点麻烦
        List<Integer> result = new LinkedList<>();
        if (root == null) return result;
        //LinkedList一次记录两个Node 前一个为child 后一个为father
        LinkedList<TreeNode> r_list = new LinkedList<>();
        r_list.addFirst(null);//先添加父节点 null
        r_list.addFirst(root);//再添加子节点 root
        while (!r_list.isEmpty() && r_list.getFirst() != null) {
            TreeNode temp = r_list.removeFirst();
            if (temp.left == null && temp.right == null) {//若当前节点为叶子节点
                result.add(temp.val);
                TreeNode child = temp;
                //当前节点为叶子节点 则需要将父节点的该叶子节点砍断 这里改变了原先的数的结构
                while (!r_list.isEmpty() && r_list.getFirst() != null) {
                    TreeNode father = r_list.removeFirst();
                    if (father.left == child) {//当前叶子节点是其左子树
                        father.left = null;
                        if (father.right != null) {//若父节点存在右子树 继续循环判断
                            r_list.addFirst(father);
                            r_list.addFirst(father.right);
                            break;
                        }
                    }
                    //若当前叶子节点是其右子树 则直接判断父节点的父节点
                    father.right = null;
                    child = father;//将child节点赋值为当前父节点
                    result.add(father.val);
                }
            } else {
                //非叶子节点则若左子树不为空 则只添加左子树 否则添加右子树
                if (temp.left != null) {
                    //这种情况下的右子树在左子树遍历完的时候再添加
                    r_list.addFirst(temp);
                    r_list.addFirst(temp.left);
                }else{
                    r_list.addFirst(temp);
                    r_list.addFirst(temp.right);
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
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);
        TreeNode t9 = new TreeNode(9);
        t1.left = t2;
        t1.right = t3;
        t6.left = t4;
        t6.right = t5;
        t3.left = t6;
        t3.right = t7;
        t7.left = t8;
        t7.right = t9;
        System.out.println(s.postorderTraversal(t1));
    }
}

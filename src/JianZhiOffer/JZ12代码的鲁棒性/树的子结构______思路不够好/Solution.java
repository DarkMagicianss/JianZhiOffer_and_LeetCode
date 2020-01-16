package JianZhiOffer.JZ12代码的鲁棒性.树的子结构______思路不够好;


import utils.TreeNode;

public class Solution {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if(root1 == null || root2 == null)return false;
        boolean flag = false;
        return in_lookup(root1,root2,flag,1);
    }
    private boolean in_lookup(TreeNode index,TreeNode target,boolean flag,int level) {
        if (index.left != null) {
            flag = in_lookup(index.left,target,flag,level+1);
            if(flag == true)return flag;
        }
        if(index.val == target.val){
            //System.out.println("level:"+level+"   find root"+index.val+"  "+target.val);
            flag = in_equal(index,target,true);
            if(flag == true)return flag;
        }
        if (index.right != null) {
            flag = in_lookup(index.right,target,flag,level+1);
            if(flag == true)return flag;
        }
        return flag;
    }
    private boolean in_equal(TreeNode index,TreeNode target,boolean flag){
        if (index.left != null && target.left != null) {
            flag = in_equal(index.left,target.left,flag);
            if(flag == false)return flag;
        }else if(index.left == null && target.left!=null){
            return false;
        }
        if(index.val != target.val){
//            System.out.println("index:"+index.val);
//            System.out.println("target:"+target.val);
            return false;
        }
        if (index.right != null && target.right != null) {
            flag = in_equal(index.right,target.right,flag);
            if(flag == false)return flag;
        }else if(index.right == null && target.right!=null){
            return false;
        }
        return true;
    }
//    public static void main(String[] args) {
//        TreeNode t1 = new TreeNode(8);
//        TreeNode t2 = new TreeNode(8);
//        TreeNode t3 = new TreeNode(7);
//        TreeNode t4 = new TreeNode(9);
//        TreeNode t5 = new TreeNode(2);
//        TreeNode t6 = new TreeNode(4);
//        TreeNode t7 = new TreeNode(7);
//        t1.left = t2;t1.right=t3;
//        t2.left = t4;t2.right=t5;
//        t5.left=t6;t5.right=t7;
//        TreeNode t8 = new TreeNode(8);
//        TreeNode t9 = new TreeNode(9);
//        TreeNode t10 = new TreeNode(2);
//        t8.left=t9;t8.right=t10;
//        LRUCache s = new LRUCache();
//        System.out.println(s.HasSubtree(t1, t8));
//    }
}

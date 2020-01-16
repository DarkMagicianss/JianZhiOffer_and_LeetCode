package JianZhiOffer.JZ14举例让抽象问题具体化.二叉树中和为某一值的路径;

import utils.TreeNode;

import java.util.ArrayList;

public class Solution {
    public ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();
    public ArrayList<Integer> list = new ArrayList<Integer>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target){
        if (root == null) return resultList;
        list.add(root.val);
        int next_target = target - root.val;
        if(next_target == 0 && root.left==null && root.right == null)resultList.add(new ArrayList<>(list));
        if(root.left!=null && next_target>=root.left.val){
            FindPath(root.left,next_target);
        }
        if(root.right!=null && next_target>=root.right.val){
            FindPath(root.right,next_target);
        }
        list.remove(list.size()-1);
        return resultList;
    }

    public static void main(String[] args){
        TreeNode t1 = new TreeNode(8);
        TreeNode t2 = new TreeNode(6);
        TreeNode t3 = new TreeNode(10);
        TreeNode t4 = new TreeNode(4);
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
        s.FindPath(t1,18);
        for(int i=0;i<s.resultList.size();i++){
            ArrayList<Integer> list = s.resultList.get(i);
            for(int j=0;j<list.size();j++){
                System.out.print(list.get(j));
            }
            System.out.println(" ");
        }
    }
}

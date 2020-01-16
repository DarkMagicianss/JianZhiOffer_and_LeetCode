package LeetCode.树.将有序数组转换为二叉搜索树;

import utils.TreeNode;

public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        return sub_sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public TreeNode sub_sortedArrayToBST(int[] nums, int start, int end) {
        if(start > end)return null;
        int mid = (start + end) >> 1;
        TreeNode root = new TreeNode(nums[mid]);
        if(start == end)return root;
        root.left = sub_sortedArrayToBST(nums,start,mid - 1);
        root.right = sub_sortedArrayToBST(nums,mid + 1,end);
        return root;
    }

    private void in_look(TreeNode root) {
        if (root == null) return;
        in_look(root.left);
        System.out.println(root.val);
        in_look(root.right);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = new int[]{-10, -3, 0, 5, 9};
        s.in_look(s.sortedArrayToBST(arr));
    }
}

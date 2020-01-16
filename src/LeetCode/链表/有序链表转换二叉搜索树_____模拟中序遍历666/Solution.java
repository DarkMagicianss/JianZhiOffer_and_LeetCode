package LeetCode.链表.有序链表转换二叉搜索树_____模拟中序遍历666;


import utils.ListNode;
import utils.TreeNode;

public class Solution {
    ListNode temp_head = null;
    public TreeNode sortedListToBST(ListNode head) {
        //可以将链表转换成数组再进行操作 利用空间换取时间
        //这里利用模拟中序遍历的方式进行操作 时间复杂度为2*O(n)=O(n)
        if (head == null) return null;
        temp_head = head;
        int len = 0;
        ListNode step = head;
        while (step != null) {
            len++;
            step = step.next;
        }
        return sub_sortedListToBST(0, len - 1);
    }

    private TreeNode sub_sortedListToBST(int start, int end) {
        //正因为每次都是一半构成左子树 一半构成右子树 因此还是平衡的二叉树
        if (start > end) return null;
        int mid = (start + end) >> 1;
        TreeNode left = sub_sortedListToBST(start,mid - 1);
        //左子树一直递归下去 开始的地方正是最小的数 即链表的开头
        TreeNode temp = new TreeNode(temp_head.val);
        temp_head = temp_head.next;
        temp.left = left;
        TreeNode right = sub_sortedListToBST(mid + 1,end);
        temp.right = right;
        return temp;
    }

    private void in_look(TreeNode root) {
        if (root == null) return;
        in_look(root.left);
        System.out.println(root.val);
        in_look(root.right);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode l1 = new ListNode(-10);
        ListNode l2 = new ListNode(-3);
        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(9);
        ListNode l6 = new ListNode(13);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        s.in_look(s.sortedListToBST(l1));
    }
}

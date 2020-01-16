package LeetCode.链表.删除排序链表中的重复元素;


import utils.ListNode;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)return null;
        ListNode last_node = head;
        ListNode step = head.next;
        while (step != null) {
            while (step != null && step.val == last_node.val) {
                step = step.next;
            }
            last_node.next = step;
            last_node = step;
            if (step != null) step = step.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(4);
        ListNode l6 = new ListNode(4);
        ListNode l7 = new ListNode(5);
        ListNode l8 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = l8;
        ListNode result = s.deleteDuplicates(l1);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}

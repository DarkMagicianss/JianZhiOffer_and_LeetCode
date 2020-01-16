package LeetCode.链表.分隔链表;


import utils.ListNode;

public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        ListNode less_node = null;
        ListNode large_node = null;
        ListNode connet_node = null;
        ListNode result_node = null;
        if (head.val < x) {
            less_node = head;
            result_node = head;
        } else {
            large_node = head;
            connet_node = head;
        }
        ListNode step = head.next;
        while (step != null) {
            if (step.val < x) {
                if (less_node != null) {
                    less_node.next = step;
                } else {
                    result_node = step;
                }
                less_node = step;
            } else {
                if (large_node != null) {
                    large_node.next = step;
                } else {
                    connet_node = step;
                }
                large_node = step;
            }
            step = step.next;
        }
        if (large_node != null) large_node.next = null;//较大的链表后续为空
        if (less_node != null) less_node.next = connet_node;//较小的链表后续为较大的链表头
        else return head;//说明没有比x小的数值
        return result_node;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(2);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        ListNode result = s.partition(l1, 9);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}

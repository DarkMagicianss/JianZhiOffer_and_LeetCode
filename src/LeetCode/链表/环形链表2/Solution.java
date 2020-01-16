package LeetCode.链表.环形链表2;


import utils.ListNode;

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode first = head;
        ListNode second = head;
        while (first != null && second != null) {
            if (first.next != null) first = first.next.next;
            else return null;
            second = second.next;
            if (first == second) {
                first = head;
                break;
            }
        }
        if (first == null || second == null) return null;
        while (first != second) {
            first = first.next;
            second = second.next;
        }
        return first;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        l1.next = l2;
//        l2.next = l3;
//        l3.next = l4;
//        l4.next = l5;
//        l5.next = l3;
        Solution s = new Solution();
        System.out.println(s.detectCycle(l1).val);
    }
}

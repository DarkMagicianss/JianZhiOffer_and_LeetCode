package LeetCode.链表.环形链表;


import utils.ListNode;

public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode first = head;
        ListNode second = head;
        while (first != null && second != null) {
            if (first.next != null) first = first.next.next;
            else return false;
            second = second.next;
            if(first == second)return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        Solution s = new Solution();
        System.out.println(s.hasCycle(l1));
    }
}

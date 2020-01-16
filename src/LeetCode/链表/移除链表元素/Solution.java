package LeetCode.链表.移除链表元素;


import utils.ListNode;

public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        ListNode flag = new ListNode(0);
        ListNode result = flag;
        flag.next = head;
        ListNode step = flag.next;
        while (step != null) {
            if (step.val == val) {
                flag.next = step.next;
            }else {
                flag = step;
            }
            step = step.next;
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(6);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(6);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(4);
        ListNode l6 = new ListNode(5);
        ListNode l7 = new ListNode(6);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        Solution s = new Solution();
        ListNode result = s.removeElements(l1, 6);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}

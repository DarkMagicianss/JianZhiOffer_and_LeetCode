package LeetCode.链表.反转链表2;


import utils.ListNode;

public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null)return head;
        ListNode zero_node = new ListNode(0);
        zero_node.next = head;
        int count = 0;
        ListNode step = zero_node;
        ListNode last = zero_node;
        ListNode start = zero_node;
        while(step!= null){
            if(count >= m && count < n){
                ListNode next = step.next;
                ListNode next_next = step.next.next;
                start = last.next;
                last.next = next;
                next.next = start;
                step.next = next_next;
                count++;
                continue;
            }
            last = step;
            step = step.next;
            count++;
        }
        return zero_node.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
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
        ListNode result = s.reverseBetween(l1, 2,5);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}

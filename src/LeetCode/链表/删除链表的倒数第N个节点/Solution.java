package LeetCode.链表.删除链表的倒数第N个节点;


import utils.ListNode;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 0) return head;
        ListNode result = head;
        ListNode step = head;
        ListNode re_node = null;//记录倒数第n+1个节点就可以了
        int index = 0;
        while (step != null) {
            index++;
            if (index == n + 1) {
                re_node = result;
                step = step.next;
                continue;
            }
            re_node = re_node == null ? re_node : re_node.next;
            step = step.next;
        }
        if (re_node != null) re_node.next = re_node.next.next;
        if(index == n)result = result.next;
        return result;
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
        ListNode result = s.removeNthFromEnd(l1, 6);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}

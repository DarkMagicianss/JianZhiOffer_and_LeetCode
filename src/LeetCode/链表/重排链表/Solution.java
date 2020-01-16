package LeetCode.链表.重排链表;


import utils.ListNode;

public class Solution {
    public void reorderList(ListNode head) {
        if (head == null) return;
        ListNode fast = head;
        ListNode low = head;
        //一个快指针一个慢指针
        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            low = low.next;
        }
        //当快指针到达最后的时候 慢指针正好在中间 将慢指针后续的链表进行反转
        ListNode flag = low;
        low = low.next;
        while (low != null) {
            ListNode next = low.next;
            ListNode last = flag.next;
            flag.next = low;
            if (!(low == last)) low.next = last;
            else low.next = null;
            low = next;
        }
        //然后进行重排
        ListNode second = flag.next;
        ListNode first = head;
        flag.next = null;
        while (second != null) {
            ListNode f_next = first.next;
            ListNode s_next = second.next;
            first.next = second;
            second.next = f_next;
            first = f_next;
            second = s_next;
        }
        return;
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
        s.reorderList(l1);
        while (l1 != null) {
            System.out.println(l1.val);
            l1 = l1.next;
        }
    }
}

package LeetCode.链表.反转链表;


import utils.ListNode;

public class Solution {
    //迭代的方法
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode zero = new ListNode(0);
        zero.next = head;
        ListNode step = head.next;
        head.next = null;
        while (step != null) {
            ListNode next = step.next;
            ListNode last_next = zero.next;
            zero.next = step;
            step.next = last_next;
            step = next;
        }
        return zero.next;
    }
    //递归的方法
//    public ListNode reverseList(ListNode head) {
//        if (head == null || head.next == null) return head;
//        ListNode zero = new ListNode(0);
//        zero.next = head;
//        sub_reverseList(zero,head.next);
//        head.next = null;
//        return zero.next;
//    }
//    public void sub_reverseList(ListNode last_node,ListNode head){
//        if(head == null)return ;
//        ListNode next = head.next;
//        ListNode last_next = last_node.next;
//        last_node.next = head;
//        head.next = last_next;
//        sub_reverseList(last_node,next);
//    }
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
        ListNode result = s.reverseList(l1);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}

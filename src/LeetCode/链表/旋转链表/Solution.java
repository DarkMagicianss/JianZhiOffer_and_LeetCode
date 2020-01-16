package LeetCode.链表.旋转链表;

import utils.ListNode;

public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        if (k == 0) return head;
        ListNode tail = null;
        ListNode second = null;
        ListNode last_second = null;
        //若第一次没找到second这个节点 则说明k超过链表的长度 再找一次
        while (second == null){
            int step = 0;
            ListNode first = head;
            while (first != null) {
                if (second != null) {
                    last_second = second;
                    second = second.next;
                }
                step++;
                if (step == k) {
                    second = head;
                }
                if (first.next == null) tail = first;
                first = first.next;
            }
            k = k % step;
            if (k == 0) return head;
        }
        if (last_second != null) last_second.next = null;
        tail.next = head;//将链表头尾相接
        return second;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);//2
        ListNode l2 = new ListNode(2);//4
        ListNode l3 = new ListNode(3);//3
        //ListNode l4 = new ListNode(4);//5
        //ListNode l5 = new ListNode(5);//6
        //ListNode l6 = new ListNode(6);//4
        l1.next = l2;
        l2.next = l3;
        //l3.next = l4;
        //l4.next = l5;
        //l5.next = l6;
        Solution s = new Solution();
        ListNode result = s.rotateRight(l1, 4);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}

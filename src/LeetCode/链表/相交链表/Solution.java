package LeetCode.链表.相交链表;

import utils.ListNode;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        int len1 = 1;
        ListNode step1 = headA;
        while (step1.next != null) {
            len1++;
            step1 = step1.next;
        }
        int len2 = 1;
        ListNode step2 = headB;
        while (step2.next != null) {
            len2++;
            step2 = step2.next;
        }
        if (step1 != step2) return null;//则没有重叠
        if (len1 > len2) {
            int dis = len1 - len2;
            int index = 0;
            while (index < dis) {
                headA = headA.next;
                index++;
            }
        } else if (len1 < len2) {
            int dis = len2 - len1;
            int index = 0;
            while (index < dis) {
                headB = headB.next;
                index++;
            }
        }
        step1 = headA;
        step2 = headB;
        while (step1 != step2) {
            step1 = step1.next;
            step2 = step2.next;
        }
        return step1;
    }

    public static void main(String[] args) {
        ListNode l11 = new ListNode(4);
        ListNode l12 = new ListNode(1);
        ListNode l21 = new ListNode(5);
        ListNode l22 = new ListNode(0);
        ListNode l23 = new ListNode(1);
        l11.next = l12;
        l21.next = l22;
        l22.next = l23;
        ListNode l31 = new ListNode(8);
        ListNode l32 = new ListNode(4);
        ListNode l33 = new ListNode(5);
        l12.next = l31;
        l23.next = l31;
        l31.next = l32;
        l32.next = l33;
        Solution s = new Solution();
        ListNode result = s.getIntersectionNode(l11, l21);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}

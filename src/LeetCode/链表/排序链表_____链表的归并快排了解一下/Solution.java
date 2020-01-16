package LeetCode.链表.排序链表_____链表的归并快排了解一下;

import utils.ListNode;

public class Solution {
    public ListNode sortList(ListNode head) {
        return mergerSort(head, null);
    }

    public ListNode mergerSort(ListNode head, ListNode tail) {
        if (head == null || head == tail) return head;
        ListNode mid = head;
        ListNode low = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            mid = low;
            low = low.next;
            fast = fast.next.next;
        }
        //System.out.println(mid.val);
        ListNode right = mergerSort(mid.next, tail);
        mid.next = null;
        ListNode left = mergerSort(head, mid);
        return merge(left, right);
    }

    public ListNode merge(ListNode list1, ListNode list2) {
        ListNode step = new ListNode(Integer.MIN_VALUE);
        ListNode result = step;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                step.next = list1;
                list1 = list1.next;
            } else {
                step.next = list2;
                list2 = list2.next;
            }
            step = step.next;
        }
        while (list1 != null) {
            step.next = list1;
            list1 = list1.next;
            step = step.next;
        }
        while (list2 != null) {
            step.next = list2;
            list2 = list2.next;
            step = step.next;
        }
        return result.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(5);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(0);
        ListNode l6 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        ListNode result = s.sortList(l1);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}

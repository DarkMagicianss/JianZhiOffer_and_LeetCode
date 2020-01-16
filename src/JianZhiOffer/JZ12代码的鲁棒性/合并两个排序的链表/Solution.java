package JianZhiOffer.JZ12代码的鲁棒性.合并两个排序的链表;


import utils.ListNode;

public class Solution {
    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode head;
        if (list1.val < list2.val) {
            head = list1;
            list1 = list1.next;
        } else {
            head = list2;
            list2 = list2.next;
        }
        ListNode result = head;
        while (list1 != null || list2 != null) {
            if (list1 == null) {
                head.next = list2;
                break;
            }
            if (list2 == null) {
                head.next = list1;
                break;
            }
            if (list1.val < list2.val) {
                head.next = list1;
                list1 = list1.next;
            } else {
                head.next = list2;
                list2 = list2.next;
            }
            head = head.next;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l3;
        l3.next = l5;
        l2.next = l4;
        Solution s = new Solution();
        ListNode result = s.Merge(l1, l2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}

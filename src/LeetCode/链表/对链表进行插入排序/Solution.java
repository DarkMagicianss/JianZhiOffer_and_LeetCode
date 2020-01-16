package LeetCode.链表.对链表进行插入排序;


import utils.ListNode;

public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;
        ListNode zero = new ListNode(Integer.MIN_VALUE);
        zero.next = head;
        ListNode step = head;
        ListNode cur = head.next;
        while (cur != null) {
            //只交换前者比后者大的Node
            if (cur.val >= step.val) {
                step.next = cur;
                step = cur;
                cur = cur.next;
                continue;
            }
            ListNode cur_next = cur.next;
            step.next = null;
            ListNode start = zero.next;
            ListNode last = zero;
            while (start != null && start.val < cur.val) {//从小开始找到比cur大的一个节点
                last = start;
                start = start.next;
            }
            last.next = cur;
            cur.next = start;
            cur = cur_next;
        }
        return zero.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode l1 = new ListNode(-1);
        ListNode l2 = new ListNode(5);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(-0);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        ListNode result = s.insertionSortList(l1);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}

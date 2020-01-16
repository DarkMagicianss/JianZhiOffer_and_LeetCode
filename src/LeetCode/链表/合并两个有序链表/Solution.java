package LeetCode.链表.合并两个有序链表;

import utils.ListNode;

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode result = null;
        ListNode one = null;
        ListNode another = null;
        if (l1.val > l2.val) {//得出较小的数值的为other
            one = l2;
            another = l1;
        } else {
            one = l1;
            another = l2;
        }
        result = one;//记录头指针
        while (one != null && another != null) {
            if (one.next == null) {//若当前链已经达到最后
                one.next = another;
                return result;
            }else{
                ListNode r_next = one.next;
                if (r_next.val >= another.val) {//比较result的后一个节点
                    one.next = another;
                    another = another.next;//另一条链继续走一步
                    one = one.next;
                    one.next = r_next;
                } else {
                    one = one.next;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(4);
        ListNode l21 = new ListNode(1);
        ListNode l22 = new ListNode(3);
        ListNode l23 = new ListNode(4);
        l11.next = l12;
        l12.next = l13;
        l21.next = l22;
        l22.next = l23;
        Solution s = new Solution();
        ListNode result = s.mergeTwoLists(l11, l21);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}

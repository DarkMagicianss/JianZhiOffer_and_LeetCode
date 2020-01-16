package JianZhiOffer.JZ12代码的鲁棒性.链表中环的入口节点;


import utils.ListNode;

import java.util.HashSet;

public class Solution {
    HashSet<ListNode> set = new HashSet<>();
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        while (pHead != null) {
            if (set.contains(pHead)) return pHead;
            else {
                set.add(pHead);
                pHead = pHead.next;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l3;
        Solution s = new Solution();
        System.out.println(s.EntryNodeOfLoop(l1));
    }
}

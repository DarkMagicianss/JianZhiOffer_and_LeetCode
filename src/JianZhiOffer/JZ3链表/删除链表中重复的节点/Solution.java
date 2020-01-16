package JianZhiOffer.JZ3链表.删除链表中重复的节点;

import utils.ListNode;

public class Solution {
    public ListNode deleteDuplication(ListNode pHead) {
        ListNode old_Node = pHead;
        ListNode new_Node = null;
        ListNode result = null;
        while (old_Node != null) {
            boolean flag = false;
            //重复则继续往后走 置位flag
            while (old_Node.next != null && old_Node.next.val == old_Node.val) {
                flag = true;
                old_Node = old_Node.next;
            }
            //标记为true 说明前面已有重复 再往后走一步 进入下一次循环！！！
            if (flag == true) {
                old_Node = old_Node.next;
                continue;
            }
            //到这里说明已经找到不重复的节点了
            if (new_Node == null) {
                new_Node = old_Node;
                result = new_Node;
            } else {
                new_Node.next = old_Node;
                new_Node = new_Node.next;
            }
            old_Node = old_Node.next;
        }
        if (new_Node != null) new_Node.next = null;
        return result;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(1);
        ListNode l6 = new ListNode(1);
        ListNode l7 = new ListNode(1);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        Solution s = new Solution();
        ListNode result = s.deleteDuplication(l1);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}

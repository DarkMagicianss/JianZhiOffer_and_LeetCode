package LeetCode.链表.删除排序链表中的重复元素2;


import utils.ListNode;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode zero_node = null;
        //创建一个自定义头节点
        if (head.val != 0) zero_node = new ListNode(0);
        else zero_node = new ListNode(-1);
        zero_node.next = head;

        ListNode last_last_node = null;
        ListNode last_node = zero_node;
        ListNode step = zero_node.next;//head
        while (step != null) {
            boolean isDuplicates = false;
            while (step != null && step.val == last_node.val) {
                isDuplicates = true;
                step = step.next;
            }
            if (!isDuplicates) {
                if (last_last_node != null) last_last_node.next = last_node;
                last_last_node = last_node;//初始化时 说明第0个元素不重复 初始化为zero
            }
            last_node = step;
            if (step != null) step = step.next;
        }
        last_last_node.next = last_node;
        return zero_node.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(3);
        ListNode l7 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        ListNode result = s.deleteDuplicates(l1);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}

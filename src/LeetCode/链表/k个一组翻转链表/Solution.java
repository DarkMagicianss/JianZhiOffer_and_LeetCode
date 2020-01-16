package LeetCode.链表.k个一组翻转链表;

import utils.ListNode;

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1 || head == null || head.next == null) return head;
        int count = 0;
        ListNode last_tail = new ListNode(0);
        last_tail.next = head;//自定义的初始节点
        ListNode result = last_tail;//用于记录头结点
        ListNode step = head;
        while (step != null) {
            count++;
            if (count == k) {
                //进行k个节点的翻转
                ListNode next = step.next;//先保留第k+1个节点
                ListNode first_node = last_tail.next;//用于记录这k的节点中最开头的节点
                ListNode now_node = last_tail.next.next;//用于记录当前需要进行翻转的节点
                first_node.next = next;//最开始的节点指向下一个k节点翻转的头节点
                step = first_node;//让step指向翻转后的最后一个节点
                while (now_node != next) {
                    ListNode now_next = now_node.next;//记录当前翻转节点的后一个节点
                    last_tail.next = now_node;//上一个k长的链表尾节点指向当前节点
                    now_node.next = first_node;//当前节点指向最开头的节点
                    first_node = now_node;//最开始的节点更新
                    now_node = now_next;//当前节点更新
                }
                last_tail = step;
                count = 0;
            }
            step = step.next;
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(3);
        ListNode l14 = new ListNode(4);
        ListNode l15 = new ListNode(5);
        ListNode l16 = new ListNode(6);
        ListNode l17 = new ListNode(7);
        ListNode l18 = new ListNode(8);
        l11.next = l12;
        l12.next = l13;
        l13.next = l14;
        l14.next = l15;
        l15.next = l16;
        l16.next = l17;
        l17.next = l18;
        Solution s = new Solution();
        ListNode result = s.reverseKGroup(l11, 3);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}

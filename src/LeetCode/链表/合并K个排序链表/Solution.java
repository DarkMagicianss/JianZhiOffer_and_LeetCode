package LeetCode.链表.合并K个排序链表;

import utils.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        //维护一个n长的优先队列
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return (o1.val - o2.val);
            }
        });
        for (int i = 0; i < lists.length; i++) {//添加每个链表的头节点
            if (lists[i] != null) queue.add(lists[i]);
        }
        ListNode result = null;
        ListNode step = null;
        if (!queue.isEmpty()) {//确定结果的头节点
            result = queue.poll();
            if(result.next != null)queue.add(result.next);
            step = result;
        }
        //进行后续节点的弹出和插入
        while (!queue.isEmpty()) {
            step.next = queue.poll();
            step = step.next;
            if (step.next != null) queue.add(step.next);
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(5);
        ListNode l21 = new ListNode(1);
        ListNode l22 = new ListNode(3);
        ListNode l23 = new ListNode(4);
        ListNode l31 = new ListNode(2);
        ListNode l32 = new ListNode(6);
        l11.next = l12;
        l12.next = l13;
        l21.next = l22;
        l22.next = l23;
        l31.next = l32;
        lists[0] = l11;
        lists[1] = l21;
        lists[2] = l31;
        Solution s = new Solution();
        ListNode result = s.mergeKLists(lists);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}

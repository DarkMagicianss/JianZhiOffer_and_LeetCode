package LeetCode.链表.两两交换链表中的节点;

import utils.ListNode;

public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode head_0 = new ListNode(0);
        head_0.next = head;//补充一个头结点 方便计算
        ListNode result = head_0;//记录当前的头节点
        ListNode head_1 = head;
        ListNode head_2 = head.next;
        int count = 1;
        while (head_2 != null) {
            count++;//除去自己添加的第0个之外 从第二个开始
            if((count & 1) == 0){//count为偶数
                ListNode next = head_2.next;//记录下一个节点next
                head_0.next = head_2;//前前节点指向当前节点head_2
                head_2.next = head_1;//当前节点指向上一个节点head_11
                head_1.next = next;//前节点指向下一个节点next
                //对head_1和head_2进行交换
                ListNode temp = head_2;
                head_2 = head_1;
                head_1 = temp;
            }
            //所有节点进行向右移动
            head_0 = head_0.next;
            head_1 = head_1.next;
            head_2 = head_2.next;
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode l11 = new ListNode(1);//2
        ListNode l12 = new ListNode(2);//4
        ListNode l13 = new ListNode(3);//3
        ListNode l14 = new ListNode(4);//5
        ListNode l15 = new ListNode(5);//6
        ListNode l16 = new ListNode(6);//4
        l11.next = l12;
        l12.next = l13;
        l13.next = l14;
        l14.next = l15;
        l15.next = l16;
        Solution s = new Solution();
        ListNode result = s.swapPairs(l11);
        while (result.next != null) {
            System.out.println(result.val);
            result = result.next;
        }
        System.out.println(result.val);
    }
}

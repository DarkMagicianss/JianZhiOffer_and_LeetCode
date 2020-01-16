package JianZhiOffer.JZ12代码的鲁棒性.反转链表;


import utils.ListNode;

public class Solution {
    public ListNode ReverseList(ListNode head) {
        if(head== null)return null;
        ListNode node_next = head.next;
        ListNode node_last = head;
        while(node_next!= null){
            ListNode node_next_temp = node_next.next;
            node_next.next = node_last;
            node_last = node_next;
            node_next = node_next_temp;
        }
        head.next=null;
        return node_last;
    }
    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        Solution s = new Solution();
        ListNode result = s.ReverseList(l1);
        while(result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}

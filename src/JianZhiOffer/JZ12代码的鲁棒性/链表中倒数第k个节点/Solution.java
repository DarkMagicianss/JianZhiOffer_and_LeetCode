package JianZhiOffer.JZ12代码的鲁棒性.链表中倒数第k个节点;


import utils.ListNode;

public class Solution {
    public ListNode FindKthToTail(ListNode head, int k) {
        if(head == null || k<=0)return null;
        ListNode end = head;
        ListNode last_k = head;
        for(int i=0;i<k-1;i++){
            if(end.next!= null){
                end = end.next;
            }else {
                return null;
            }
        }
        while(end.next!=null){
            end = end.next;
            last_k = last_k.next;
        }
        return last_k;
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
        ListNode result = s.FindKthToTail(l1,5);
        while(result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}

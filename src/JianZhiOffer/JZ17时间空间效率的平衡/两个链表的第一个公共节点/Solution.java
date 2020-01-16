package JianZhiOffer.JZ17时间空间效率的平衡.两个链表的第一个公共节点;

import utils.ListNode;

import java.util.HashSet;

public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) return null;
        HashSet<Integer> s1 = new HashSet<>();
        HashSet<Integer> s2 = new HashSet<>();
        while(pHead1 != null || pHead2 != null){
            if(pHead1 !=null){
                if(s2.contains(pHead1.val))return pHead1;
                s1.add(pHead1.val);
                pHead1 = pHead1.next;
            }
            if(pHead2 !=null){
                if(s1.contains(pHead2.val))return pHead2;
                s2.add(pHead2.val);
                pHead2 = pHead2.next;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

    }
}

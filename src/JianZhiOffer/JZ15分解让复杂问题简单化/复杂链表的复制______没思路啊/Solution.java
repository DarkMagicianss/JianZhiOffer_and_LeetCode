package JianZhiOffer.JZ15分解让复杂问题简单化.复杂链表的复制______没思路啊;

import utils.RandomListNode;

public class Solution {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) return null;
        RandomListNode step1 = pHead;
        //1.复制原节点
        while (step1 != null) {
            RandomListNode _step = new RandomListNode(step1.label);//复制每一个链表节点
            RandomListNode next = step1.next;
            step1.next = _step;//将复制的链表节点接在原节点之后
            _step.next = next;
            step1 = next;
        }
        //2.复制原节点的随机节点
        RandomListNode step2 = pHead;
        while (step2 != null) {
            RandomListNode _step = step2.next;
            RandomListNode rln = step2.random;//原节点的随机节点
            //新复制的节点的随机节点就是原节点的随机节点的后一个节点
            if (rln != null) _step.random = rln.next;
            step2 = _step.next;
        }
        //3.按照偶数取出复制的链表 题目这里的意思可能需要将原链表和新链表完全分离开来
        RandomListNode step3 = pHead;
        RandomListNode result = pHead.next;
        while (step3 != null) {
            RandomListNode clone_node = step3.next;
            step3.next = clone_node.next;
            if (clone_node.next != null)
                clone_node.next = clone_node.next.next;
            step3 = step3.next;
        }
        return result;
    }

    public static void main(String[] args) {
        RandomListNode r1 = new RandomListNode(1);
        RandomListNode r2 = new RandomListNode(2);
        RandomListNode r3 = new RandomListNode(3);
        RandomListNode r4 = new RandomListNode(4);
        RandomListNode r5 = new RandomListNode(5);
        r1.next = r2;
        r2.next = r3;
        r3.next = r4;
        r4.next = r5;
        r1.random = r3;
        r2.random = r5;
        r3.random = null;
        r4.random = r2;
        r5.random = null;
        Solution s = new Solution();
        RandomListNode result = s.Clone(r1);
        RandomListNode s1 = result;
        while (s1 != null) {
            System.out.println(s1.label);
            s1 = s1.next;
        }
    }
}

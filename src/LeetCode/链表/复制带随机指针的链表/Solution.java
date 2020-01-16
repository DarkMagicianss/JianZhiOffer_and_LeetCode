package LeetCode.链表.复制带随机指针的链表;

public class Solution {
    // Definition for a Node.
    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {
        }

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }

    public Node copyRandomList(Node head) {
        //就是破坏了原链表
        if (head == null) return null;
        if (head.next == null && head.random == null) return new Node(head.val, null, null);
        Node step = head;
        while (step != null) {//在每一个节点后面复制一个新节点
            Node next = step.next;
            Node new_one = new Node(step.val, next, null);
            step.next = new_one;
            step = next;
        }
        Node result = head.next;
        step = head;
        while (step != null) {
            Node next_random = step.random;
            Node new_one = step.next;
            //则新节点的随机节点就是 原来老随机节点的后一个新随机节点
            if (next_random != null) new_one.random = next_random.next;
            step = new_one.next;
            if (step != null) new_one.next = step.next;
        }
        head.next = null;
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Node n1 = s.new Node(1, null, null);
        Node n2 = s.new Node(2, null, null);
        Node n3 = s.new Node(3, null, null);
        n1.next = n2;
        n2.next = n3;
        n1.random = n2;
        n3.random = n2;
        n2.random = null;
        Node result = s.copyRandomList(n1);
        while (result != null) {
            System.out.println(result.val);
            result = result.random;
        }
    }
}

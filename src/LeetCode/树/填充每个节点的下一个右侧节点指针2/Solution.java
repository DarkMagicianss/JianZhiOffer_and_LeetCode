package LeetCode.树.填充每个节点的下一个右侧节点指针2;

import utils.Node;

public class Solution {
    public Node connect(Node root) {
        if (root == null) return root;
        Node last_node = root;
        while (last_node != null) {
            last_node = sub_connect(last_node);
        }
        return root;
    }

    public Node sub_connect(Node last_node) {
        Node next_node = null;
        Node step_node = null;
        while (last_node != null) {
            for (int i = 0; i < 2; i++) {//遍历左右子节点
                Node temp = i == 0 ? last_node.left : last_node.right;
                if (temp != null) {
                    if (next_node == null) next_node = temp;
                    if (step_node == null) {
                        step_node = temp;
                    } else {
                        step_node.next = temp;
                        step_node = step_node.next;
                    }
                }
            }
            last_node = last_node.next;
        }
        return next_node;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Node n1 = new Node(1, null, null, null);
        Node n2 = new Node(2, null, null, null);
        Node n3 = new Node(3, null, null, null);
        Node n4 = new Node(4, null, null, null);
        Node n5 = new Node(5, null, null, null);
        Node n6 = new Node(6, null, null, null);
        Node n7 = new Node(7, null, null, null);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        s.connect(n1);
        System.out.println();
        System.out.println(n1.next);
        System.out.println(n2.next.val);
        System.out.println(n3.next);
        System.out.println(n4.next.val);
        System.out.println(n5.next.val);
        System.out.println(n6.next.val);
        System.out.println(n7.next);
    }
}


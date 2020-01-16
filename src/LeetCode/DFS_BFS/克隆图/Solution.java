package LeetCode.DFS_BFS.克隆图;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
        }

        public Node(int _val, List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    //使用HashMap通过的 但是万一出现两个数值相同的节点不就GG了吗？？？
    HashMap<Integer, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        if (node.neighbors == null) return new Node(node.val, null);
        if (node.neighbors.size() == 0) return new Node(node.val, new ArrayList<>());
        ArrayList<Node> list = new ArrayList<>();
        Node root = new Node(node.val, list);
        map.put(root.val, root);
        for (int i = 0; i < node.neighbors.size(); i++) {
            list.add(sub_cloneGraph(node.neighbors.get(i)));
        }
        return root;
    }

    public Node sub_cloneGraph(Node copy_node) {
        if (map.containsKey(copy_node.val)) return map.get(copy_node.val);
        ArrayList<Node> list = new ArrayList<>();
        Node root = new Node(copy_node.val, list);
        map.put(root.val, root);
        for (int i = 0; i < copy_node.neighbors.size(); i++) {
            Node temp = copy_node.neighbors.get(i);
            if (!map.containsKey(temp.val)) {
                list.add(sub_cloneGraph(temp));
            } else {
                //System.out.println(root.val + "   " + temp.val);
                root.neighbors.add(map.get(temp.val));
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ArrayList<Node> list1 = new ArrayList<>();
        Node n1 = s.new Node(1, list1);
        ArrayList<Node> list2 = new ArrayList<>();
        Node n2 = s.new Node(2, list2);
        ArrayList<Node> list3 = new ArrayList<>();
        Node n3 = s.new Node(3, list3);
        ArrayList<Node> list4 = new ArrayList<>();
        Node n4 = s.new Node(4, list4);
        list1.add(n2);
        list1.add(n4);
        list1.add(n3);
        list2.add(n1);
        list2.add(n3);
        list2.add(n4);
        list3.add(n2);
        list3.add(n4);
        list3.add(n1);
        list4.add(n1);
        list4.add(n2);
        list4.add(n3);
        Node result = s.cloneGraph(n1);
        System.out.println("root1:" + result.val);
        for (int i = 0; i < result.neighbors.size(); i++) {
            Node temp = result.neighbors.get(i);
            System.out.println(" " + result.val + ":   " + temp.val);
            for (int j = 0; j < temp.neighbors.size(); j++) {
                System.out.println("  " + temp.val + ":   " + temp.neighbors.get(j).val);
            }
        }
    }
}


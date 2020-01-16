package LeetCode.树.单词搜索2_____字典树和回溯的结合;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {
    class TrieNode {
        int path;
        int end;//表明是否有单词在这个Node上结束
        TrieNode[] nodes;
        public TrieNode() {
            this.path = 0;
            this.end = 0;
            this.nodes = new TrieNode[26];
        }
    }
    private TrieNode root = new TrieNode();
    private HashSet<String> result = new HashSet<>();
    public List<String> findWords(char[][] board, String[] words) {
        if (words == null || words.length == 0) return new ArrayList<>(result);
        int row = board.length;
        int col = board[0].length;
        boolean[][] flag = new boolean[row][col];
        for (int i = 0; i < words.length; i++) {//构造字典树
            char[] arr = words[i].toCharArray();
            TrieNode step = root;
            step.path++;
            for (int j = 0; j < arr.length; j++) {
                int index = arr[j] - 'a';
                if (step.nodes[index] == null) {
                    step.nodes[index] = new TrieNode();
                }
                step = step.nodes[index];
                step.path++;
            }
            step.end++;
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //从每个节点开始寻找判断其是否有对应的单词
                sub_findWords(i, j, board, "", root, flag);
            }
        }
        return new ArrayList<>(result);
    }

    private void sub_findWords(int i, int j, char[][] board, String now_str, TrieNode root, boolean[][] flag) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || flag[i][j] == true) return;
        now_str = now_str + board[i][j];
        int index = now_str.charAt(now_str.length() - 1) - 'a';//当前新添加的字母对应的index
        if (root.nodes[index] == null) return;
        if (root.nodes[index].end != 0) {
            //虽然当前节点和之前的能连成单词 但是后续的仍然可能再组成其他单词 因此不需要return
            result.add(now_str);
        }
        flag[i][j] = true;
        sub_findWords(i - 1, j, board, now_str, root.nodes[index], flag);
        sub_findWords(i + 1, j, board, now_str, root.nodes[index], flag);
        sub_findWords(i, j - 1, board, now_str, root.nodes[index], flag);
        sub_findWords(i, j + 1, board, now_str, root.nodes[index], flag);
        flag[i][j] = false;
        return;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] board = new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        String[] words = new String[]{"oath", "pea", "eat", "rain"};
        List<String> reslut = s.findWords(board, words);
        for (int i = 0; i < reslut.size(); i++) {
            System.out.println(reslut.get(i));
        }
    }
}

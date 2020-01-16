package LeetCode.树.实现Trie_前缀树_字典树_单词查找树_____学习;

public class Trie {
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

    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        if (word == null) return;
        char[] arr = word.toCharArray();
        TrieNode step = root;
        step.path++;
        for (int i = 0; i < arr.length; i++) {
            int index = arr[i] - 'a';
            if (step.nodes[index] == null) {
                step.nodes[index] = new TrieNode();
            }
            step = step.nodes[index];
            step.path++;
        }
        step.end++;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        if (word == null) return false;
        char[] arr = word.toCharArray();
        TrieNode step = root;
        for (int i = 0; i < arr.length; i++) {
            int index = arr[i] - 'a';
            if (step.nodes[index] == null) return false;
            step = step.nodes[index];
        }
        return step.end != 0;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        if (prefix == null) return false;
        char[] arr = prefix.toCharArray();
        TrieNode step = root;
        for (int i = 0; i < arr.length; i++) {
            int index = arr[i] - 'a';
            if (step.nodes[index] == null) return false;
            step = step.nodes[index];
        }
        return step.path != 0;
    }

    public static void main(String[] args) {
        Trie s = new Trie();

    }
}

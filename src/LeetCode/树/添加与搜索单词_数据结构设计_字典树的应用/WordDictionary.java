package LeetCode.树.添加与搜索单词_数据结构设计_字典树的应用;


public class WordDictionary {
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
    public WordDictionary() {
        root = new TrieNode();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
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
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return sub_search(root, word);
    }

    public boolean sub_search(TrieNode root, String word) {
        if (word == null) return false;
        char[] arr = word.toCharArray();
        TrieNode step = root;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '.') {
                //一旦某个位置为. 则递归判断
                for (int j = 0; j < step.nodes.length; j++) {
                    //从i+1的位置开始字符串的剪接
                    if (step.nodes[j] != null && sub_search(step.nodes[j], word.substring(i + 1)))
                        return true;
                }
                return false;
            } else {
                int index = arr[i] - 'a';
                if (step.nodes[index] == null) return false;
                step = step.nodes[index];
            }
        }
        //有多个相同的字符串 对应的终点会累加
        return step.end != 0;
    }

    public static void main(String[] args) {
        WordDictionary w = new WordDictionary();
        w.addWord("a");
        w.addWord("a");
        System.out.println(w.search("."));
        System.out.println(w.search("a"));
        System.out.println(w.search("aa"));
        System.out.println(w.search("a"));
        System.out.println(w.search(".a"));
        System.out.println(w.search("a."));
    }
}

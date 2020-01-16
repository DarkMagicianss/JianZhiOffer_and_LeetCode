package LeetCode.字符串.最后一个单词的长度;

public class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        if (s.equals("") || s.equals(" ")) return 0;
        if (s.length() == 1) return 1;
        char[] arr = s.toCharArray();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == ' ') {
                return s.length() - i - 1;
            }
        }
        return s.length();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int result = s.lengthOfLastWord("aa basd");
        System.out.println(result);
    }
}


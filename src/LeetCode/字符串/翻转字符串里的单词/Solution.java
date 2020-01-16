package LeetCode.字符串.翻转字符串里的单词;


public class Solution {
    public String reverseWords(String s) {
        if (s == null || s.equals("")) return s;
        s = s.trim();
        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; i--) {
            if (!strs[i].equals("")) {
                sb.append(strs[i] + " ");
            }
        }
        //注意StringBuilde中可能为空
        if(sb.length() !=0)
            return sb.substring(0, sb.length() - 1);
        else
            return "";
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.reverseWords(""));
        System.out.println(s.reverseWords("  "));
        System.out.println(s.reverseWords("the sky is blue"));
        System.out.println(s.reverseWords("  hello world!  "));
        System.out.println(s.reverseWords("a good   example"));

    }
}

package LeetCode.字符串.最长公共前缀;


public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        char[] arr0 = strs[0].toCharArray();
        StringBuilder result = new StringBuilder();
        First:for (int i = 0; i < arr0.length; i++) {
            Second:for (int j = 1; j < strs.length; j++) {
                if(i >= strs[j].length() || strs[j].charAt(i) != arr0[i]){
                    break First;
                }
            }
            result.append(arr0[i]);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] strs = new String[]{"aa","a"};
        String result = s.longestCommonPrefix(strs);
        System.out.println(result);
    }
}

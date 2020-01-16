package LeetCode.字符串.实现strStr找到字符串出现的第一个位置;

public class Solution {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) return 0;
        char[] find_str = haystack.toCharArray();
        char first_char = needle.charAt(0);//记录开始的位置
        int target_len = needle.length();//记录目标字符串的长度
        if (target_len > haystack.length()) return -1;
        for (int i = 0; i < find_str.length - target_len + 1; i++) {
            //若然还是官方的API好用！！！
            if (find_str[i] == first_char && haystack.substring(i, i + target_len).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String s1 = "mississippi";
        String s2 = "issipi";
        int result = s.strStr(s1, s2);
        System.out.println(result);
    }
}

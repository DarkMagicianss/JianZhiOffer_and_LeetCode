package LeetCode.动态规划.最长回文子串;


public class Solution {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) return s;
        int max_len = 1;
        char[] arr = s.toCharArray();
        String result = s.substring(0, 1);
        for (int i = 0; i < s.length() - 1; i++) {
            //每一个节点都判断以该点(或以该点和后面一点)为中心展开
            int temp_len = Math.max(judge_huiwen(arr, i, i), judge_huiwen(arr, i, i + 1));
            if (temp_len > max_len) {
                max_len = temp_len;
                result = s.substring(i - (temp_len - 1) / 2, i + temp_len / 2 + 1);
                if (max_len == s.length()) return result;
            }
        }
        return result;
    }

    public int judge_huiwen(char[] arr, int start, int end) {
        while (start >= 0 && end <= arr.length - 1) {
            if (arr[start] != arr[end]) {
                return end - start + 1 - 2;//减去当前两个不相等的index
            } else {
                start--;
                end++;
            }
        }
        return end - start + 1 - 2;//减去边界的两个不相等的点
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "abcba";
        String result = s.longestPalindrome(str);
        System.out.println(result);
    }
}


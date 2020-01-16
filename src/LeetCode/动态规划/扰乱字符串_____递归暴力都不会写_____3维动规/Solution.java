package LeetCode.动态规划.扰乱字符串_____递归暴力都不会写_____3维动规;

public class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) return true;
        if(s1.length()!=s2.length())return false;
        int[] record = new int[26];
        for (int i = 0; i < s1.length(); i++) {//此处的s1和s2必定等长
            record[s1.charAt(i) - 'a']++;
            record[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (record[i] != 0)
                return false;
        }
        //1.递归判断
        if (s1.length() < 3 && s2.length() < 3) return true;
        for (int i = 1; i < s1.length(); i++) {
            //大佬只从题目原意出发 二叉树 只分为两个子问题 递归解决 太强了
            //将原字符串切一刀 变成左右两段 左1可能对应左2 左1也可能对应右2！！！
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i)) ||
                    isScramble(s1.substring(0, i), s2.substring(s2.length() - i)) && isScramble(s1.substring(i), s2.substring(0, s2.length() - i))) {
                return true;
            }
        }
        //2.3维动态规划
//        int length = s1.length();
//        boolean[][][] dp = new boolean[length + 1][length][length];
//        //遍历所有的字符串长度
//        for (int len = 1; len <= length; len++) {
//            //S1 开始的地方
//            for (int i = 0; i + len <= length; i++) {
//                //S2 开始的地方
//                for (int j = 0; j + len <= length; j++) {
//                    //长度是 1 无需切割
//                    if (len == 1) {
//                        dp[len][i][j] = s1.charAt(i) == s2.charAt(j);
//                    } else {
//                        //遍历切割后的左半部分长度
//                        for (int q = 1; q < len; q++) {
//                            dp[len][i][j] = dp[q][i][j] && dp[len - q][i + q][j + q]
//                                    || dp[q][i][j + len - q] && dp[len - q][i + q][j];
//                            //如果当前是 true 就 break，防止被覆盖为 false
//                            if (dp[len][i][j]) {
//                                break;
//                            }
//                        }
//                    }
//                }
//            }
//        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isScramble("great", "reatg"));
    }
}

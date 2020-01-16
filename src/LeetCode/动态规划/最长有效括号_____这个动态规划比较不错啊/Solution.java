package LeetCode.动态规划.最长有效括号_____这个动态规划比较不错啊;


public class Solution {
    public int longestValidParentheses(String s) {
        int len = s.length();
        if (len <= 1) return 0;
        int[] dp = new int[len];//记录已经完成的配对括号数目
        char[] arr = s.toCharArray();
        int max_len = 0;
        //dp思想很好呀
        //当i为'('时 dp[i]=0
        //当i为')'时
        //考虑1.i-1为'('时 dp[i] = dp[i - 2]+2;
        //考虑2.i-1为')' && i - dp[i - 1] - 1为'('时 dp[i] = dp[i-1]+2+dp[i-dp[i-1]-2];
        //设定dp[0]用于处理越界 因此dp[0]为0 从dp[1]开始计算
        for (int i = 1; i < len; i++) {
            if (arr[i] == ')') {
                if (arr[i - 1] == '(') {
                    dp[i] = i - 2 >= 0 ? dp[i - 2] + 2 : 2;
                } else if (i - dp[i - 1] - 1 >= 0 && arr[i - dp[i - 1] - 1] == '(') {
                    dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0);
                }
            }
            max_len = Math.max(max_len, dp[i]);
        }
        return max_len;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "((()))()()";
        System.out.println(s.longestValidParentheses(str));
    }
}


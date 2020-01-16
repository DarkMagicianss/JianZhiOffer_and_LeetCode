package LeetCode.动态规划.分割回文串2_____动态规划_对于dp_i前面的所有dp状态均已经为最优;


import java.util.Arrays;

public class Solution {
    //如果从分割字符串的角度考虑这个问题的话，对于一个区间内的字符串来说，每一个位置都将是可能的分割点，可以用暴力递归的方式找出答案，但是时间复杂度太高，加上预处理回文数组能勉强通过。
    //换个角度想想，当切割次数最少使得切割后的所有字符串都是回文时，也正是这些回文子串最长的时候，那么如果说能找到以每个字符为中心的最长回文串，实际上就已经找到了答案。
    //其实这个思路已经想到了 但是总觉得操作很麻烦 就没有继续
    public int minCut(String s) {
        if (s == null || s.length() <= 1)
            return 0;
        int len = s.length();
        int dp[] = new int[len];
        Arrays.fill(dp, len - 1);//全部填充为len-1
        for (int i = 0; i < len; i++) {
            // 注意偶数长度与奇数长度回文串的特点
            mincutHelper(s, i, i, dp);  // 奇数回文串以1个字符为中心
            mincutHelper(s, i, i + 1, dp); // 偶数回文串以2个字符为中心
        }
        return dp[len - 1];
    }

    private void mincutHelper(String s, int i, int j, int[] dp) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            //若i左边达到0 那么当前dp[j]应该为0 因为不需要切割
            dp[j] = Math.min(dp[j], i == 0 ? 0 : dp[i - 1] + 1);
            i--;
            j++;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minCut("aab"));
        System.out.println(s.minCut("ab"));
        System.out.println(s.minCut("aaa"));
        System.out.println(s.minCut("cdd"));
        System.out.println(s.minCut("cbbbcc"));
        System.out.println(s.minCut("aabaa"));
        System.out.println(s.minCut("ababa"));
        System.out.println(s.minCut("abbab"));
        System.out.println(s.minCut("abcccb"));
        System.out.println(s.minCut("cabababcbc"));
        System.out.println(s.minCut("ababababababababababababcbabababababababababababa"));
        System.out.println(s.minCut("fifgbeajcacehiicccfecbfhhgfiiecdcjjffbghdidbhbdbfbfjccgbbdcjheccfbhafehieabbdfeigbiaggchaeghaijfbjhi"));
    }
}


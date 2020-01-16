package LeetCode.动态规划.正则表达式匹配_____仔细思考呀;


public class Solution {
    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        dp[0][0] = true;//表示两个字符串都为""的时候匹配
        //当p为空时 一旦s不为空 全为默认false 完成第0列
        //匹配当s为空时的p是否匹配 完成第0行
        if (pLen >= 1) dp[0][1] = false;//当s为空 p为一个字符时 肯定匹配失败！！！
        for (int j = 2; j <= pLen; j++) {
            if (p.charAt(j - 1) == '*') {//字符串下标计算时要减一
                dp[0][j] = dp[0][j - 2] || dp[0][j - 1];//1.*==0 2.*==1 3.*==n(这里i为0不动 因此不考虑)
            }
            //默认为false
        }
        //完成剩余的行和列
        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                if (p.charAt(j - 1) == '*') {//字符串下标计算时要减一
                    dp[i][j] = dp[i][j - 2] || //第一种情况是'*'表示前一个字符为0个
                            ((s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') && (dp[i - 1][j] || dp[i][j - 1]));
                            //第二种情况是'*'表示前一个字符为1个或者多个 则当前i对应字符和'*'前一个字符必须匹配
                } else {
                    //i长的str和j长的pat是否匹配成功 在于1.当前两个字符是否匹配 2.之前的是否匹配
                    dp[i][j] = (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') && dp[i - 1][j - 1];
                }
            }
        }
        return dp[sLen][pLen];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isMatch("caz", "ca*z"));
    }
}

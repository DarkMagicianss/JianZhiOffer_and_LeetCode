package LeetCode.动态规划.不同的子序列_____思考动规一维不行试试二维;

public class Solution {
    public int numDistinct(String s, String t) {
        if (s.equals(t) || t.equals("")) return 1;
        if (s.equals("")) return 0;
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        //目标字符串一定均包含空字符串 第一行赋1
        for (int j = 0; j <= s.length(); j++) {
            dp[0][j] = 1;
        }
        //空字符串肯定不包含目标字符串 第一列赋0
        for (int i = 1; i <= t.length(); i++) {
            for (int j = 1; j <= s.length(); j++) {
                if (t.charAt(i - 1) == s.charAt(j - 1)) {
                    //当前两项已经匹配了：
                    //个数为：不包含当前目标字符的目标字符串和不包含当前匹配字符的匹配字符串的匹配个数 dp[i - 1][j - 1]
                    //另外，当前目标字符也可以不和当前匹配字符进行匹配 则
                    //个数为：包含当前目标字符的目标字符串和不包含当前匹配字符的匹配字符串的匹配个数dp[i][j - 1]
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                }else {
                    //个数为：包含当前目标字符的目标字符串和不包含当前匹配字符的匹配字符串的匹配个数dp[i][j - 1]
                    dp[i][j] = dp[i][j - 1];
                }
                //System.out.print(dp[i][j]+" ");
            }
            //System.out.println();
        }
        return dp[t.length()][s.length()];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numDistinct("aabb", "ab"));
    }
}

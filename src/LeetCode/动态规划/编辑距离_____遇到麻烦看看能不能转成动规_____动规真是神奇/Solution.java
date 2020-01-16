package LeetCode.动态规划.编辑距离_____遇到麻烦看看能不能转成动规_____动规真是神奇;

public class Solution {
    public int minDistance(String word1, String word2) {
        if (word1.equals(word2)) return 0;
        int row = word1.length();
        int col = word2.length();
        int[][] dp = new int[row + 1][col + 1];
        dp[0][0] = 0;
        if (row * col == 0)
            return row + col;
        for (int i = 1; i <= col; i++) {//填充第一行
            dp[0][i] = i;
        }
        for (int i = 1; i <= row; i++) {//填充第一列
            dp[i][0] = i;
        }
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                //依据当前字符是否和目标字符一致 一致则改变的次数就是i-1和j-1状态的次数
                //但是要和i和j-1 添加操作   以及i-1和j删除操作 的基础上加一进行比较 取最小的次数
                int temp_val = Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1);
                dp[i][j] = Math.min(temp_val, word1.charAt(i - 1) == word2.charAt(j - 1) ? dp[i - 1][j - 1] : dp[i - 1][j - 1] + 1);
            }
        }
        return dp[row][col];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minDistance("intention", "execution"));
    }
}

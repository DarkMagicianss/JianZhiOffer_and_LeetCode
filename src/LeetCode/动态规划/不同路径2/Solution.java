package LeetCode.动态规划.不同路径2;

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        if (n == 0) return 0;
        int m = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1) return 0;//起点就是障碍 返回0
        int[][] dp = new int[n][m];
        dp[0][0] = 1;
        for (int i = 1; i < m; i++) {//第一行遇到障碍 后面全部为0
            if (obstacleGrid[0][i] == 1) break;
            dp[0][i] = 1;
        }
        for (int i = 1; i < n; i++) {//第一列遇到障碍 后面全部为0
            if (obstacleGrid[i][0] == 1) break;
            dp[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[n - 1][m - 1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] arr = new int[][]{{0, 0, 0, 1}, {0, 1, 0, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        System.out.println(s.uniquePathsWithObstacles(arr));
    }
}


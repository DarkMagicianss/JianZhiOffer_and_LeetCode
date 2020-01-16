package LeetCode.动态规划.地下城游戏;


public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        //动规 从终点开始走到起点 dp代表到达这个点并能走到终点所需的最少血量
        //首先当前格子必须要满足血量不低于1 即-dungeon[i][j] + 1
        //其次就是满足这个基础上 接下来走下边还是走右边所需血量更少的问题
        //选择出两者的较小者 加上当前这个格子所需的血量
        int row = dungeon.length;
        int col = dungeon[0].length;
        int[][] dp = new int[row][col];
        dp[row - 1][col - 1] = -dungeon[row - 1][col - 1] + 1;//到达终点仍然需要至少有一滴血
        for (int i = row - 2; i >= 0; i--) {
            dp[i][col - 1] = Math.max(-dungeon[i][col - 1] + 1, dp[i + 1][col - 1] - dungeon[i][col - 1]);
            //System.out.print(dp[i][col - 1] + " ");
        }
        //System.out.println();
        for (int j = col - 2; j >= 0; j--) {
            dp[row - 1][j] = Math.max(-dungeon[row - 1][j] + 1, dp[row - 1][j + 1] - dungeon[row - 1][j]);
        }
        //System.out.println(Arrays.toString(dp[row - 1]));
        for (int i = row - 2; i >= 0; i--) {
            for (int j = col - 2; j >= 0; j--) {
                dp[i][j] = Math.max(-dungeon[i][j] + 1, Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j]);
            }
            //System.out.println(Arrays.toString(dp[i]));
        }
        if (dp[0][0] <= 0) return 1;//若出现状态所需血量为负数 则至少一滴血
        else return dp[0][0];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.calculateMinimumHP(new int[][]{{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}}));
        System.out.println(s.calculateMinimumHP(new int[][]{{5, -3, 3}, {-5, -7, 1}, {10, -15, -5}, {10, -5, 0}}));
        System.out.println(s.calculateMinimumHP(new int[][]{{-5, -3, 3}}));
    }
}

package LeetCode.动态规划.最小路径和;

public class Solution {
    public int minPathSum(int[][] grid) {
        //也是一个二维dp的思路
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 1; i < col; i++) {//处理第一行
            grid[0][i] = grid[0][i - 1] + grid[0][i];
        }
        for (int j = 1; j < row; j++) {//处理第一列
            grid[j][0] = grid[j - 1][0] + grid[j][0];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                grid[i][j] = Math.min(grid[i - 1][j],grid[i][j - 1]) + grid[i][j];
            }
        }
        return grid[row - 1][col - 1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] arr = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(s.minPathSum(arr));
    }
}

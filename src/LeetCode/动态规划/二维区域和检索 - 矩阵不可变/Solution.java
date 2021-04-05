
/**
 * @author LinHu
 * @version 2021/4/3
 */
public class Solution {
    private int[][] matrix;
    private int[][] dp;
    private int row;
    private int col;
    public Solution(int[][] matrix) {
        if (matrix == null || matrix.length == 0 | matrix[0].length == 0){
            return;
        }
        this.matrix = matrix;
        this.row = matrix.length;
        this.col = matrix[0].length;
        this.dp = new int[row + 1][col + 1];
        dp[1][1] = matrix[0][0];
        for (int i = 1; i < col; i++) {
            dp[1][i + 1] = dp[1][i] + matrix[0][i];
        }
        for (int i = 1; i < row; i++) {
            dp[i + 1][1] = dp[i][1] + matrix[i][0];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i + 1][j + 1] = matrix[i][j] + dp[i + 1][j] + dp[i][j + 1] - dp[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (matrix == null) return 0;
        int leftDownX = row2;
        int leftDownY = col1 - 1;
        int rightUpX = row1 - 1;
        int rightUpY = col2;
        return dp[row2 + 1][col2 + 1]
                - dp[leftDownX + 1][leftDownY + 1]
                - dp[rightUpX + 1][rightUpY + 1]
                + dp[row1][col1];
    }

    public static void main(String[] args) {
        Solution s = new Solution(new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        });
        System.out.println(s.sumRegion(2, 1, 4, 3));
        System.out.println(s.sumRegion(1, 1, 2, 2));
        System.out.println(s.sumRegion(1, 2, 2, 4));

    }
}

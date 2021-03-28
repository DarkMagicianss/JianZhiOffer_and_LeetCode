/**
 * @author LinHu
 * @version 2021/3/27
 */
public class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)return 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        int max_value = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0 || j == 0) dp[i][j] = matrix[i][j] - '0';
                else {
                    if(matrix[i][j] == '1') {
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    }
                }
                max_value = Math.max(dp[i][j], max_value);
            }
        }
        return max_value * max_value;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        String str1 = "leetcode";
        String str2 = "applepenapple";
        String str3 = "catsandog";

        System.out.println(s.maximalSquare(new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}}));
        System.out.println(s.maximalSquare(new char[][]{{'0','1'},{'1','0'}}));
        System.out.println(s.maximalSquare(new char[][]{{'0'}}));
    }
}

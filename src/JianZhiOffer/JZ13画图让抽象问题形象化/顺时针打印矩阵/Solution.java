package JianZhiOffer.JZ13画图让抽象问题形象化.顺时针打印矩阵;


import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        if (matrix == null) return null;
        ArrayList<Integer> result = new ArrayList<>();
        int index_x_max = matrix.length;
        int index_y_max = matrix[0].length;
        int[][] dp = new int[index_x_max + 2][index_y_max + 2];
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        dp[1][index_y_max + 2 - 1] = 1;
        dp[index_x_max + 2 - 1][index_y_max + 2 - 2] = 1;
        dp[index_x_max + 2 - 2][0] = 1;
        for (int i = 1, j = 1, k = 0; ; i += dx[k], j += dy[k]) {
            result.add(matrix[i - 1][j - 1]);
            dp[i][j] = 1;
            if (dp[i + dx[k]][j + dy[k]] == 1) {
                k = (k + 1) % 4;
                //出现两个方向都阻塞 则结束
                if (dp[i + dx[k]][j + dy[k]] == 1) break;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[][] matrix = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matrix[i][j] = i * 4 + j;
            }
        }
        Solution s = new Solution();
        ArrayList list = s.printMatrix(matrix);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}

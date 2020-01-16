package LeetCode.数组.旋转图像;

public class Solution {
    public void rotate(int[][] matrix) {
        int bian = matrix.length;
        for (int i = 0; i < bian / 2; i++) {
            int small_bian = bian - 2 * i;
            if (small_bian == 1) continue;
            int[] temp = new int[small_bian];//里面的小正方型的边长
            //将上边长的数值先进行存储
            for (int j = 0; j < small_bian; j++) {
                temp[j] = matrix[i][i + j];
            }
            //将左边赋值给上边（全部）
            for (int j = 0; j < small_bian; j++) {
                matrix[i][i + small_bian - 1 - j] = matrix[i + j][i];
            }
            //将下边赋值给左边（少一个 左上角那个）
            for (int j = 1; j < small_bian; j++) {
                matrix[i + j][i] = matrix[i + small_bian - 1][i + j];
            }
            //将右边赋值给下边
            for (int j = 1; j < small_bian; j++) {
                matrix[i + small_bian - 1][i + j] = matrix[i + small_bian - 1 - j][i + small_bian - 1];
            }
            //将原来的上边赋值给右边
            for (int j = 1; j < small_bian; j++) {
                matrix[i + j][i + small_bian - 1] = temp[j];
            }
        }
        return;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] matrix = new int[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        s.rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

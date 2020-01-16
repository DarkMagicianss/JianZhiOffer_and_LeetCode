package LeetCode.数组.矩阵置零_____利用原数组的第一行和第一列;



public class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;
        int row = matrix.length;
        int col = matrix[0].length;
        boolean isCol = false;
        //由于matrix[0][0]标记的重复 因此需要一个变量来区别
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) isCol = true;
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        //对行列进行标零
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if(matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (matrix[0][0] == 0){
            for (int i = 0; i < col; i++) {
                matrix[0][i] = 0;
            }
        }
        if (isCol) {
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }
        return;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] arr = new int[][]{{0, 1, 0, 7}, {3, 4, 3, 2}, {1, 3, 1, 5}, {3, 4, 0, 2}};
        s.setZeroes(arr);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}

package LeetCode.数组.螺旋矩阵;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if(matrix == null || matrix.length == 0)return result;
        int row = matrix.length;
        int col = matrix[0].length;
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        int[][] flag = new int[row + 1][col + 2];//多增加了左右两边 以及下边
        //用于设置三个拦截点 使得打印旋转
        flag[0][col + 1] = 1;
        flag[row][col] = 1;
        flag[row - 1][0] = 1;
        int x = 0;
        int y = 0;
        int direct = 0;
        int count = 0;
        while (count < row * col) {
            result.add(matrix[x][y]);
            flag[x][y + 1] = 1;
            count++;
            if (flag[x + dx[direct]][y + dy[direct] + 1] == 1) {
                direct = (direct + 1) % 4;
            }
            x = x + dx[direct];
            y = y + dy[direct];
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] arr = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(s.spiralOrder(arr));
    }
}

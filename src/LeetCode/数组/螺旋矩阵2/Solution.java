package LeetCode.数组.螺旋矩阵2;


public class Solution {
    public int[][] generateMatrix(int n) {
        if (n <= 1) return new int[][]{{1}};
        int[][] arr = new int[n][n];
        int turn_count = n - 1;
        int turn_temp = 0;
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        int step = 1;
        for (int i = 0; i < n; i++) {//第一行赋值
            arr[0][i] = step;
            step++;
        }
        int direct = 1;
        int row = 1;
        int col = n - 1;
        while (step <= n * n) {
            //System.out.println(row + "   " + col);
            arr[row][col] = step;
            turn_temp++;
            if (turn_temp == 2 * turn_count) {
                //若上一次螺旋已经达到n-1次 则减少总螺旋次数
                turn_count--;
                turn_temp = 0;
                direct = (direct + 1) % 4;
                //System.out.println("大转" + row + "   " + col);
            } else if (turn_temp == turn_count) {
                direct = (direct + 1) % 4;
                //System.out.println("小弯" + row + "   " + col);
            }
            row += dx[direct];
            col += dy[direct];
            step++;
        }
        return arr;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] result = s.generateMatrix(7);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
    }
}

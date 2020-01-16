package JianZhiOffer.JZDiff.机器人的运动范围;

public class Solution {
    public int movingCount(int threshold, int rows, int cols) {
        if (threshold == 0) return 0;
        boolean[][] flag = new boolean[rows][cols];
        return sub_movingCount(threshold, rows, cols, 0, 0, flag);
    }

    public int sub_movingCount(int threshold, int rows, int cols, int x, int y, boolean[][] flag) {
        if (x < 0 || x >= rows || y < 0 || y >= cols || flag[x][y] == true || compute_sum(x, y) > threshold)
            return 0;
        flag[x][y] = true;//当前该点为合法的可到达的位置
        return (sub_movingCount(threshold, rows, cols, x - 1, y, flag) +
                sub_movingCount(threshold, rows, cols, x + 1, y, flag) +
                sub_movingCount(threshold, rows, cols, x, y - 1, flag) +
                sub_movingCount(threshold, rows, cols, x, y + 1, flag) + 1);
    }

    public int compute_sum(int x, int y) {
        int temp = 0;
        while (x != 0) {
            temp += x % 10;
            x = x / 10;
        }
        while (y != 0) {
            temp += y % 10;
            y = y / 10;
        }
        return temp;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.movingCount(3, 9, 9));
    }
}

package LeetCode.数字.直线上最多的点数_____优化是个好办法;

public class Solution {
    public int maxPoints(int[][] points) {
        if (points.length <= 2) return points.length;
        int max_count = 2;
        for (int i = 0; i < points.length; i++) {
            int same_num = 1;
            for (int j = i + 1; j < points.length; j++) {
                int count = 0;
                if (points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
                    //相同点
                    same_num++;
                } else {
                    count += 1;
                    long dx = (long) (points[i][0] - points[j][0]);
                    long dy = (long) (points[i][1] - points[j][1]);
                    //这里这个j+1表示当前这条线不统计之前的点 因为就算之前存在同一条线 但是已经统计过当前两点了
                    for (int k = j + 1; k < points.length; k++) {
                        count += (dx * (points[i][1] - points[k][1]) == dy * (points[i][0] - points[k][0])) ? 1 : 0;
                    }
                }
                max_count = Math.max(count + same_num, max_count);
            }
            //若某次最大个数超过所有点的一半 则不可能存在其他直线通过更多的点
            if (max_count > points.length / 2) return max_count;
        }
        return max_count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] points = new int[][]{{0, 0}, {94911151, 94911150}, {94911152, 94911151}};
        System.out.println(s.maxPoints(points));
    }
}

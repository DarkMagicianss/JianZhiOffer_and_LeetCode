package LeetCode.数组.插入区间;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    class Point{
        int l;
        int r;
        Point(int l,int r){
            this.l = l;
            this.r = r;
        }
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals == null || intervals.length == 0){
            int[][] result = new int[1][2];
            result[0] = newInterval;
            return result;
        }
        int t_left = newInterval[0];
        int t_right = newInterval[1];
        ArrayList<Point> list = new ArrayList<>();
        int insert_flag = 0;
        for (int i = 0; i < intervals.length; i++) {
            int temp_left = intervals[i][0];
            int temp_right = intervals[i][1];
            if(t_left > temp_right || insert_flag == 2) {
                list.add(new Point(temp_left, temp_right));
                continue;
            }
            if(t_right < temp_left){
                list.add(new Point(t_left, t_right));
                list.add(new Point(temp_left, temp_right));
                insert_flag = 2;
                continue;
            }
            t_left = Math.min(temp_left,t_left);
            t_right = Math.max(temp_right,t_right);
            insert_flag = 1;
        }
        if(insert_flag <= 1)list.add(new Point(t_left, t_right));
        int[][] result = new int[list.size()][2];
        for (int i = 0; i < result.length; i++) {
            result[i][0] = list.get(i).l;
            result[i][1] = list.get(i).r;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] arr = new int[][]{{1,5}};
        int[] new_arr = new int[]{6,8};
        int[][] result = s.insert(arr,new_arr);
        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
    }
}

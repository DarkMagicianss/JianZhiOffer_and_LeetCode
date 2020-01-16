package LeetCode.数组.合并区间_____原先的思路太垃圾n2;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    class Point{
        int l;
        int r;
        Point(int l,int r){
            this.l = l;
            this.r = r;
        }
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        ArrayList<Point> list = new ArrayList<>();
        Point base = new Point(intervals[0][0],intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            if(left > base.r){
                list.add(new Point(base.l,base.r));
                base.l = left;
                base.r = right;
                continue;
            }
            base.l = Math.min(base.l,left);
            base.r = Math.max(base.r,right);
        }
        list.add(new Point(base.l,base.r));
        int[][] result = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            result[i][0] = list.get(i).l;
            result[i][1] = list.get(i).r;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] arr = new int[][]{{2,3},{4,6},{5,7},{3,4}};
        int[][] result = s.merge(arr);
        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
    }
}


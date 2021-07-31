package solution;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 测试.
 *
 * @author LinHu
 * @version 2021-07-31 11:18
 */
public class Solution {
//    //有依据二维数组的左侧进行排序的思路 然后一个个操作，终究觉得麻烦放弃，哭死。n2会超时，因此放弃
//    public int eraseOverlapIntervals(int[][] intervals) {
//        if (intervals.length == 0) return 0;
//        Arrays.sort(intervals, Comparator.comparingInt((int[] i) -> i[0]));
//        int n = intervals.length;
//        int[] dp = new int[n];
//        //每个区间单独方的话，可以最大放一个
//        Arrays.fill(dp, 1);
//        //每来一个区间，只有两种可能，取或者弃
//        for (int i = 1; i < n; i++) {
//            //1.放弃的话,就是之前的dp[]中最大的一个作为当前
//            // 但是放弃的话，前面的最大一个肯定和当前有交集(不然无需放弃),这样取再前一个加1(即第二种情况)和取最大一个是一样的
//            //2.取的话，就是所有right比当前的left要小的dp[]目标，再+1
//            // 2的计算包含了1
//            for (int j = 0; j < i; j++) {
//                if(intervals[j][1] <= intervals[i][0]) {
//                    dp[i] = Math.max(dp[i], dp[j] + 1);
//                }
//            }
//        }
//        return n - Arrays.stream(dp).max().getAsInt();
//    }
    // 贪心
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[1] - interval2[1];
            }
        });

        int n = intervals.length;
        int right = intervals[0][1];
        int ans = 1;
        for (int i = 1; i < n; ++i) {
            if (intervals[i][0] >= right) {
                ++ans;
                right = intervals[i][1];
            }
        }
        return n - ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.eraseOverlapIntervals(new int[][]{{1,2}, {2,3}, {3,4}, {1,3}}));
    }
}

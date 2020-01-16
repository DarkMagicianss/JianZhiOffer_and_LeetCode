package LeetCode.动态规划.三角形最小路径和_____逆向思维很好很方便;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int level = triangle.size();
        if (level == 0) return 0;
        int[] dp = new int[level + 1];
        for (int i = level - 1; i >= 0; i--) {
            List<Integer> temp = triangle.get(i);
            for (int j = 0; j < temp.size(); j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + temp.get(j);
            }
            //System.out.println(Arrays.toString(dp));
        }
        return dp[0];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> arr = new ArrayList<>();
//        arr.add(Arrays.asList(2));
//        arr.add(Arrays.asList(3, 4));
//        arr.add(Arrays.asList(6, 5, 7));
//        arr.add(Arrays.asList(4, 1, 8, 3));

        arr.add(Arrays.asList(-7));
        arr.add(Arrays.asList(-2, 1));
        arr.add(Arrays.asList(-5, -5, 9));
        arr.add(Arrays.asList(-4, -5, 4, 4));
        arr.add(Arrays.asList(-6, -6, 2, -1, -5));
        arr.add(Arrays.asList(3, 7, 8, -3, 7, -9));
        arr.add(Arrays.asList(-9, -1, -9, 6, 9, 0, 7));
        arr.add(Arrays.asList(-7, 0, -6, -8, 7, 1, -4, 9));
        arr.add(Arrays.asList(-3, 2, -6, -9, -7, -6, -9, 4, 0));
        arr.add(Arrays.asList(-8, -6, -3, -9, -2, -6, 7, -5, 0, 7));
        arr.add(Arrays.asList(-9, -1, -2, 4, -2, 4, 4, -1, 2, -5, 5));
        arr.add(Arrays.asList(1, 1, -6, 1, -2, -4, 4, -2, 6, -6, 0, 6));
        arr.add(Arrays.asList(-3, -3, -6, -2, -6, -2, 7, -9, -5, -7, -5, 5, 1));
        System.out.println(s.minimumTotal(arr));
    }
}

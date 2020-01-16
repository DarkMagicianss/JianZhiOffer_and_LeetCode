package JianZhiOffer.JZDiff.滑动窗口的最大值;

import java.util.ArrayList;

public class Solution {
    //个人认为使用dp的方式更好
    //通过记录两个相邻数的最大值 记录三个相邻数的最大值 来渐渐完成size个相邻数的最大值
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> result = new ArrayList<>();
        if (num == null || num.length == 0 || size == 0) return result;
        int[][] dp = new int[size][num.length];
        dp[0] = num;//0代表1阶 1代表2阶
        for (int i = 1; i < size; i++) {
            for (int j = 0; j < num.length - i; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[0][j + i]);
            }
        }
        for (int i = 0; i < num.length - (size - 1); i++) {
            result.add(dp[size - 1][i]);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = new int[]{2, 3, 4, 2, 6, 2, 5, 1};
        System.out.println(s.maxInWindows(arr, 3));
    }
}

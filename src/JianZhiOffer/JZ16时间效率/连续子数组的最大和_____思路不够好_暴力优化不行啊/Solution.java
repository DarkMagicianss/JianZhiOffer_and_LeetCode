package JianZhiOffer.JZ16时间效率.连续子数组的最大和_____思路不够好_暴力优化不行啊;


public class Solution {
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null) return 0;
        if (array.length == 1) return array[0];
        int[] dp = new int[array.length];
        dp[0] = array[0];
        int max = dp[0];
        for (int i = 1; i < array.length; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + array[i];
            } else {
                dp[i] = array[i];
            }
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        JianZhiOffer.JZ16时间效率.整数中1出现的次数_从1到n整数中1出现的次数_.Solution s = new JianZhiOffer.JZ16时间效率.整数中1出现的次数_从1到n整数中1出现的次数_.Solution();

    }
}

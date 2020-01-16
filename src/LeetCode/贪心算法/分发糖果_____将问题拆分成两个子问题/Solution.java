package LeetCode.贪心算法.分发糖果_____将问题拆分成两个子问题;

import java.util.Arrays;

public class Solution {
    public int candy(int[] ratings) {
        //像这种满足两边需求的可以从左到右满足一遍 再从右到左满足一遍
        if (ratings.length == 1) return 1;
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i - 1] < ratings[i]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        //System.out.println(Arrays.toString(candies));
        int sum = candies[ratings.length - 1];
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
            sum += candies[i];
        }
        //System.out.println(Arrays.toString(candies));
        return sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.candy(new int[]{1, 3, 2, 2, 1}));
        System.out.println(s.candy(new int[]{2, 1, 0, 2}));
        System.out.println(s.candy(new int[]{1, 2, 2}));
        System.out.println(s.candy(new int[]{1, 0, 2}));
        System.out.println(s.candy(new int[]{1, 3, 3, 2, 3, 1}));
        System.out.println(s.candy(new int[]{1, 2, 3, 1, 0}));
    }
}

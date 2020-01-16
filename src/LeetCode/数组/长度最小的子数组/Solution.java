package LeetCode.数组.长度最小的子数组;

public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length <= 0) return 0;
        int min = nums.length + 1;
        int left = 0;
        int right = 0;
        int temp_result = 0;
        while (right < nums.length) {
            temp_result += nums[right];
            while (temp_result >= s) {
                min = Math.min(min, right - left + 1);
                temp_result -= nums[left];
                left++;
            }
            right++;
        }
        return min == nums.length + 1 ? 0 : min;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }
}


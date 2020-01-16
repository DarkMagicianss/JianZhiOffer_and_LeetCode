package LeetCode.数组.四数之和_____优化不出来了;

import java.util.*;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 4) return result;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3 && 4 * nums[i] <= target; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length - 2 && 3 * nums[j] <= (target - nums[i]); j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        result.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[left], nums[right])));
                    }
                    if (sum >= target) {
                        while (left < right && nums[right - 1] == nums[right]) right--;
                        right--;
                    }
                    if (sum <= target) {
                        while (left < right && nums[left + 1] == nums[left]) left++;
                        left++;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{-1, 0, -5, -2, -2, -4, 0, 1, -2};
        List<List<Integer>> result = s.fourSum(nums, -9);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}

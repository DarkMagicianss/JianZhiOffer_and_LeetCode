package LeetCode.数组.最接近的三数之和;

import java.util.*;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) return 0;
        Arrays.sort(nums);//先进行排序
        int closest = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;//去重优化1
            //进行双指针查找
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(sum - target) < Math.abs(closest - target)) closest = sum;
                if (sum > target) {
                    while (left < right && nums[right - 1] == nums[right]) right--;//去重优化2
                    right--;
                } else if (sum < target) {
                    while (left < right && nums[left + 1] == nums[left]) left++;//去重优化2
                    left++;
                } else {
                    return target;
                }
            }
        }
        return closest;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{1, 1, 1, 0};
        int result = s.threeSumClosest(nums, 100);
        System.out.println(result);
    }
}

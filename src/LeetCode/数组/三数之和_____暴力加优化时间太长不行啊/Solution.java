package LeetCode.数组.三数之和_____暴力加优化时间太长不行啊;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 3) return result;
        Arrays.sort(nums);//先排序
        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {//当前值一旦比0大 就不用再找了
            if (i > 0 && nums[i] == nums[i - 1]) continue;//去重优化1
            //使用双指针进行查找 还是要考虑如何移动双指针！！！
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left + 1] == nums[left]) left++;//去重优化2
                    while (left < right && nums[right - 1] == nums[right]) right--;//去重优化2
                    left++;
                    right--;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = s.threeSum(nums);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}

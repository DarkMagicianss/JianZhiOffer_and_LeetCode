package LeetCode.数组.两数之和;

import java.util.HashMap;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] results = new int[]{-1, -1};
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])){
                int index = map.get(target - nums[i]);
                if(i == index) continue;
                results[0] = i;
                results[1] = index;
                return results;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{2,7,11,15};
        int[] result = s.twoSum(nums, 9);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}

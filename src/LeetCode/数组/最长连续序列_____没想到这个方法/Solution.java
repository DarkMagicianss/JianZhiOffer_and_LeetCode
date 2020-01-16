package LeetCode.数组.最长连续序列_____没想到这个方法;


import java.util.HashMap;

public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int max_len = 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                //每个map记录的是当前点所在的连续序列的长度 中间的点已存在map不关心 只关心边界点的长度
                int left = map.getOrDefault((nums[i] - 1), 0);
                int right = map.getOrDefault((nums[i] + 1), 0);
                int temp_len = left + right + 1;
                max_len = Math.max(temp_len, max_len);
                map.put(nums[i], temp_len);
                //更新边界点的长度
                map.put(nums[i] - left, temp_len);
                map.put(nums[i] + right, temp_len);
            }
        }
        return max_len;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = new int[]{100, 4, 200, 1, 3, 2};
        System.out.println(s.longestConsecutive(arr));
    }
}


package LeetCode.位运算.只出现一次的数字;


public class Solution {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.singleNumber(new int[]{2,2,1}));
        System.out.println(s.singleNumber(new int[]{4,1,2,1,2}));
    }
}

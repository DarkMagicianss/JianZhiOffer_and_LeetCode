package LeetCode.动态规划.最大子序和_____动态规划一阶降成零阶;

public class Solution {
    public int maxSubArray(int[] nums) {
        //假设sum<=0，那么后面的子序列肯定不包含目前的子序列，所以令sum = num；
        //如果sum > 0对于后面的子序列是有好处的。res = Math.max(res, sum)保证可以找到最大的子序和。
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int sum = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (sum > 0) {
                sum = sum + nums[i];
            } else {
                sum = nums[i];
            }
            //System.out.println(sum);
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(s.maxSubArray(arr));
    }
}


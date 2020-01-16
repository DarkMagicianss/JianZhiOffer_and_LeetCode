package LeetCode.二分查找.搜索插入位置;

public class Solution {
    public int searchInsert(int[] nums, int target) {
        int right, left, mid;
        left = 0;
        right = nums.length - 1;
        mid = (left + right) >> 1;
        while (left <= right) {
            if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                return mid;
            }
            mid = (right + left) >> 1;
        }
        return left;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{1, 3, 5, 6};
        int result = s.searchInsert(nums, 0);
        System.out.println(result);
    }
}


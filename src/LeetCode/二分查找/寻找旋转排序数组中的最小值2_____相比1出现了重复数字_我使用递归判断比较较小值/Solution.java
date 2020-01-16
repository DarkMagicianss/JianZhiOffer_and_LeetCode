package LeetCode.二分查找.寻找旋转排序数组中的最小值2_____相比1出现了重复数字_我使用递归判断比较较小值;

public class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) return nums[0];
        return sub_findMin(nums, 0, nums.length - 1);
    }

    public int sub_findMin(int[] nums, int start, int end) {
        if(start < 0 || start > nums.length || end < 0 || end > nums.length)return Integer.MAX_VALUE;
        int left = start;
        int right = end;
        if (nums[left] < nums[right]) return nums[left];
        int mid = 0;
        while (left < right) {
            mid = (left + right) >> 1;
            if (nums[mid] == nums[start] && nums[mid] == nums[end]) {
                return Math.min(sub_findMin(nums, start, mid - 1), sub_findMin(nums, mid + 1, end));
            }
            if (nums[mid] >= nums[start]) {
                left = mid + 1;
            } else if (nums[mid] <= nums[end]) {
                if (mid > 0 && nums[mid - 1] > nums[mid]) return nums[mid];
                right = mid - 1;
            } else {
                return -1;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findMin(new int[]{1, 3, 5}));
        System.out.println(s.findMin(new int[]{2, 2, 2, 0, 1}));
        System.out.println(s.findMin(new int[]{1, 2, 3, 3, 3, 3, 1}));
        System.out.println(s.findMin(new int[]{3, 3, 2, 3, 3, 3, 3}));
    }
}


package LeetCode.二分查找.寻找旋转排序数组中的最小值;

public class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) return nums[0];
        int left = 0;
        int right = nums.length - 1;
        if (nums[left] < nums[right]) return nums[left];
        int mid = 0;
        while (left < right) {
            mid = (left + right) >> 1;
            if (nums[mid] >= nums[0]) {
                left = mid + 1;
            } else if (nums[mid] <= nums[nums.length - 1]) {
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
        System.out.println(s.findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        System.out.println(s.findMin(new int[]{1, 0, 0, 0, 0, 0}));
        System.out.println(s.findMin(new int[]{3, 4, 5, 1, 2}));
        System.out.println(s.findMin(new int[]{10, 14, 17, 1, 4, 7, 9}));
        System.out.println(s.findMin(new int[]{10, 14, 17, 19, 4, 7, 9}));
        System.out.println(s.findMin(new int[]{10, 14, -1, 1, 4, 7, 9}));
        System.out.println(s.findMin(new int[]{0}));
        System.out.println(s.findMin(new int[]{1, 0, 0}));
        System.out.println(s.findMin(new int[]{0, 0}));
        System.out.println(s.findMin(new int[]{0, 1, -1}));
        System.out.println(s.findMin(new int[]{0, 1}));
    }
}


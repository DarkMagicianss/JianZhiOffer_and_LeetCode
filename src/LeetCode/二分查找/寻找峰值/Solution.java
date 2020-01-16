package LeetCode.二分查找.寻找峰值;

public class Solution {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) return 0;
        if (nums.length == 2) return nums[0] > nums[1] ? 0 : 1;
        int left = 0;
        int right = nums.length - 1;
        int mid = -1;
        while (left < right) {
            mid = (left + right) >> 1;
            if (mid > 0 && mid < nums.length - 1) {
                if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) {
                    break;
                } else if (nums[mid - 1] < nums[mid] && nums[mid] < nums[mid + 1]) {
                    left = mid + 1;
                } else if (nums[mid - 1] > nums[mid] && nums[mid] > nums[mid + 1]) {
                    right = mid - 1;
                } else {
                    left++;
                }
            } else if (mid == 0) {//边界上面的比较
                if (nums[0] < nums[1]) left++;
                break;
            } else if (mid == nums.length - 1) {//边界上面的比较
                if(nums[mid] < nums[nums.length - 2])left--;
                break;
            }
        }
        return (left + right) >> 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4}));
        System.out.println(s.findPeakElement(new int[]{1, 2, 3, 1}));
        System.out.println(s.findPeakElement(new int[]{1, 2}));
        System.out.println(s.findPeakElement(new int[]{1, 2, 1}));
        System.out.println(s.findPeakElement(new int[]{2, 1, 2}));
        System.out.println(s.findPeakElement(new int[]{0, 1, 2}));
        System.out.println();
        System.out.println(s.findPeakElement(new int[]{1, 2, 3, 2, 1}));
        System.out.println(s.findPeakElement(new int[]{1, 2, 1, 2, 1}));
        System.out.println(s.findPeakElement(new int[]{2, 1, 0}));
        System.out.println(s.findPeakElement(new int[]{3, 4, 3, 2, 1}));
    }
}

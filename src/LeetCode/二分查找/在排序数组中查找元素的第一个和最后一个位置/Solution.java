package LeetCode.二分查找.在排序数组中查找元素的第一个和最后一个位置;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};
        int left = sub_searchRange(nums,target,0);
        if (left == -1 || nums[left] != target) return new int[]{-1, -1};
        int right = sub_searchRange(nums,target,1);
        return new int[]{left, right};
    }

    public int sub_searchRange(int[] nums, int target, int flag) {
        int start = 0;
        int end = nums.length - 1;
        int mid = (start + end) >> 1;
        while (start <= end) {
            if (flag == 0 && (mid == 0 || nums[mid - 1] != target) && nums[mid] == target) {
                break;//寻找左边界
            } else if (flag == 1 && (mid + 1 == nums.length || nums[mid + 1] != target) && nums[mid] == target) {
                break;//寻找右边界
            } else if (nums[mid] < target || (nums[mid] == target && flag == 1)) {//相等时且当寻找右节点时
                start = mid + 1;
            } else{
                end = mid - 1;
            }
            mid = (start + end) >> 1;
        }
        return mid;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{1};
        int[] result = s.searchRange(nums, 0);
        System.out.println(result[0] + "," + result[1]);
    }
}


package LeetCode.二分查找.搜索旋转排序数组_____二分的扩展;

public class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;
        if(len == 0)return -1;
        int start = 0;
        int end = nums.length - 1;
        int mid = (start + end) >> 1;
        while (start <= end) {
            //和二分法不同的是 需要判断mid数值
            //是否>=左端点(即是否在左支臂上)
            //是否<=右端点(即是否在右支臂上)
            if (target == nums[mid]) return mid;
            else if (nums[mid] >= nums[start]) {
                if (target >= nums[start] && target <= nums[mid]) end = mid - 1;
                else start = mid + 1;
            } else if (nums[mid] <= nums[end]) {
                if (target >= nums[mid] && target <= nums[end]) start = mid + 1;
                else end = mid - 1;
            }
            mid = (start + end) >> 1;
        }
        return nums[mid] == target ? mid : -1;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{4,5,6,7,0,1,2};
        System.out.println(s.search(nums, 1));
    }
}


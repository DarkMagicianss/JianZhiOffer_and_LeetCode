package LeetCode.二分查找.搜索旋转排序数组2_____先判断mid在左还在右;

public class Solution {
    public boolean search(int[] nums, int target) {
        if (nums.length == 0) return false;
        if (nums.length == 1) return nums[0] == target;
        return sub_search(nums,target,0,nums.length - 1);
    }
    public boolean sub_search(int[] nums, int target,int left,int right) {
        while (left <= right) {
            int mid = (left + right) >> 1;
            //System.out.println(left+"   "+right+"   "+mid);
            if(nums[mid] == target)return true;
            if(nums[mid] == nums[left] && nums[mid] == nums[right]){
                return sub_search(nums,target,left,mid - 1) || sub_search(nums,target,mid + 1,right);
            } else if(nums[mid] < nums[right] || nums[mid] == nums[right]){//mid在右边
                if(target <= nums[right] && target >= nums[mid]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            } else if(nums[mid] > nums[left] || nums[mid] == nums[left]){
                if(target >= nums[left] && target <= nums[mid]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{1,3,1,1,1,1,1};
        System.out.println(s.search(nums, 0));
        System.out.println(s.search(nums, 3));
    }
}

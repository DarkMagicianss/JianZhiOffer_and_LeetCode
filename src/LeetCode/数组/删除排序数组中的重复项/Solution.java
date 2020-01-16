package LeetCode.数组.删除排序数组中的重复项;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len <= 1) return len;
        int index = 0;
        for (int i = 1; i < len; i++) {//从第二个元素开始进行判断
            if (nums[i] != nums[index]) {
                index++;//index加加
                nums[index] = nums[i];
            }
        }
        //返回index的个数加1
        return (index + 1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{0,0,1,1,1,1,1,1,2,3,4,4,4,5,5,5,6,6,6,6,6};
        int length = s.removeDuplicates(nums);
        for (int i = 0; i < length; i++) {
            System.out.println(nums[i]);
        }
    }
}

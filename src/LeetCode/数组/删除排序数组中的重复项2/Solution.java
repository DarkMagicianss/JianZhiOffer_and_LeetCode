package LeetCode.数组.删除排序数组中的重复项2;

import java.util.Arrays;

public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;
        int index = 2;
        int count_num = 1;
        if (nums[0] == nums[1]) {
            count_num = 2;
        }
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {//两者不相等
                nums[index] = nums[i];
                index++;
                count_num = 1;
                continue;
            }
            if (count_num < 2) {
                nums[index] = nums[i];
                index++;
            }
            count_num++;
        }
        return index;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = new int[]{1,1,2,2,3,3,6,7,8};
        System.out.println(s.removeDuplicates(arr));
        System.out.println(Arrays.toString(arr));
    }
}

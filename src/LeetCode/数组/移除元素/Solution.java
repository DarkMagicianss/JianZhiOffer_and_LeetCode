package LeetCode.数组.移除元素;

public class Solution {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        if (len == 0) return len;
        int index = 1;
        if(nums[0] == val)index = 0;
        for (int i = 1; i < len; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{3, 2, 2, 3};
        int length = s.removeElement(nums, 3);
        for (int i = 0; i < length; i++) {
            System.out.println(nums[i]);
        }
    }
}

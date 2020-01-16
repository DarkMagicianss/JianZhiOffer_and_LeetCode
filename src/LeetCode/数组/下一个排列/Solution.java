package LeetCode.数组.下一个排列;

import java.util.Arrays;

public class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        if (nums == null || len <= 1) return;
        //从后往前遍历数字
        for (int i = len - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {//当后一个数比前一个数大时
                for (int j = len - 1; j >= i; j--) {
                    if (nums[j] > nums[i - 1]) {
                        int temp = nums[i - 1];
                        nums[i - 1] = nums[j];
                        nums[j] = temp;
                        //需要将后续的数字转换成最小
                        reverse_arr(nums,i,len - 1);
                        break;
                    }
                }
                return;
            }
        }
        //需要将后续的数字转换成最小
        reverse_arr(nums,0,len - 1);
    }
    public void reverse_arr(int[] arr, int start, int end) {
        int temp = 0;
        while(start < end){
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = new int[]{1,3,5,4,3};
        s.nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }
}


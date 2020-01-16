package LeetCode.回溯算法.全排列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if(nums.length == 0)return result;
        Integer[] arr = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
        }
        sub_permute(arr, 0);
        return result;
    }

    public void sub_permute(Integer[] nums, int start_index) {
        for (int i = start_index; i < nums.length; i++) {
            swap(nums, start_index, i);
            if (start_index < nums.length - 1) {
                sub_permute(nums, start_index + 1);
            } else {
                result.add(new ArrayList(Arrays.asList(nums)));
            }
            swap(nums, start_index, i);
        }
    }

    public void swap(Integer[] nums, int start_index, int end_index) {
        int temp = nums[start_index];
        nums[start_index] = nums[end_index];
        nums[end_index] = temp;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = new int[]{1,2,3};
        s.permute(arr);
        for (int i = 0; i < s.result.size(); i++) {
            System.out.println(s.result.get(i));
        }
    }
}


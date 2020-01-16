package LeetCode.数组.子集2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) return result;
        result.add(new LinkedList<>());
        Arrays.sort(nums);
        int last_index = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp_size = result.size();
            int temp = 0;
            if(i > 0 && nums[i] == nums[i - 1]){
                temp = last_index + 1;
            }
            for (int j = temp; j < temp_size; j++) {
                ArrayList<Integer> list = new ArrayList<>(result.get(j));
                list.add(nums[i]);
                result.add(list);
            }
            last_index = temp_size - 1;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = new int[]{1,2,2,2};
        List<List<Integer>> result = s.subsetsWithDup(arr);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}


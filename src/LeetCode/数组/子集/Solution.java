package LeetCode.数组.子集;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        //我觉得这个思路还可以啊 换成ArrayList速度快1ms？？？
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) return result;
        result.add(new LinkedList<>());
        for (int i = 0; i < nums.length; i++) {
            int temp_size = result.size();
            for (int j = 0; j < temp_size; j++) {
                ArrayList<Integer> list = new ArrayList<>(result.get(j));
                list.add(nums[i]);
                result.add(list);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = new int[]{3, 5, 7};
        List<List<Integer>> result = s.subsets(arr);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}


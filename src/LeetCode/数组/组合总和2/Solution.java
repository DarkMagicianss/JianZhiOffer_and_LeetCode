package LeetCode.数组.组合总和2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    List<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        sub_combinationSum(new ArrayList<>(), 0, 0, candidates, target);
        return result;
    }

    public boolean sub_combinationSum(List<Integer> list, int base, int start_index, int[] candidates, int target) {
        //添加一个start_index 防止再次访问已添加的数字
        for (int i = start_index; i < candidates.length; i++) {
            //过滤重复出现的数字 而形成的的重复组合
            if(i > start_index && candidates[i] == candidates[i - 1])continue;
            if (base + candidates[i] == target) {
                if (list.size() > 0 && candidates[i] < list.get(list.size() - 1)) continue;
                list.add(candidates[i]);
                result.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
                return false;//返回继续搜索
            } else if (base + candidates[i] < target) {
                if (list.size() > 0 && candidates[i] < list.get(list.size() - 1)) continue;
                list.add(candidates[i]);
                if (!sub_combinationSum(list, base + candidates[i], i + 1, candidates, target)) {
                    list.remove(list.size() - 1);
                }
            } else {
                return false;//返回继续搜索
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = new int[]{2,5,2,1,2};
        List<List<Integer>> result = s.combinationSum2(arr, 5);
        for (List<Integer> l : result) {
            System.out.println(l);
        }
    }
}


package LeetCode.数组.组合总和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        sub_combinationSum(new ArrayList<>(), 0, candidates, target);
        return result;
    }
    public boolean sub_combinationSum(List<Integer> list, int base, int[] candidates, int target) {
        for (int i = 0; i < candidates.length; i++) {
            if (base + candidates[i] == target) {
                if (list.size() > 0 && candidates[i] < list.get(list.size() - 1)) continue;
                list.add(candidates[i]);
                result.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
                return false;//返回继续搜索
            } else if (base + candidates[i] < target) {
                if (list.size() > 0 && candidates[i] < list.get(list.size() - 1)) continue;
                list.add(candidates[i]);
                if (!sub_combinationSum(list, base + candidates[i], candidates, target)) {
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
        int[] arr = new int[]{2, 3, 5};
        List<List<Integer>> result = s.combinationSum(arr, 8);
        for (List<Integer> l : result) {
            System.out.println(l);
        }
    }
}


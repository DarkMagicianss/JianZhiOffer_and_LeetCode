package LeetCode.回溯算法.全排列2;

import java.util.*;

public class Solution {
    List<List<Integer>> list = new ArrayList<>();
    int[] nums;

    public List<List<Integer>> permuteUnique(int[] nums) {
        this.nums = nums;
        Arrays.sort(nums);
        LinkedList<Integer> ll = new LinkedList<>();
        boolean[] flag = new boolean[nums.length];
        dfs(ll, flag, 0);
        return list;
    }

    public void dfs(LinkedList<Integer> ll, boolean[] flag, int length) {
        if (length == nums.length) {
            list.add(new ArrayList<>(ll));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //这个位置用过了
            if (flag[i]) continue;
            //i-1和i的值相等，且i-1没被用过（之后可能会被用就产生重复）
            if (i > 0 && nums[i - 1] == nums[i] && flag[i - 1] == false) {
                continue;
            }
            ll.addLast(nums[i]);
            flag[i] = true;
            dfs(ll, flag, length + 1);
            flag[i] = false;
            ll.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = new int[]{1, 1, 2, 2};
        s.permuteUnique(arr);
        for (int i = 0; i < s.list.size(); i++) {
            System.out.println("line:" + i + "   " + s.list.get(i));
        }
        System.out.println(s.list.size());
    }
}


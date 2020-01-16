package LeetCode.回溯算法.组合_____从n个中选k个排列;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || k <= 0 || n < k) {
            return result;
        }
        sub_combine(new LinkedList<>(), 1, n, k);
        return result;
    }

    public void sub_combine(LinkedList<Integer> list, int now_num, int n, int k) {
        //从n个中选k个进行排列
        if (list.size() == k) {
            result.add(new LinkedList<>(list));
            return;
        }
        for (int i = now_num; i <= n - k + list.size() + 1; i++) {//这里需要优化i <= n - k + len + 1 速度便会快很多
            list.addLast(i);
            sub_combine(list, i + 1, n, k);
            list.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> result = s.combine(6, 3);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}

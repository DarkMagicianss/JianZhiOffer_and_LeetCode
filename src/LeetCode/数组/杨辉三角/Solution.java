package LeetCode.数组.杨辉三角;


import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0) return result;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        result.add(new ArrayList<>(list));
        if (numRows == 1) return result;
        list.add(1);
        result.add(new ArrayList<>(list));
        if (numRows == 2) return result;
        int level = 2;
        while (level < numRows) {
            List<Integer> res = new ArrayList<>(level + 1);
            long cur = 1;
            for (int i = 0; i <= level; i++) {
                res.add((int) cur);
                cur = cur * (level - i) / (i + 1);
            }
            result.add(new ArrayList<>(res));
            level++;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> result =  s.generate(5);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}

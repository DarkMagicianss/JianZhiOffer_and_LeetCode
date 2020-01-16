package LeetCode.字符串.括号生成_____想不到如何生成括号_____回溯法;

import java.util.*;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0) return result;
        generate(result, "", 0, 0, n);
        return result;
    }

    public void generate(List<String> result, String now, int open, int close, int max) {
        if (now.length() == 2 * max) {//当总长达到左括号的两倍时
            result.add(now);
            return;
        }
        if (open < max) //当左括号个数小于n个时
            generate(result, now + "(", open + 1, close, max);
        if (close < open) //当右括号个数小于左括号个数时(大于等于则非法)  原本是close < max 但是还要考虑小于左括号的个数
            generate(result, now + ")", open, close + 1, max);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> list = s.generateParenthesis(2);
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}

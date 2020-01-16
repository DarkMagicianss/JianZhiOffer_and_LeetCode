package LeetCode.回溯算法.分割回文串;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<List<String>> result = new LinkedList<>();

    public List<List<String>> partition(String s) {
        LinkedList<String> list = new LinkedList<>();
        sub_partition(s, list);
        return result;
    }

    public void sub_partition(String s, LinkedList<String> list) {
        if (s.length() == 0) {
            result.add(new LinkedList<>(list));
            return;
        }
        for (int i = 1; i <= s.length(); i++) {
            if (isPalindrome(s, 0, i)) {
                list.addLast(s.substring(0, i));
                sub_partition(s.substring(i), list);
                list.removeLast();
            }
        }
    }

    public boolean isPalindrome(String s, int start, int end) {
        if (end - start == 1) return true;
        end--;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<String>> result = s.partition("aab");
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}


package LeetCode.字符串.重复的DNA序列;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() <= 10) return result;
        HashSet<String> set1 = new HashSet<>();
        HashSet<String> set2 = new HashSet<>();
        for (int i = 9; i < s.length(); i++) {
            String temp = s.substring(i - 9, i + 1);
            if(set1.contains(temp)){
                set2.add(temp);
            }else {
                set1.add(temp);
            }
        }
        result.addAll(set2);
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findRepeatedDnaSequences("AAAAAAAAAA"));
        System.out.println(s.findRepeatedDnaSequences("AAAAAAAAAAA"));
        System.out.println(s.findRepeatedDnaSequences("AAAAAAAAAAAA"));
        System.out.println(s.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
        System.out.println(s.findRepeatedDnaSequences("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"));
        System.out.println(s.findRepeatedDnaSequences("AAAAAAAAAAAAAAAAACCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCAAAAAAAAAAAAAAAA"));
    }
}

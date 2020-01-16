package LeetCode.字符串.同构字符串;

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s == null && t == null) return true;
        if (s.length() == 0 && t.length() == 0) return true;
        if (s.equals(t)) return true;
        int[] set1 = new int[128 + 1];
        int[] set2 = new int[128 + 1];
        for (int i = 0; i < s.length(); i++) {
            int s_index = s.charAt(i);
            int t_index = t.charAt(i);
            if (set1[s_index] == 0) {
                set1[s_index] = i + 1;
                if (set2[t_index] != 0) return false;
                set2[t_index] = i + 1;
            } else {
                int equals_index = set1[s_index];
                if (equals_index != set2[t_index]) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isIsomorphic("egg", "add"));
        System.out.println(s.isIsomorphic("foo", "bar"));
        System.out.println(s.isIsomorphic("paper", "title"));
    }
}

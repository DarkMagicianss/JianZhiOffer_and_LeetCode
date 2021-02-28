package com.xiaomi.ad.osctask.ad;

/**
 * @author LinHu
 * @version 2021/2/27
 */
public class Solution {
    public boolean isSubsequence(String s, String t) {
        if (t.length() == 0 && s.length() == 0) return true;
        if (t.length() == 0 && s.length() != 0) return false;
        if (t.length() != 0 && s.length() == 0) return true;
        int index = 0;
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == s.charAt(index)){
                index++;
                if (index == s.length()) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isSubsequence("abc","ahbgdc"));
        System.out.println(s.isSubsequence("axc","ahbgdc"));
    }
}

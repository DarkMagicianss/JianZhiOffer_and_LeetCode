package LeetCode.字符串.验证回文串;

public class Solution {
    public boolean isPalindrome(String s) {
        if (s.equals("")) return true;
        s = s.toLowerCase();
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            char left_c = s.charAt(left);
            char right_c = s.charAt(right);
            if (left_c >= 'A' && left_c <= 'Z') left_c += 32;
            if (right_c >= 'A' && right_c <= 'Z') right_c += 32;
            if(!sub_range(left_c)){
                left++;
                continue;
            }
            if(!sub_range(right_c)){
                right--;
                continue;
            }
            if (left_c!= right_c) return false;
            left++;
            right--;
        }
        return true;
    }

    public boolean sub_range(char a) {
        if ((a >= '0' && a <= '9') || (a >= 'a' && a <= 'z')) {
            return true;
        } else return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isPalindrome(".,"));
    }
}

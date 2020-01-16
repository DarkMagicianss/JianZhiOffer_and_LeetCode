package LeetCode.数字.回文数_____将数字反转一半还是不错的思路;

public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x <= 9) return true;//例如1会返回false
        if (x % 10 == 0) return false;//例如21120会返回true
        int reverse = 0;
        int source = x;
        while (source > reverse) {
            if (source / 10 == reverse && reverse != 0) return true;
            int temp = source % 10;
            reverse = reverse * 10 + temp;
            source = source / 10;
        }
        if (reverse == source) return true;
        else return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        boolean b = s.isPalindrome(21120);
        System.out.println(b);
    }
}

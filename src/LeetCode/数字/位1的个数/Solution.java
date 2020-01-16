package LeetCode.数字.位1的个数;


public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int result = 0;
        for (int i = 0; i <= 31; i++) {
            result += (n & 1);
            n = n >> 1;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.hammingWeight(-3));
    }
}

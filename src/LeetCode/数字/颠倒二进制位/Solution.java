package LeetCode.数字.颠倒二进制位;


public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i <= 31; i++) {//相当于将二进制进行反转 只不过通过移动的方式
            result += (n & 1) << (31 - i);
            n = n >> 1;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.reverseBits(-3));
    }
}

package LeetCode.数字.数字范围按位与_____整数的溢出问题;


public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        if (m == 0) return 0;
        if (m == n) return m;
        int result = 0;
        int step = 1;
        int count = 0;
        for (int i = 0; i < 32; i++) {
            step *= 2;
            if (m < step && step < n) {
                result = step;
                count++;
            }
        }
        if (count >= 1) return 0;
        else {
            Out:
            for (int i = 0; i < 32; i++) {//对应第0位 一直到第31位
                In:
                for (int j = m; j <= n && j > 0; j++) {//这个j当为Integer.Max_Value的时候会出现溢出 真是666啊
                    if (((j >> i) & 1) == 0) {
                        continue Out;
                    }
                }
                result += 1 << i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.rangeBitwiseAnd(5, 7));
        System.out.println(s.rangeBitwiseAnd(0, 1));
        System.out.println(s.rangeBitwiseAnd(2147483646, 2147483647));
    }
}


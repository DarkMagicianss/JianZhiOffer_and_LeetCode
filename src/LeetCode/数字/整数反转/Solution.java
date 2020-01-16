package LeetCode.数字.整数反转;

public class Solution {
    public int reverse(int x) {
        if (x == Integer.MIN_VALUE || x == 0) return 0;
        int fu_flag = 1;
        if (x < 0) {
            fu_flag = -1;
            x = -x;
        }
        long result = 0;
        while (x != 0) {
            //System.out.println(result);
            result = 10 * result + x % 10;
            x = x / 10;
        }
        //反转以后这个数字可能大于Integer.MAX_VALUE
        if (result > Integer.MAX_VALUE) return 0;
        return (int)(fu_flag * result);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int result = s.reverse(1534236469);
        System.out.println(result);
    }
}


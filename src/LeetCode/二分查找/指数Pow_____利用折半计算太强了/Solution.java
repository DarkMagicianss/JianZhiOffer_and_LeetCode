package LeetCode.二分查找.指数Pow_____利用折半计算太强了;

public class Solution {
    //这优化也太强了吧
    public double myPow(double x, int n) {
        double result = 1.0;
        for (int i = n; i != 0; i /= 2) {
            if (i % 2 == 1 || i%2 == -1)
                result *= x;
            x *= x;
        }
        return n < 0 ? 1 / result : result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.myPow(2, -2));
    }
}

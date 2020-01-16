package LeetCode.二分查找.求x的平方根;


public class Solution {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        if (x <= 3) return 1;
        if (x <= 8) return 2;
        long left = 1;
        long right = x / 2;
        long mid = 0;
        while (left <= right) {
            mid = (left + right) >> 1;
            System.out.println(left+"   "+right+"  "+mid);
            if (mid * mid > x) {
                right = mid - 1;
            } else if (mid * mid < x) {
                left = mid + 1;
            } else {
                return (int) mid;
            }
        }
        //原本left为对应的插入的位置 这里想插入的就是平方根
        //因此2.82842...会插在3这个位置
        //而我们在不是完全平方根的情况下是要找比目标位置小一个的位置
        //因此为left-1
        return (int) (left - 1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.mySqrt(2147395599));
    }
}

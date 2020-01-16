package LeetCode.数字.计数质数;


public class Solution {
    public int countPrimes(int n) {
        boolean[] nums = new boolean[n];
        int result = 0;
        for (int i = 2; i < n; i++) {
            //如果当前数为质数
            if (nums[i] == false) {
                result++;
                //从i的平方开始 因为前面的已经被较小的倍数标记为true
                for (long j = (long)i * i; j < n; j += i) {
                    nums[(int)j] = true;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.countPrimes(3));
        System.out.println(s.countPrimes(5));
        System.out.println(s.countPrimes(10));
        System.out.println(s.countPrimes(100));
    }
}

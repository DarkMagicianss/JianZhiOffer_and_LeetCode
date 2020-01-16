package LeetCode.数字.快乐数_____对于无限循环使用快慢指针较好;


public class Solution {
    public boolean isHappy(int n) {
        //碰见无线循环的题目可以考虑一下快慢指针的问题
        int low_step = n;
        int fast_step = sub_isHappy(n);
        while (fast_step != low_step) {
            //慢指针一次走一步 快指针一次走两步 一旦成循环则必定会得出两者相同且不为1
            //若没有成环 则一旦其中一位达到1000或者100或者10则会保持结果1 等待另一方追上
            low_step = sub_isHappy(low_step);
            fast_step = sub_isHappy(sub_isHappy(fast_step));
        }
        return low_step == 1;
    }

    public int sub_isHappy(int step) {
        if (step <= 1) return step;
        int next_step = 0;
        while (step != 0) {
            next_step += (step % 10) * (step % 10);
            step = step / 10;
        }
        return next_step;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isHappy(19));
        System.out.println(s.isHappy(1));
        System.out.println(s.isHappy(2));
        System.out.println(s.isHappy(9));
        System.out.println(s.isHappy(67));
    }
}

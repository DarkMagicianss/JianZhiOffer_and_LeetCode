package LeetCode.数字.阶乘后的零;


public class Solution {
    public int trailingZeroes(int n) {
        //一旦大于5 则所有5和边上偶数相乘即可得到一个10
        //一旦大于25 则和两个偶数相乘即可得到一个100
        //同理递推下去
        long step = 5;
        long result = 0;
        while(n >= step){
            result += n/step;
            step *= 5;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.trailingZeroes(3));
        System.out.println(s.trailingZeroes(5));
        System.out.println(s.trailingZeroes(20));
        System.out.println(s.trailingZeroes(100));
    }
}

package JianZhiOffer.JZ20发散思维能力.求1_2_3_n_____只是想到递归;

public class Solution {
    //不能用if 那我们用&&的短路操作 233333 其中其实也是if的语义
    public int Sum_Solution(int n) {
        int result = 0;
        boolean flag = (n >= 1) && ((result = Sum_Solution(n - 1) + n) > 0);
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.Sum_Solution(5));
    }
}

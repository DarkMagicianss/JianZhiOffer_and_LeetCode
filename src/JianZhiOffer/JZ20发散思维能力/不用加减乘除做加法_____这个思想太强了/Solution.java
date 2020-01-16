package JianZhiOffer.JZ20发散思维能力.不用加减乘除做加法_____这个思想太强了;

public class Solution {
    public int Add(int num1,int num2) {
        if(num2 == 0)return num1;
        int temp1 = num1^num2;
        int temp2 = (num1&num2)<<1;
        return Add(temp1,temp2);
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.Add(4,5));
    }
}

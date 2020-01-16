package JianZhiOffer.JZ11代码的完整性.数组的整数次方;

public class Solution {
    public double Power(double base, int exponent) {
        int fu_flag=0;
        if(base < 0.00001 && base > -0.00001)return 0;
        if(exponent == 0)return 1;
        if(exponent < 0){
            fu_flag=1;
            exponent = -exponent;
        }
        double result = 1.0;
        for(int i=0;i<exponent;i++){
            result = result*base;
        }
        if(fu_flag == 1)return 1.0/result;
        else return result;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.Power(1.1,2));

    }
}

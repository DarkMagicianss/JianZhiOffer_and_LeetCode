package LeetCode.数字.两数相除;

public class Solution {
    public int divide(int dividend, int divisor) {
        long result_num = 0;
        char[] numbers = ((Integer) dividend).toString().toCharArray();//将被除数转换成数组

        //特殊情况判断
        if (dividend == 0) return 0;//被除数为0
        if (divisor == 1) return dividend;//除数为1
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;//+2^31溢出了
        if (dividend == divisor) return 1;
        if (divisor == Integer.MIN_VALUE) {//除数为最小值！！！结果均为0
            return 0;//被除数和除数相等的情况已经在前面排除了
        }

        boolean isfu = false;
        //判断结果的正负标记
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) isfu = true;
        //将被除数和除数转为正
        if (dividend < 0) numbers[0] = '0';
        if (divisor < 0) divisor = -divisor;

        int next_bei = 0;
        for (int i = 0; i < numbers.length; i++) {//计算结果
            long temp_result = 0;
            long now_num = 0;
            for (int j = 0; j < 10; j++) {//将上一位所余下的余数放大10倍
                now_num += next_bei;
                temp_result += result_num;
            }
            now_num += (numbers[i] - '0');//加上当前的这一位
            while (now_num >= divisor) {
                now_num -= divisor;
                temp_result++;
            }
            next_bei = (int) now_num;
            result_num = temp_result;
        }
        if (isfu) return (int) (result_num - result_num - result_num);
        else return (int) result_num;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int result = s.divide(-123, 2);
        System.out.println(result);
    }
}

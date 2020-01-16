package LeetCode.数字.字符串转换整数;

public class Solution {
    public int myAtoi(String str) {
        if (str == null || str.equals("")) return 0;
        char[] arrs = str.toCharArray();
        int str_index = 0;
        long result = 0;//用于记录结果
        int fu_flag = 1;//用于记录正负号
        while (str_index < arrs.length) {//寻找开始的index
            if (arrs[str_index] == '+') {
                fu_flag = 1;
                str_index++;
                break;
            } else if (arrs[str_index] == '-') {
                fu_flag = -1;
                str_index++;
                break;
            } else if (arrs[str_index] >= '0' && arrs[str_index] <= '9') {
                break;
            } else if (arrs[str_index] != ' ') {//若第一个非空字符不为'' 则视为无效
                return 0;
            }
            str_index++;
        }
        while (str_index < arrs.length) {//开始添加数字
            if (arrs[str_index] >= '0' && arrs[str_index] <= '9') {
                result = 10 * result + (arrs[str_index] - '0');
                if (result > Integer.MAX_VALUE) {
                    return fu_flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
            } else {
                break;
            }
            str_index++;
        }
        return (int) (fu_flag * result);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "9223372036854775808";
        int result = s.myAtoi(str);
        System.out.println(result);
    }
}

package LeetCode.数字.字符串相乘;

public class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        if (num1.length() == 1 && num1.equals("1")) return num2;
        if (num2.length() == 1 && num2.equals("1")) return num1;
        int len1 = num1.length();
        int len2 = num2.length();
        int[] result = new int[len1 + len2];//结果长度就是两者长度最大之和 99*99最大就4位 不可能超5位
        //字符串依次相乘计算
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                //操作result的时候将下标往右移一位 方便计算和统计
                int temp_result = result[i + j + 1] + (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                result[i + j + 1] = temp_result % 10;
                if (temp_result / 10 != 0) {
                    result[i + j - 1 + 1] += temp_result / 10;
                }
            }
            //System.out.println(Arrays.toString(result));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            if (i == 0 && result[i] == 0) continue;//不添加首位的0
            sb.append(result[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String num1 = "2", num2 = "3";
        System.out.println(s.multiply(num1, num2));
    }
}

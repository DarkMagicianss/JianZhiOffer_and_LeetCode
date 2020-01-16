package LeetCode.数字.有效数字;

public class Solution {
    public boolean isNumber(String s) {
        if (s == null || s.equals("")) return false;
        s = s.trim();//去掉字符串左右的空格
        int len = s.length();
        if (len == 0) return false;
        int e_flag = 0;
        int p_flag = 0;
        int num_flag = 0;
        int start_index = 0;
        char[] arr = s.toCharArray();
        if (len == 1 && (arr[0] < '0' || arr[0] > '9')) return false;
        if (arr[0] == '+' || arr[0] == '-') {
            start_index++;
        }
        for (int i = start_index; i < arr.length; i++) {
            if (arr[i] >= '0' && arr[i] <= '9') {
                num_flag = 1;
                continue;
            } else if (arr[i] == '.') {//.不能为首 也不能为尾
                if (e_flag == 1) return false;//e在.之前 则指数不能为小数 返回false
                if (i > start_index && arr[i - 1] == 'e' && num_flag == 0) return false;//前一个为e
                if (p_flag == 0) p_flag = 1;
                else return false;
            } else if (arr[i] == 'e' && i != start_index && i != arr.length - 1) {//e不能为首 也不能为尾
                if (arr[i - 1] == '.'  && num_flag == 0) return false;//前一个为.
                if (e_flag == 0) e_flag = 1;
                else return false;
            } else if ((arr[i] == '+' || arr[i] == '-') && i != arr.length - 1) {
                if (arr[i - 1] == 'e') continue;
                else return false;
            } else {
                return false;
            }
        }
        if(num_flag == 1)return true;
        else return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isNumber("0"));
        System.out.println(s.isNumber(" 0.1 "));
        System.out.println(s.isNumber("abc"));
        System.out.println(s.isNumber("1 a"));
        System.out.println(s.isNumber("2e10"));
        System.out.println(s.isNumber(" -90e3   "));
        System.out.println(s.isNumber(" 1e"));
        System.out.println(s.isNumber("e3"));
        System.out.println(s.isNumber(" 6e-1"));
        System.out.println(s.isNumber(" 99e2.5 "));
        System.out.println(s.isNumber("53.5e93"));
        System.out.println(s.isNumber(" --6 "));
        System.out.println(s.isNumber("-+3"));
        System.out.println(s.isNumber("95a54e53"));
        System.out.println(s.isNumber("4e+"));
        System.out.println(s.isNumber("3."));
        System.out.println(s.isNumber(".3"));
        System.out.println(s.isNumber("."));
        System.out.println(s.isNumber("2e-5"));
    }
}

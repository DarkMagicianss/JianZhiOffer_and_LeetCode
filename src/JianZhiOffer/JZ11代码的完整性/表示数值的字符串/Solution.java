package JianZhiOffer.JZ11代码的完整性.表示数值的字符串;

public class Solution {
    public boolean isNumeric(char[] str) {
        if (str == null || str.length == 0) return false;
        return isAllNum(str, 0, '@');//'@'作为一个初始的标记符号
    }

    public boolean isAllNum(char[] str, int sindex, char pattern) {//包含+-的纯数字
        //后来发现.后面如果加+-号的话判断可能会有偏差
        if (pattern == '.' && (str[sindex] == '+' || str[sindex] == '-')) return false;
        if (!(str[sindex] == '+' || str[sindex] == '-' || (str[sindex] >= '0' && str[sindex] <= '9')))
            return false;
        for (int i = sindex + 1; i < str.length; i++) {
            if ((pattern == 'E' || pattern == 'e') && str[i] == '.') return false;
            if ((pattern == '.' && (str[i] == 'e' || str[i] == 'E')) || (pattern == '@' && (str[i] == '.' || str[i] == 'e' || str[i] == 'E'))) {
                if (i + 1 < str.length) {
                    return isAllNum(str, i + 1, str[i]);
                } else
                    return false;
            }
            if (!(str[i] >= '0' && str[i] <= '9')) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isNumeric("+100".toCharArray()));
        System.out.println(s.isNumeric("5e2".toCharArray()));
        System.out.println(s.isNumeric("-123".toCharArray()));
        System.out.println(s.isNumeric("3.1416".toCharArray()));
        System.out.println(s.isNumeric("-1E-16".toCharArray()));
        System.out.println(s.isNumeric("123.45e+6".toCharArray()));
        System.out.println(" ");
        System.out.println(s.isNumeric("12e".toCharArray()));
        System.out.println(s.isNumeric("1a3.14".toCharArray()));
        System.out.println(s.isNumeric("1.2.3".toCharArray()));
        System.out.println(s.isNumeric("+-5".toCharArray()));
        System.out.println(s.isNumeric("12e+4.3".toCharArray()));
        System.out.println(s.isNumeric("12.-3e5".toCharArray()));
    }
}

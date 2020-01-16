package JianZhiOffer.JZ2字符串.字符串转换成整数;

public class Solution {
    public int StrToInt(String str) {
        if (str == null || str.length() == 0) return 0;
        char[] arr = str.toCharArray();
        int fu_flag = 0;
        int result = 0;
        if (arr[0] == '+' || (arr[0] >= '0' && arr[0] <= '9')) {
            fu_flag = 1;
            if (arr[0] != '+') {
                result = arr[0] - '0';
            }
        } else if (arr[0] == '-') {
            fu_flag = -1;
        } else {
            return 0;
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] >= '0' && arr[i] <= '9') {
                result *=10;
                result += arr[i]-'0';
            } else {
                return 0;
            }
        }
        return fu_flag*result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.StrToInt("2147483647"));
    }
}

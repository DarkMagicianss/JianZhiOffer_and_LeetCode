package LeetCode.字符串.电话号码的字母组合;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<String>();
        if(digits == null || digits.length() == 0)return result;
        String[][] num = new String[8][];
        num[0] = new String[]{"a", "b", "c"};
        num[1] = new String[]{"d", "e", "f"};
        num[2] = new String[]{"g", "h", "i"};
        num[3] = new String[]{"j", "k", "l"};
        num[4] = new String[]{"m", "n", "o"};
        num[5] = new String[]{"p", "q", "r", "s"};
        num[6] = new String[]{"t", "u", "v"};
        num[7] = new String[]{"w", "x", "y", "z"};
        int length = digits.length();
        char[] arr = digits.toCharArray();
        int first_num = arr[0] - '2';
        for (int i = 0; i <num[first_num].length; i++) {
            result.add(num[first_num][i]);
        }
        for (int i = 1; i < arr.length; i++) {
            ArrayList<String> temp_result = new ArrayList<String>();
            int now_num = arr[i] - '2';
            for (int j = 0; j < num[now_num].length; j++) {
                for (int k = 0; k < result.size(); k++) {
                    temp_result.add(result.get(k) + num[now_num][j]);
                }
            }
            result = temp_result;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> result = s.letterCombinations("234");
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}

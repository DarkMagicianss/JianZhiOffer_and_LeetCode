package LeetCode.字符串.报数;


public class Solution {
    public String countAndSay(int n) {
        if(n == 1)return "1";
        int step = 1;
        String str = "1";
        while (step < n) {
            StringBuilder sb = new StringBuilder();
            char[] arr = str.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                int index = 0;
                while (i + index + 1 < arr.length && arr[i + index] == arr[i + index + 1]) {
                    index++;
                }
                index++;//记上最初那个
                sb.append(index + "" + arr[i]);
                i = i + index - 1;
            }
            str = sb.toString();
            step++;
        }
        return str;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.countAndSay(5));
    }
}

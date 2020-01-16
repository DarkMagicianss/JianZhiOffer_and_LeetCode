package LeetCode.数字.Excel表列名称_____1到n转成0到n_1_____考虑是否存在溢出;


public class Solution {
    public String convertToTitle(int n) {
        n = n - 1;
        long start = 26;
        StringBuilder sb = new StringBuilder();
        while (n / start > 0) {//找大范围
            n -= start;
            start *= 26;
            //System.out.println(n+"   "+start);
        }
        start /= 26;
        while (start != 0) {
            sb.append((char) ('A' + n / start));
            //System.out.println((char) ('A' + n / start - 1));
            n %= start;
            start /= 26;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.convertToTitle(1));
        System.out.println(s.convertToTitle(28));
        System.out.println(s.convertToTitle(701));
        System.out.println(s.convertToTitle(702));
        System.out.println(s.convertToTitle(703));
        System.out.println(s.convertToTitle(3));
        System.out.println(s.convertToTitle(26));
        System.out.println(s.convertToTitle(27));
        System.out.println(s.convertToTitle(1000000001));
    }
}


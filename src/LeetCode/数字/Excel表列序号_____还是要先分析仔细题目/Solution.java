package LeetCode.数字.Excel表列序号_____还是要先分析仔细题目;


public class Solution {
    public int titleToNumber(String s) {
        int result = 0;
        for (int i = 1; i < s.length(); i++) {
            result += Math.pow(26, i);
        }
        //System.out.println(s + "  base: " + result);
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'A';
            result += index * Math.pow(26, (s.length() - 1 - i));
        }
        return result + 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.titleToNumber("A"));
        System.out.println(s.titleToNumber("AA"));
        System.out.println(s.titleToNumber("AB"));
        System.out.println(s.titleToNumber("ZY"));
        System.out.println(s.titleToNumber("Z"));
        System.out.println(s.titleToNumber("AAA"));
        System.out.println(s.titleToNumber("ZZ"));
    }
}


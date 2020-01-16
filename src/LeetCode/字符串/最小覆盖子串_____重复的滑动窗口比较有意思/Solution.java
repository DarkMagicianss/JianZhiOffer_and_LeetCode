package LeetCode.字符串.最小覆盖子串_____重复的滑动窗口比较有意思;


public class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0) return "";
        int[] record = new int[128];//存储所有的字符情况
        for (char c : t.toCharArray()) {
            record[c]++;//统计目标值的个数
        }
        int i = 0, j = 0;
        int l = 0, r = 0;
        int len = t.length();
        char[] arr = s.toCharArray();
        //开始的时候 所有128的字母个数都为0 但是目标值的个数为正
        while (r < s.length()) {
            if (record[arr[r]] > 0) len--;//若是目标值 则总长len--
            record[arr[r]]--;
            r++;
            while (len == 0) {
                if (j == 0 || r - l < j - i) {//当前的left-right比ij短 就取当前的left-right
                    i = l;
                    j = r;
                }
                record[arr[l]]++;
                if (record[arr[l]] > 0) {//一直加 加到正数说明原来该位置是一个目标值
                    len++;
                }
                l++;
            }
        }
        return s.substring(i, j);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minWindow("bbaa", "aba"));
    }
}


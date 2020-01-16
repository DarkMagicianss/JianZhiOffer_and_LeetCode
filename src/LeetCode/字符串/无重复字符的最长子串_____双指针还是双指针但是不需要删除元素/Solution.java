package LeetCode.字符串.无重复字符的最长子串_____双指针还是双指针但是不需要删除元素;


import java.util.HashMap;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        //用双指针的形式 还可以啊
        //出现不同的 后指针走
        //出现相同的 前指针走到之前相同的字符位置的后一位 还要删除中间的重数字
        //!!!这里其实需要考虑为什么要删除？为了保持Map里面元素的一致性？但是Map里面就是不允许重复的呀!!!
        //!!!其实是为了若后续出现重复元素时 判断是否在我们的最长无重复的子串中 那么就可以判断其重复的元素的index是否在前指针之后!!!
        //!!!因此这里可以优化为 只进行前指针和旧元素之间的判断 而无需删除 方正同一个元素 Map里面存的都是最新的index!!!
        if (s.length() <= 1) return s.length();
        int max = 1;
        int left = 0, right = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 0);
        for (int i = 1; i < s.length(); i++) {
            right++;
            if (map.containsKey(s.charAt(i))) {
                int old_index = map.get(s.charAt(i));
//                for (int j = left; j <= old_index; j++) {//删除之间的重复元素
//                    map.remove(s.charAt(j));
//                }
                left = Math.max(old_index + 1, left);//因为不能把原来的重复元素包进去 因此要old_index+1
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, right - left + 1);
            if (max > s.length() - 1 - left + 1) return max;
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "abcabcbb";
        int a = s.lengthOfLongestSubstring(str);
        System.out.println(a);
    }
}


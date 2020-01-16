package LeetCode.字符串.串联所有单词的子串_____滑动窗口双指针;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    //使用滑动窗口的方式 太强了
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) return res;
        HashMap<String, Integer> map = new HashMap<>();
        int one_word = words[0].length();
        int word_num = words.length;
        int all_len = one_word * word_num;
        if (s.length() < all_len) return res;
        for (String word : words) {//添加map
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i < one_word; i++) {//就循环一个单词的长度 每次都进行一个单词长度的跳跃
            int left = i, right = i, count = 0;
            HashMap<String, Integer> tmp_map = new HashMap<>();//用于统计中间的各个单词的个数
            while (right + one_word <= s.length()) {
                String w = s.substring(right, right + one_word);
                right += one_word;
                if (!map.containsKey(w)) {//若不包含 则左指针移动到右指针 清空temp_map
                    count = 0;
                    left = right;
                    tmp_map.clear();
                } else {
                    tmp_map.put(w, tmp_map.getOrDefault(w, 0) + 1);
                    count++;
                    while (tmp_map.getOrDefault(w, 0) > map.getOrDefault(w, 0)) {
                        //当某一个超出范围则left指针一直移动 直到正好在范围内
                        String t_w = s.substring(left, left + one_word);
                        count--;
                        tmp_map.put(t_w, tmp_map.getOrDefault(t_w, 0) - 1);
                        left += one_word;
                    }
                    if (count == word_num) res.add(left);
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] arr = new String[]{"word", "good", "best", "word"};
        List<Integer> result = s.findSubstring("wordgoodgoodgoodbestwordwordgood", arr);
        System.out.println(result.toString());
    }
}

package LeetCode.动态规划.单词拆分2_____记忆化加速还是不错的;

import java.util.*;

public class Solution {
    //记忆化通过把过程中的部分最优解全部记录下来 后续要用的话直接拿 不然就计算 然后在放入map中去
    //其实这也是动态规划的其中一个特点
    Map<String, List<String>> map = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        if (map.containsKey(s)) return map.get(s);
        List<String> list = new ArrayList<>();
        if (s.length() == 0) {
            list.add("");
            return list;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> tempList = wordBreak(s.substring(word.length()), wordDict);
                for (String str : tempList) {
                    list.add(word + (str.equals("") ? "" : " ") + str);
                }
            }
        }
        map.put(s, list);
        return list;
    }
//    //写的和官方的题解挺像的就是超时了 2333333
//    public List<String> wordBreak(String s, List<String> wordDict) {
//        List<String>[] dp = new ArrayList[s.length() + 1];
//        dp[0] = new ArrayList<>();
//        dp[0].add("");
//        for (int i = 1; i < dp.length; i++) {
//            dp[i] = new ArrayList<>();
//            for (String word_s : wordDict) {
//                if (i >= word_s.length() && word_s.equals(s.substring(i - word_s.length(), i))){
//                    List<String> old_list = dp[i - word_s.length()];
//                    for (int j = 0; j < old_list.size(); j++) {
//                        String temp_old_str = old_list.get(j);
//                        if (temp_old_str == "") {
//                            dp[i].add(temp_old_str + word_s);
//                        } else {
//                            dp[i].add(temp_old_str + " " + word_s);
//                        }
//                    }
//                }
//            }
//        }
//        return dp[s.length()];
//    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> list = Arrays.asList(new String[]{"apple", "pen", "applepen", "pine", "pineapple"});
        List<String> result = s.wordBreak("pineapplepenapple", list);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i) + "----");
        }
    }
}

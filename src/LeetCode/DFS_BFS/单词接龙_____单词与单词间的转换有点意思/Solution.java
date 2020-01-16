package LeetCode.DFS_BFS.单词接龙_____单词与单词间的转换有点意思;

import javafx.util.Pair;

import java.util.*;

public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //关键点是将字符串abc转换成ab*,a*c,*bc这种通配的形式 方便进行匹配
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (int i = 0; i < wordList.size(); i++) {
            String str = wordList.get(i);
            char[] arr = str.toCharArray();
            for (int j = 0; j < str.length(); j++) {//遍历所有wordList 添加通配字符
                char temp_char = arr[j];
                arr[j] = '*';
                String temp_result = new String(arr);
                ArrayList list = map.getOrDefault(temp_result, new ArrayList<>());
                list.add(str);
                map.put(temp_result, list);
                arr[j] = temp_char;
            }
        }
        LinkedList<Pair<String, Integer>> queue = new LinkedList<>();
        queue.addLast(new Pair<>(beginWord, 1));
        while (!queue.isEmpty()) {
            Pair curr_pair = queue.pollFirst();
            String cur_str = (String) curr_pair.getKey();
            Integer step = (Integer) curr_pair.getValue();
            //System.out.println(cur_str + "   " + step);
            if (cur_str.equals(endWord)) return step;
            char[] arr = cur_str.toCharArray();
            for (int i = 0; i < cur_str.length(); i++) {//遍历所有wordList 添加通配字符
                char temp_char = arr[i];
                arr[i] = '*';
                String temp_result = new String(arr);
                ArrayList<String> list = map.remove(temp_result);
                if(list == null) {
                    arr[i] = temp_char;
                    continue;
                }
                //System.out.println(list);
                for (int j = 0; j < list.size(); j++) {
                    if (!list.get(j).equals(cur_str))
                        queue.addLast(new Pair<>(list.get(j), step + 1));
                }
                arr[i] = temp_char;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> list = Arrays.asList(new String[]{"hot", "dot", "dog", "lot", "log", "cog"});
        System.out.println(s.ladderLength("hit", "cog", list));
    }
}

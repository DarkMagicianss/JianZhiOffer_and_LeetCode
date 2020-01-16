package LeetCode.字符串.字母异位词分组;

import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String temp = new String(arr);
            ArrayList<String> list = map.containsKey(temp) ? map.get(temp) : new ArrayList<String>();
            list.add(strs[i]);
            map.put(temp, list);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] arr = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = s.groupAnagrams(arr);
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                System.out.print(result.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}

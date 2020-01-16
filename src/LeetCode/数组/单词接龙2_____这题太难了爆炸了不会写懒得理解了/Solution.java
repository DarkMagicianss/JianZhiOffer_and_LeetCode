package LeetCode.数组.单词接龙2_____这题太难了爆炸了不会写懒得理解了;

import java.util.*;

public class Solution {
    public  List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        //结果
        List<List<String>> res = new ArrayList<>();
        if(wordList == null) return res;
        //bfs搜索所用的字典
        Set<String> dicts = new HashSet<>(wordList);
        if(!dicts.contains(endWord)) return res;
        if(dicts.contains(beginWord)) dicts.remove(beginWord);
        //bfs搜索最短路径所用的开始和结束的字典
        Set<String> endList = new HashSet<>(),
                beginList = new HashSet<>();
        //每个点所对应的邻接点，list
        Map<String, List<String>> map = new HashMap<>();
        beginList.add(beginWord);
        endList.add(endWord);
        bfs(map, beginList, endList, beginWord, endWord,dicts, false);
        //dfs的前进路线保存list
        List<String> subList = new ArrayList<>();
        subList.add(beginWord);
        dfs(map, res, subList, beginWord, endWord);
        return res;
    }
    void dfs (Map<String, List<String>> map,
              List<List<String>> result, List<String> subList,
              String beginWord, String endWord) {
        if(beginWord.equals(endWord)) {
            result.add(new ArrayList<>(subList));
            return;
        }
        if (!map.containsKey(beginWord)) {
            return;
        }
        for (String word : map.get(beginWord)) {
            subList.add(word);
            dfs(map, result, subList, word, endWord);
            subList.remove(subList.size() - 1);
        }
    }
    //reverse是双端bfs的一个优化
    void bfs(Map<String, List<String>> map, Set<String> beginList, Set<String> endList, String beginWord, String endWord,Set<String> wordList, boolean reverse){
        if(beginList.size() == 0) return;
        wordList.removeAll(beginList);
        boolean finish = false;
        Set<String> temp = new HashSet<>();
        for(String str : beginList){
            char[] charr = str.toCharArray();
            for(int chI = 0; chI < charr.length; chI++){
                char old = charr[chI];
                for(char ch = 'a'; ch <= 'z'; ch++){
                    if(ch == old)
                        continue;
                    charr[chI] = ch;
                    String newstr = new String(charr);
                    if(!wordList.contains(newstr)){
                        continue;
                    }
                    //若是在某一层找到了最后的节点，就直接标记找到了，即一票决定。这里因为要找所有的最短路径，所以循环还是要继续的。
                    if(endList.contains(newstr)){
                        finish = true;
                    }else{
                        temp.add(newstr);
                    }
                    //无论怎么变换方向，永远用开始方向的字符做key，是为了后面的dfs，单一方向搜索
                    String key = reverse? newstr:str;
                    String value = reverse ? str : newstr;
                    if(!map.containsKey(key)){
                        map.put(key, new ArrayList<>());
                    }
                    map.get(key).add(value);

                }
                charr[chI] = old;
            }
        }
        if(!finish) {
            if(temp.size() > endList.size()){
                bfs(map, endList, temp, beginWord, endWord,wordList, !reverse);
            }else{
                bfs(map, temp, endList, beginWord, endWord, wordList, reverse);
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> list = Arrays.asList(new String[]{"hot", "dot", "dog", "lot", "log", "cog"});
        List<List<String>> result = s.findLadders("hit", "cog", list);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}

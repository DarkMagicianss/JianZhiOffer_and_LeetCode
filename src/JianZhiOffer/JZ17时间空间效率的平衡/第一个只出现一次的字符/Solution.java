package JianZhiOffer.JZ17时间空间效率的平衡.第一个只出现一次的字符;

import java.util.LinkedHashMap;

public class Solution {
    public int FirstNotRepeatingChar(String str) {
        if(str == null || str.length() == 0)return -1;
        char[] char_arr = str.toCharArray();
        int len = char_arr.length;
        LinkedHashMap<Character,Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < len; i++) {
            if(map.containsKey(char_arr[i])){
                map.put(char_arr[i],Integer.MIN_VALUE);
            }else{
                map.put(char_arr[i],i);
            }
        }
        for (int i = 0; i < len; i++) {
            if(map.get(char_arr[i]) >=0)return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.FirstNotRepeatingChar("google"));
    }
}

package JianZhiOffer.JZDiff.字符串的排列_____没思路啊;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    ArrayList<String> list = new ArrayList<>();

    public ArrayList<String> Permutation(String str) {
        if (str == null || str.length() == 0) return list;
        char[] arr_str = str.toCharArray();
        sub_Permutation(arr_str, 0);
        Collections.sort(list);
        return list;
    }

    private void sub_Permutation(char[] arr_str, int index) {
        int last_index = arr_str.length - 1;
        if (index >= last_index) {
            list.add(new String(arr_str));
        } else {
            for (int i = index; i <= last_index; i++) {//使用递归思路将所有形式进行遍历
                if (arr_str[index] == arr_str[i] && index != i)//跳过重复的字符的交换
                    continue;
                swap(index, i, arr_str);
                sub_Permutation(arr_str, index + 1);
                swap(index, i, arr_str);
            }
        }
    }

    private void swap(int a, int b, char[] arr) {
        char temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "cba";
        ArrayList<String> list = s.Permutation(str);
        for (String string : list) {
            System.out.println(string);

        }
    }
}

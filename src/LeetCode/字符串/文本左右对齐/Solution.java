package LeetCode.字符串.文本左右对齐;


import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(words[i]);
            int temp_width = words[i].length();
            int count = i + 1;
            while (count <= words.length - 1 && temp_width + (1 + words[count].length()) <= maxWidth) {
                temp_width += (1 + words[count].length());//1代表单词之间最小的空格数
                count++;
            }
            count--;
            int per_space_num = count - i;//代表中间空格位置的个数
            int per_space_all = maxWidth - temp_width + per_space_num;//代表总空格个数
            if (per_space_num == 0) {
                while (per_space_all > 0) {
                    sb.append(' ');
                    per_space_all--;
                }
                result.add(sb.toString());
                continue;
            }
            //System.out.println(per_space_all + "   " + per_space_num+"   "+count);
            if(count != words.length - 1) {
                for (int j = 1; j <= per_space_num; j++) {
                    //添加通用空格个数
                    int temp_count = per_space_all / per_space_num;
                    while (temp_count > 0) {
                        sb.append(' ');
                        temp_count--;
                    }
                    //添加不均匀空格个数
                    if (j <= per_space_all % per_space_num) sb.append(' ');
                    sb.append(words[i + j]);
                }
            }else{
                //为最后一行则左对齐
                for (int j = 1; j <= per_space_num; j++) {
                    sb.append(' ');
                    sb.append(words[i + j]);
                }
                //补充最后的空格
                for (int j = sb.length(); j < maxWidth; j++) {
                    sb.append(' ');
                }
            }
            i = count;
            result.add(sb.toString());
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] arr = new String[]{"Science","is","what","we","understand","well","enough","to","explain", "to","a","computer.","Art","is","everything","else","we","do"};
        List<String> result = s.fullJustify(arr, 20);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}

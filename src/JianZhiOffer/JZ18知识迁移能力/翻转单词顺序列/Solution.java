package JianZhiOffer.JZ18知识迁移能力.翻转单词顺序列;

public class Solution {
    public String ReverseSentence(String str) {
        if (str == null || str.length() == 0) return str;
        String result = "";
        int index = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                result = " " + str.substring(index, i) + result;
                index = i + 1;
            }
        }
        result = " " + str.substring(index) + result;
        result = result.substring(1);
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.ReverseSentence("student. a am I"));
    }
}

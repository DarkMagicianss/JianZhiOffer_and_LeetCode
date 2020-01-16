package JianZhiOffer.JZ18知识迁移能力.左旋转字符串;

public class Solution {
    public String LeftRotateString(String str, int n) {
        if(str == null || str.length() == 0 || n == 0)return str;
        //其实还可以考虑若n超过str的长度的时候 进行取余操作
        String substr1 = str.substring(0, n);
        String substr2 = str.substring(n, str.length());
        return substr2 + substr1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "abcXYZdef";
        System.out.println(s.LeftRotateString(str, 3));
    }
}

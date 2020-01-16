package LeetCode.数字.二进制求和;

public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        char[] arr1 = a.toCharArray();
        char[] arr2 = b.toCharArray();
        int add = 0;
        int i = arr1.length - 1;
        int j = arr2.length - 1;
        while (i != -1 && j != -1) {
            int temp = arr1[i] - '0' + arr2[j] - '0' + add;
            //System.out.println(temp+"    "+add);
            sb.append((char) (temp % 2 + '0'));
            add = temp / 2;
            i--;
            j--;
        }
        while (i != -1) {
            int temp = arr1[i] - '0' + add;
            sb.append((char) (temp % 2 + '0'));
            add = temp / 2;
            i--;
        }
        while (j != -1) {
            int temp = arr2[j] - '0' + add;
            sb.append((char) (temp % 2 + '0'));
            add = temp / 2;
            j--;
        }
        if (add == 1) sb.append('1');
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.addBinary("1010", "1011"));
    }
}

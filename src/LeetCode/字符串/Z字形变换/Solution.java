package LeetCode.字符串.Z字形变换;

//经过分析可得出来
//每一行的奇数间隔为2(n-1-i)偶数间隔为(2i)！！！找到规律！！！
//其中n为总行数,i为当前行数(从0到n-1行)
//第0行有偶数间隔 不过为0
//到n-1行时有奇数间隔 不过为0
public class Solution {
    public static String convert(String s, int numRows) {
        if (numRows == 1) return s;
        byte[] chars = s.getBytes();
        boolean odd_flag = true;//用于奇偶翻转
        int index = 0;//用于表明现在的位置
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {//一共numRows行
            odd_flag = true;//从奇数间隔开始排列
            index = i;//从当前i行来计算后续的排列位置
            int odd_add = 2 * (numRows - 1 - i);//奇数间隔
            int even_add = 2 * i;//偶数间隔
            while (index < s.length()) {//不超出最大范围就继续
                if (odd_flag == true && odd_add != 0) {
                    sb.append((char) chars[index]);
                    index += odd_add;
                } else if (even_add != 0) {
                    sb.append((char) chars[index]);
                    index += even_add;
                }
                odd_flag = !odd_flag;
            }
            //System.out.println(sb.toString());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "LEETCODEISHIRING";
        String result = s.convert(str, 3);
        System.out.println(result);
    }
}


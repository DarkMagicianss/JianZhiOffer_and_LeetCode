package LeetCode.数字.整数_罗马数字_相互转换;

public class Solution2 {
    public int romanToInt(String s) {
        final char[] char_set = new char[]{'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        final int[] int_n_set = new int[]{1, 5, 10, 50, 100, 500, 1000};
        char[] arr = s.toCharArray();
        int length = s.length();
        int index = 0;
        int result = 0;
        //计算千位
        while (index < length && arr[index] == char_set[6]) {
            result += int_n_set[6];
            index++;
        }
        for (int i = 2; i >= 0 && index < length; i--) {
            int now_char = 2 * i;
            int next_char = 2 * i + 1;
            int next_next_char = 2 * i + 2;
            if (arr[index] == char_set[now_char] && index + 1 < length && arr[index + 1] == char_set[next_char]) {//判断4
                result += (int_n_set[next_char] - int_n_set[now_char]);
                index += 2;
                //System.out.println("small"+index);
            } else if (arr[index] == char_set[now_char] && index + 1 < length && arr[index + 1] == char_set[next_next_char]) {//判断9
                result += (int_n_set[next_next_char] - int_n_set[now_char]);
                index += 2;
                //System.out.println("big"+index);
            } else {
                //判断其他数字
                if (arr[index] == char_set[next_char]) {
                    result += int_n_set[next_char];
                    index++;
                    //System.out.println("5...."+index);
                }
                while (index < length && arr[index] == char_set[now_char]) {
                    result += int_n_set[now_char];
                    index++;
                    //System.out.println(index);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        int result = s.romanToInt("MCMXCIV");
        System.out.println(result);
    }
}

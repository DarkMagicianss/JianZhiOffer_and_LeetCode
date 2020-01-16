package LeetCode.数字.整数_罗马数字_相互转换;


public class Solution1 {
    public String intToRoman(int num) {
        //输入在0-3999以内
        String[] result = new String[]{"","","",""};
        final String[] char_set = new String[]{"I", "V", "X", "L", "C", "D", "M"};
        final String[] set_4_9 = new String[]{"IV", "IX", "XL", "XC", "CD", "CM"};
        int w_index = 0;//0表示个位 1表示十位 2表示百位 3表示千位
        while (num != 0) {
            int temp = num % 10;
            num = num / 10;
            if (temp == 4) {
                //对应的位置进行赋值
                result[3 - w_index] = set_4_9[2 * w_index];
            } else if (temp == 9) {
                //对应的位置进行赋值
                result[3 - w_index] = set_4_9[2 * w_index + 1];
            } else {
                if (temp >= 5) {
                    result[3 - w_index] = char_set[2 * w_index + 1];
                    temp -= 5;//减去这个已经添加的5
                }
                //将剩余的1，2，3添加进去
                while (temp > 0) {
                    result[3 - w_index] += char_set[2 * w_index];
                    temp--;
                }
            }
            w_index++;
        }
        return result[0] + result[1] + result[2] + result[3];
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        String result = s.intToRoman(1994);
        System.out.println(result);
    }
}

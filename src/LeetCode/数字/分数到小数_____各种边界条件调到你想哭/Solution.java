package LeetCode.数字.分数到小数_____各种边界条件调到你想哭;


import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        if(denominator == 1)return ""+numerator;
        int fu_flag = 0;
        long fenzi = numerator;
        long fenmu = denominator;
        if (fenzi < 0 && fenmu > 0) {
            fu_flag = 1;
            fenzi = -fenzi;
        }
        if (fenzi > 0 && fenmu < 0) {
            fu_flag = 1;
            fenmu = -fenmu;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(fenzi / fenmu);
        long remain = fenzi % fenmu;
        if (remain == 0) return sb.toString();
        sb.append(".");
        HashMap<Long, Integer> map = new HashMap<>();
        ArrayList<Long> list = new ArrayList<>();
        int index = 0;
        int chongfu_flag = 0;
        while (remain != 0) {
            long temp = (10 * remain) / fenmu;
            list.add(temp);
            if (map.containsKey(remain)) {//找到重复小数位置
                for (int i = 0; i < map.get(remain); i++) {
                    sb.append(list.get(i));
                }
                sb.append("(");
                for (int i = map.get(remain); i < index; i++) {
                    sb.append(list.get(i));
                }
                sb.append(")");
                chongfu_flag = 1;
                break;
            } else {
                //map里面存的应该是分子的数值 因为一旦遍历之后 分子数值一样 则必定重复了
                map.put(remain, index);
            }
            remain = (10 * remain) % fenmu;
            index++;
        }
        if (chongfu_flag == 0) {
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i));
            }
        }
        if (fu_flag == 1) return "-" + sb.toString();
        else return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.fractionToDecimal(-22, -2));
        System.out.println(s.fractionToDecimal(1, 4));
        System.out.println(s.fractionToDecimal(1, 8));
        System.out.println(s.fractionToDecimal(2, 1));
        System.out.println(s.fractionToDecimal(2, 3));
        System.out.println(s.fractionToDecimal(3, 7));
        System.out.println(s.fractionToDecimal(1, 333));
        System.out.println(s.fractionToDecimal(500, 10));
        System.out.println(s.fractionToDecimal(50, 9));
        System.out.println(s.fractionToDecimal(5, 6));
        System.out.println(s.fractionToDecimal(-50, 8));
    }
}


package JianZhiOffer.JZDiff.丑数_____想到对应思路了可是呢我去;

import java.util.ArrayList;

public class Solution {
    ArrayList<Integer> list = new ArrayList<>();
    int num2_index = 0;
    int num3_index = 0;
    int num5_index = 0;
    int count = 1;
    public int GetUglyNumber_Solution(int index) {
        if(index < list.size())return list.get(index - 1);
        if (index < 1) return 0;
        if (index == 1) return 1;
        if(list.isEmpty())list.add(1);
        while (count < index) {
            int num2 = list.get(num2_index) * 2;
            int num3 = list.get(num3_index) * 3;
            int num5 = list.get(num5_index) * 5;
            int little = Math.min(num2,Math.min(num3,num5));
            list.add(little);
            if(little == num2){
                num2_index++;
            }
            if(little == num3){
                num3_index++;
            }
            if(little == num5){
                num5_index++;
            }
            count++;
        }
        return list.get(count - 1);
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int result = s.GetUglyNumber_Solution(10);
        System.out.println(result);
    }
}

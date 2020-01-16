package JianZhiOffer.JZ19抽象建模能力.扑克牌顺子;

import java.util.Arrays;

public class Solution {
    //思路：用数组记录五张扑克牌，将数组调整为有序的，若0出现的次数>=顺子的差值，即为顺子。
    public boolean isContinuous(int[] numbers) {
        if (numbers.length != 5) return false;
        Arrays.sort(numbers);
        int any_num = 0;
        int need_any_num = 0;
        for (int i = 0; i < numbers.length - 1; i++) {
            if(numbers[i] == 0){
                any_num++;
                continue;
            }
            if(numbers[i] != numbers[i+1]){//两个数字不同 计算中间需要插入的牌数
                need_any_num += (numbers[i+1] - numbers[i] - 1);
            }else{//一旦出现牌重复 则不可能组成顺子
                return false;
            }
        }
        return need_any_num <= any_num;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = new int[]{1,2,3,4,0};
        System.out.println(s.isContinuous(arr));
    }
}

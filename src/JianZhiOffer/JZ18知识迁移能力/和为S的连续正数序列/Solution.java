package JianZhiOffer.JZ18知识迁移能力.和为S的连续正数序列;


import java.util.ArrayList;

public class Solution {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        //找到规律 不知道全不全
        //这个数要是除以偶数 那么必须余下这个偶数的一半
        //例如10除以4余2则 可以在结果范围内 1(-1) 2(0) 3(1) 4(2)
        //这个数要是除以奇数 那么必须要整除
        //除到这个数的二次方根为止
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (sum <= 2) return result;
        for (int i = sum/2 + 1; i >= 2; i--) {
            int remain = sum % i;
            if (i % 2 == 0) {//当前i为偶数
                if (remain == (i / 2)) {
                    int key = sum/i;
                    ArrayList<Integer> temp = new ArrayList<>();
                    if(key - remain + 1 <= 0)continue;
                    for (int j = key - remain + 1; j <= key + remain; j++) {
                        temp.add(j);
                    }
                    result.add(temp);
                    System.out.println(i+"   "+temp);
                }
            } else {//当前i为奇数
                if (remain % i == 0) {
                    int key = sum/i;
                    ArrayList<Integer> temp = new ArrayList<>();
                    if(key - i/2 <= 0 || i == 1)continue;
                    for (int j = key - i/2; j <= key + i/2; j++) {
                        temp.add(j);
                    }
                    result.add(temp);
                    System.out.println(i+"   "+temp);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ArrayList<ArrayList<Integer>> result = s.FindContinuousSequence(99);
        System.out.println(result);
    }
}

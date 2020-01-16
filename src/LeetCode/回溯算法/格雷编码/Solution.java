package LeetCode.回溯算法.格雷编码;


import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> grayCode(int n) {
        /** 这或许就是大佬吧
         关键是搞清楚格雷编码的生成过程, G(i) = i ^ (i/2);
         如 n = 3:
         G(0) = 000,
         G(1) = 1 ^ 0 = 001 ^ 000 = 001
         G(2) = 2 ^ 1 = 010 ^ 001 = 011
         G(3) = 3 ^ 1 = 011 ^ 001 = 010
         G(4) = 4 ^ 2 = 100 ^ 010 = 110
         G(5) = 5 ^ 2 = 101 ^ 010 = 111
         G(6) = 6 ^ 3 = 110 ^ 011 = 101
         G(7) = 7 ^ 3 = 111 ^ 011 = 100
         **/
        List<Integer> ret = new ArrayList<>();
        for(int i = 0; i < 1<<n; ++i)
            ret.add(i ^ i>>1);
        return ret;
//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(0);
//        if (n == 0) return list;
//        list.add(1);
//        if (n == 1) return list;
//        int step = 1;
//        int base = 1;
//        while (step < n) {
//            int len = list.size();
//            base = base << 1;
//            for (int i = len - 1; i >= 0; i--) {
//                list.add(list.get(i) + base);
//            }
//            step++;
//        }
//        return list;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.grayCode(4).toString());
    }
}


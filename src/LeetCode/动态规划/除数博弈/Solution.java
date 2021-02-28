package com.xiaomi.ad.osctask.ad;

/**
 * @author LinHu
 * @version 2021/2/27
 */
public class Solution {
    public boolean divisorGame(int N) {
        return N % 2 == 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.divisorGame(1));
        System.out.println(s.divisorGame(2));
        System.out.println(s.divisorGame(3));
        System.out.println(s.divisorGame(4));
        System.out.println(s.divisorGame(5));
        System.out.println(s.divisorGame(6));
        System.out.println(s.divisorGame(7));
        System.out.println(s.divisorGame(8));
        System.out.println(s.divisorGame(9));
    }
}

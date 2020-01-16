package JianZhiOffer.JZ19抽象建模能力.孩子们的游戏_圆圈中最后剩下的数_;

import java.util.LinkedList;

public class Solution {
    public int LastRemaining_Solution(int n, int m) {
        if (m == 0) return -1;
        if (m == 1) return n - 1;
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = 0;
        while (n > 1) {
            index = (index + m - 1) % n;
            list.remove(index);
            n--;
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.LastRemaining_Solution(6, 8));
    }
}

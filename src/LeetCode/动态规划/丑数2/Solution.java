import java.util.ArrayList;
import java.util.List;

/**
 * @author LinHu
 * @version 2021/3/27
 */
public class Solution {
    int[] uglys = new int[1690];
    int index = 0;
    int index_2 = 0;
    int index_3 = 0;
    int index_5 = 0;
    public int nthUglyNumber(int n) {
        if (index == 0) {
            uglys[0] = 1;
            index = 1;
        }
        if (n <= index) {
            return uglys[n - 1];
        }
        for (; index <= 1690; index++) {
            int min = Math.min(Math.min(2 * uglys[index_2], 3 * uglys[index_3]), 5 * uglys[index_5]);
            uglys[index] = min;
            if (min == 2 * uglys[index_2]) index_2++;
            if (min == 3 * uglys[index_3]) index_3++;
            if (min == 5 * uglys[index_5]) index_5++;
            if (index == n - 1) {
                index++;
                return uglys[n - 1];
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        String str1 = "leetcode";
        String str2 = "applepenapple";
        String str3 = "catsandog";


        System.out.println(s.nthUglyNumber(10));
        System.out.println(s.nthUglyNumber(20));
        System.out.println(s.nthUglyNumber(30));
    }
}

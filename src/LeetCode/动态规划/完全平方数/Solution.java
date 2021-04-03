
/**
 * @author LinHu
 * @version 2021/4/3
 */
public class Solution {
    public static int[] dp = new int[10000 + 1];
    public static int lastIndex = 0;
    static {
        initDp();
    }
    public int numSquares(int n) {
        return dp[n];
    }

    public static void initDp() {
        dp[0] = 0;
        dp[1] = 1;
        lastIndex = 1;
        for (; lastIndex < 10000; lastIndex++) {
            int nextNum = lastIndex + 1;
            int maxSquareNum = (int) Math.sqrt(nextNum);
            int minCount = nextNum;
            for (int i = maxSquareNum; i > 1 ; i--) {
                int count = 1 + dp[nextNum - i * i];
                minCount = Math.min(minCount, count);
            }
            dp[nextNum] = minCount;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numSquares(16));
        System.out.println(s.numSquares(15));
        System.out.println(s.numSquares(10));

    }
}

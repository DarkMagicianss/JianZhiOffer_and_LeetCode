package LeetCode.动态规划.不同的二叉搜索树_____很巧妙;

public class Solution {
    public int numTrees(int n) {
        if (n <= 1) return n;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        //关键问题是忽略了这个搜索树 是一个排序的树 这个影响思路
        //我们的目标是个数为n的时候的二叉树的种类
        //因此应该想到这个值由1，2，3，，，，n分别为根节点的时候所构成的二叉树的和
        //而以i节根节点的二叉树的种类 则由1----i-1为左子树和i+1----n为右子树想乘构成的
        for (int i = 3; i <= n; i++) {
            // 由于存在重复计算 将重复计算部分只算一次
            for (int j = 1 ; j <= i/2 ; j++) {
                dp[i] += dp[i - j] * dp[j - 1];
            }
            dp[i] = 2 * dp[i];
            // 因为提取了重复计算逻辑 因此需要单独对n为奇数的情况考虑一下
            if (i %2 == 1) {
                dp[i] += dp[i/2] * dp[i/2];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numTrees(4));
    }
}

package LeetCode.动态规划.不同的二叉搜索树_____很巧妙;

public class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        if(n == 1)return 1;
        //我们的目标是个数为n的时候的二叉树的种类
        //因此应该想到这个值由1，2，3，，，，n分别为根节点的时候所构成的二叉树的和
        //而以i节根节点的二叉树的种类 则由1----i-1为左子树和i+1----n为右子树构成的
        for (int i = 2; i <= n; i++) {
            int temp = 0;
            //对于每个i 其dp[i]为分别以1，2，3，，，i为根节点 左子树为1--k 右子树为k--i 相乘得到
            for (int j = 1; j <= i; j++) {
                temp += (dp[j - 1] * dp[i - j]);
            }
            dp[i] = temp;
            //System.out.println(dp[i]);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numTrees(4));
    }
}

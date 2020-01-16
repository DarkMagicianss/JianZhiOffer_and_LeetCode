package LeetCode.数组.跳跃游戏2;

public class Solution {
    public int jump(int[] nums) {
        //不使用LinkedList 速度提升一倍？？？一脸闷逼？？？
        int len = nums.length;
        if (nums.length <= 1) return 0;
        int[] dp = new int[nums.length];
        int max_index = 0;
        for (int i = 0; i < len; i++) {
            if (i + nums[i] <= max_index) {//index加step小于之前的操作 则进行下一个判断
                continue;
            }
            if (i + nums[i] >= nums.length - 1) return (dp[i] + 1);
            for (int j = i + nums[i]; j > max_index; j--) {
                if (j < nums.length) {
                    dp[j] = dp[i] + 1;
                }
            }
            //更新最大index
            max_index = i + nums[i];
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = new int[]{5, 8, 1, 8, 9, 8, 7, 1, 7, 5, 8, 6, 5, 4, 7, 3, 9, 9, 0, 6, 6, 3, 4, 8, 0, 5, 8, 9, 5, 3, 7, 2, 1, 8, 2, 3, 8, 9, 4, 7, 6, 2, 5, 2, 8, 2, 7, 9, 3, 7, 6, 9, 2, 0, 8, 2, 7, 8, 4, 4, 1, 1, 6, 4, 1, 0, 7, 2, 0, 3, 9, 8, 7, 7, 0, 6, 9, 9, 7, 3, 6, 3, 4, 8, 6, 4, 3, 3, 2, 7, 8, 5, 8, 6, 0
        };
        System.out.println(s.jump(arr));
    }
}

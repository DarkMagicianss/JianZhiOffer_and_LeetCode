
/**
 * @author LinHu
 * @version 2021/4/3
 */
public class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = 1, n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[len] = nums[0];
        for (int i = 1; i < n; ++i) {
            if (nums[i] > dp[len]) {
                len++;
                dp[len] = nums[i];
            } else {
                // 这里必须要全部更新长度为i的元素。保证本身的状态是最长子序列的末尾元素的最小值。
                // 当然dp[]数组里的元素可能并不是和原数据元素相同，
                // 但是若比dp[len]大，则肯定之前存在过len长的严格递增的子序列。
                int l = 1, r = len, pos = 0;
                // 如果找不到说明所有的数都比 nums[i] 大，此时要更新 d[1]，所以这里将 pos 设为 0
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if (dp[mid] < nums[i]) {
                        pos = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                dp[pos + 1] = nums[i];
            }
        }
        return len;
    }
//    public int lengthOfLIS(int[] nums) {
//        if (nums == null || nums.length == 0)return 0;
//        int[] dp = new int[nums.length];
//        int max_value = 1;
//        dp[0] = 1;
//        for (int i = 1; i < nums.length; i++) {
//            dp[i] = 1;
//            for (int j = i - 1; j >=0 ; j--) {
//                if (nums[i] > nums[j]) {
//                    dp[i] = Math.max(dp[i], dp[j] + 1);
//                }
//            }
//            max_value = Math.max(dp[i], max_value);
//        }
//        return max_value;
//    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
        System.out.println(s.lengthOfLIS(new int[]{0,1,0,3,2,3}));
        System.out.println(s.lengthOfLIS(new int[]{7,7,7,7,7,7,7}));

    }
}

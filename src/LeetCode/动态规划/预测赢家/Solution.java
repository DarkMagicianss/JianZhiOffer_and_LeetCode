package Solution;

/**
 * text.
 *
 * @author LinHu
 * @version 2021-08-08 18:56
 */
public class Solution {
    public boolean PredictTheWinner(int[] nums) {
        if (nums == null || nums.length <= 2) return true;
        return subPredictTheWinner(nums, 0, nums.length - 1, true, 0, 0);
    }

    public boolean subPredictTheWinner(int[] nums, int start, int end, boolean isFirst, int firstSum, int secondSum) {
        // 表示当前情况下先拿的是否能稳赢, 明确函数定义很重要。唉，逻辑真绕。
        if (start == end) return isFirst ? firstSum + nums[start] >= secondSum : secondSum + nums[start] > firstSum;
        if (isFirst) {
            return !subPredictTheWinner(nums, start + 1, end, !isFirst, firstSum + nums[start], secondSum) ||
                    !subPredictTheWinner(nums, start, end - 1, !isFirst, firstSum + nums[end], secondSum);
        } else {
            return !subPredictTheWinner(nums, start + 1, end, !isFirst, firstSum, secondSum + nums[start]) ||
                    !subPredictTheWinner(nums, start, end - 1, !isFirst, firstSum, secondSum + nums[end]);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.PredictTheWinner(new int[]{1,5,2}));
        System.out.println(s.PredictTheWinner(new int[]{1,5,233,7}));
        System.out.println(s.PredictTheWinner(new int[]{1,1,1,1}));
    }
}

package solution;

import java.util.Arrays;
import java.util.Collections;

/**
 * 测试.
 *
 * @author LinHu
 * @version 2021-07-31 11:18
 */
public class Solution {
    public boolean makesquare(int[] matchsticks) {
        if (matchsticks == null || matchsticks.length < 4) return false;
        long allSum = 0L;
        int targetLine;
        for (int i = 0; i < matchsticks.length; i++) {
            allSum += matchsticks[i];
        }
        if (allSum % 4 != 0) return false;
        targetLine = (int) (allSum / 4);
        Integer[] nums = new Integer[matchsticks.length];
        for (int i = 0; i < matchsticks.length; i++) {
            if (matchsticks[i] > targetLine) return false;
            nums[i] = matchsticks[i];
        }
        Arrays.sort(nums, Collections.reverseOrder());
        return subMakeSquare(nums,0,  targetLine, new int[4]);
    }

    private boolean subMakeSquare(Integer[] matchsticks, int index, int targetLine, int[] size) {
        if (matchsticks.length == index) {
            if (size[0] == size[1] && size[1] == size[2] && size[2] == size[3]){
                return true;
            }
        }
        for (int i = 0; i < 4; i++) {
            if (index == 0 && i > 0) return false;
            if (size[i] + matchsticks[index] > targetLine) {
                // 超过了平均值
                continue;
            }
            size[i] += matchsticks[index];
            if(subMakeSquare(matchsticks, index + 1, targetLine, size)){
                return true;
            }
            size[i] -= matchsticks[index];
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.makesquare(new int[]{1,1,2,2,2}));
        System.out.println(s.makesquare(new int[]{3,3,3,3,4}));
    }
}

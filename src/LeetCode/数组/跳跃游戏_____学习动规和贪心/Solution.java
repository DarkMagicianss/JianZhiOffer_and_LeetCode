package LeetCode.数组.跳跃游戏_____学习动规和贪心;

public class Solution {
    //    public boolean canJump(int[] nums) {
//        if (nums == null || nums.length == 0) return false;
//        if (nums[0] >= nums.length - 1 || nums.length == 1) return true;
//        boolean[] can_here = new boolean[nums.length];
//        int max_index = 0;
//        can_here[0] = true;
//        for (int i = 0; i < nums.length - 1; i++) {
//            if (can_here[i] == true) {
//                if (i + nums[i] <= max_index) continue;
//                for (int j = i + nums[i]; j >= max_index; j--) {
//                    //System.out.println(i+"    "+j);
//                    if (j >= nums.length - 1) return true;//达到则直接返回true
//                    can_here[j] = true;
//                }
//                max_index = i + nums[i];
//            }
//        }
//        return false;
//    }
    //天秀啊！！！
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        if (nums[0] >= nums.length - 1 || nums.length == 1) return true;
        int left_ok_index = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= left_ok_index) {
                left_ok_index = i;
            }
        }
        return left_ok_index == 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = new int[]{8, 2, 4, 4, 4, 9, 5, 2, 5, 8, 8, 0, 8, 6, 9, 1, 1, 6, 3, 5, 1, 2, 6, 6, 0, 4, 8, 6, 0, 3, 2, 8, 7, 6, 5, 1, 7, 0, 3, 4, 8, 3, 5, 9, 0, 4, 0, 1, 0, 5, 9, 2, 0, 7, 0, 2, 1, 0, 8, 2, 5, 1, 2, 3, 9, 7, 4, 7, 0, 0, 1, 8, 5, 6, 7, 5, 1, 9, 9, 3, 5, 0, 7, 5};

        System.out.println(s.canJump(arr));
    }
}

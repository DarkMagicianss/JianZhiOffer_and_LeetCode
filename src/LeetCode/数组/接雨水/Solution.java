package LeetCode.数组.接雨水;

public class Solution {
    public int trap(int[] height) {
        int len = height.length;
        if (height == null || len <= 1) return 0;
        int max_height = 0;
        int max_index = 0;
        int result = 0;
        for (int i = 0; i < len; i++) {
            if (height[i] > max_height) {
                max_height = height[i];
                max_index = i;
            }
        }
        //System.out.println("maxt_height:"+max_height);
        //统计左边到最高点的雨点数目
        int temp_left_max = 0;
        for (int i = 0; i < max_index; i++) {
            if (height[i] > temp_left_max) {
                temp_left_max = height[i];
            } else if (height[i] < temp_left_max) {
                result += (temp_left_max - height[i]);
            }
        }
        //统计右边到最高点的雨点数目
        int temp_right_max = 0;
        for (int i = len - 1; i > max_index; i--) {
            if (height[i] > temp_right_max) {
                temp_right_max = height[i];
            } else if (height[i] < temp_right_max) {
                result += (temp_right_max - height[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(s.trap(arr));
    }
}

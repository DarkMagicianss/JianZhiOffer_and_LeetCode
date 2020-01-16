package LeetCode.数组.盛最多水的容器_____结合题目特点;

public class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max_area = 0;
        while (left <= right) {
            max_area = Math.max(max_area, (right - left) * Math.min(height[left], height[right]));
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return max_area;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        int result = s.maxArea(height);
        System.out.println(result);
    }
}

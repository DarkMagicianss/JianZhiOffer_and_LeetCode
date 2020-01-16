package LeetCode.数字.两数之和2_输入有序数组;


public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length <= 1) return null;
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] > target) {
                right--;
            } else if (numbers[left] + numbers[right] < target) {
                left++;
            } else {
                return new int[]{left + 1, right + 1};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = s.twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(arr[0] + "  " + arr[1]);
    }
}


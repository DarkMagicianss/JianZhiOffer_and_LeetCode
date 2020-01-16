package LeetCode.数组.旋转数组;


import java.util.Arrays;

public class Solution {
    public void rotate(int[] nums, int k) {
        //1.一步步向右移 k对数组大小取余 O(1)
        //2.将最后k个移动到k长度的数组 然后将原数组原地移动 再复制回去 O(k)
        //3.这个方法基于这个事实：当我们旋转数组 k 次， k\%nk%n 个尾部元素会被移动到头部，剩下的元素会被向后移动。
        //在这个方法中，我们首先将所有元素反转。然后反转前 k 个元素，再反转后面 n-kn−k 个元素，就能得到想要的结果。
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
        return;
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        s.rotate(arr, 3);
        System.out.println(Arrays.toString(arr));
    }
}


package LeetCode.数组.颜色分类;

import java.util.Arrays;

public class Solution {
    public void sortColors(int[] nums) {
        if (nums.length <= 1) return;
        int index_0 = 0;
        int index_2 = nums.length - 1;
        int step = 0;
        while (step <= index_2) {
            //System.out.println(step + "   " + index_0 + "   " + index_2 + "  " + Arrays.toString(nums));
            if (nums[step] == 0 && step != index_0) {
                swap(nums, step, index_0);
                index_0++;
            } else if (nums[step] == 2) {
                swap(nums, step, index_2);
                index_2--;
            } else {//表明为1
                step++;
            }
        }
        return;
    }

    public void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = new int[]{0,0,1,2,0,2,1,2,1,1,1,0,0,0,2,1,1};
        s.sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }
}


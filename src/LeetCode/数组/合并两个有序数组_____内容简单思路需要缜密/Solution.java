package LeetCode.数组.合并两个有序数组_____内容简单思路需要缜密;


import java.util.Arrays;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        int end_index = m + n - 1;
        int n1_in = m - 1;
        int n2_in = n - 1;
        for (; n2_in >= 0 && n1_in >= 0; n2_in--) {
            if (nums2[n2_in] > nums1[n1_in]) {
                nums1[end_index] = nums2[n2_in];
                end_index--;
            } else {
                //寻找插入的位置
                while (n1_in >= 0 && nums2[n2_in] < nums1[n1_in]) {
                    nums1[end_index] = nums1[n1_in];
                    end_index--;
                    n1_in--;
                }
                //当n1_in走到尽头的时候 n2_in并没有处理
                if (n1_in == -1) n2_in++;
                else {
                    nums1[end_index] = nums2[n2_in];
                    end_index--;
                }
            }
        }
        //当num1走到头进行补偿
        for (int i = n2_in; n1_in == -1 && i >= 0; i--) {
            nums1[end_index] = nums2[i];
            end_index--;
        }
        return;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr1 = new int[]{1,2,3,4,5,0,0,0};
        int[] arr2 = new int[]{2,5,6};
        s.merge(arr1, 3, arr2, 3);
        System.out.println(Arrays.toString(arr1));
    }
}

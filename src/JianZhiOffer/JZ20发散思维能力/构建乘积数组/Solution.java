package JianZhiOffer.JZ20发散思维能力.构建乘积数组;

import java.util.Arrays;

public class Solution {
    public int[] multiply(int[] A) {
        int len = A.length;
        if (A == null || len == 0) return null;
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = A[0];
        right[len - 1] = A[len - 1];
        for (int i = 1; i < len - 1; i++) {
            left[i] = left[i - 1] * A[i];
            right[len - 1 - i] = right[len - i] * A[len - 1 - i];
        }
        int[] result = new int[len];
        result[0] = right[1];
        result[len - 1] = left[len - 2];
        for (int i = 1; i < len - 1; i++) {
            result[i] = left[i - 1] * right[i + 1];
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = new int[]{1,2,3,4,5};
        System.out.println(Arrays.toString(s.multiply(arr)));

    }
}

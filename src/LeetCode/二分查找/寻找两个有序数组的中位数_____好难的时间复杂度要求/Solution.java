package LeetCode.二分查找.寻找两个有序数组的中位数_____好难的时间复杂度要求;


public class Solution {
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { //this is to make ensure m<=n
            int[] temp = A;
            A = B;
            B = temp;
            int tmp = m;
            m = n;
            n = tmp;
        }
        //进行二分搜索树查找
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;//这里j的定义是保证leftpart和rightpart相等或左比右多一个
            if (i < iMax && j > 0 && B[j - 1] > A[i]) {// i is too small
                iMin = i + 1;
            } else if (i > iMin && A[i - 1] > B[j]) { // i is too big
                iMax = i - 1;
            } else { // i is perfect 已经找到目标值了！！！
                int maxLeft = 0;
                //为保证Math.max(A[i - 1], B[j - 1])数组不越界
                if (i == 0) {
                    maxLeft = B[j - 1];
                } else if (j == 0) {
                    maxLeft = A[i - 1];
                } else {
                    maxLeft = Math.max(A[i - 1], B[j - 1]);
                }
                if ((m + n) % 2 == 1) {//若总个数为奇数 则直接返回
                    return maxLeft;
                }
                //若总个数为偶数 则继续计算
                int minRight = 0;
                //为保证Math.max(A[i], B[j])数组不越界
                if (i == m) {
                    minRight = B[j];
                } else if (j == n) {
                    minRight = A[i];
                } else {
                    minRight = Math.min(B[j], A[i]);
                }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] num1 = new int[]{3};
        int[] num2 = new int[]{-2, -1};
        System.out.println(s.findMedianSortedArrays(num1, num2));
    }
}

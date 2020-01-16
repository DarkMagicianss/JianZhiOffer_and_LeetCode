package LeetCode.二分查找.搜索二维矩阵;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 )return false;
        if(matrix[0].length == 0)return false;
        int start = 0;
        int end = matrix.length - 1;
        int mid = 0;
        while (start <= end) {
            mid = (start + end) >> 1;
            if (matrix[mid][0] > target) {
                end = mid - 1;
            } else if (matrix[mid][0] < target) {
                start = mid + 1;
            } else {
                return true;
            }
        }
        if(start == 0)return false;
        else start--;
        //System.out.println(start);
        int target_line = start;
        start = 0;
        end = matrix[0].length - 1;
        mid = 0;
        while (start <= end) {
            mid = (start + end) >> 1;
            if (matrix[target_line][mid] > target) {
                end = mid - 1;
            } else if (matrix[target_line][mid] < target) {
                start = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] arr = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        System.out.println(s.searchMatrix(arr, 13));
    }
}

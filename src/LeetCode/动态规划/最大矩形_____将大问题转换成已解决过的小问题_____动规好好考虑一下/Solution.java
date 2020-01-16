package LeetCode.动态规划.最大矩形_____将大问题转换成已解决过的小问题_____动规好好考虑一下;

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        //复用柱状图中的最大矩阵案例
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int[] dp = new int[matrix[0].length];
        int max_area = 0;
        //为了统计一个阵列中1所描述的矩阵的最大面积
        //分别统计每一行的上述所有柱状图中的最大矩阵面积 由dp数组记录当前行每一列的柱状图
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                //累计统计当前行的各个列的累计高度 若当前为0则为0
                dp[j] = matrix[i][j] == '1' ? dp[j] + 1 : 0;
            }
            max_area = Math.max(max_area,sub_largestRectangleArea(dp,0,dp.length - 1));
        }
        return max_area;
    }
    public int sub_largestRectangleArea(int[] heights, int start, int end) {
        //来自柱状图中的最大矩阵那道题
        if (start == end) return heights[start];
        int min_index = start;
        boolean isSort = true;
        for (int i = start + 1; i <= end; i++) {
            if (heights[i - 1] > heights[i]) isSort = false;
            if (heights[i] < heights[min_index]) {
                min_index = i;
            }
        }
        //就加了这个速度上去了 原因是避免了 低效率的分治
        //成阶梯状上升 每个点的最大面积为该点高 以及该点到末端的距离为宽
        if (isSort) {
            int max = 0;
            for (int i = start; i <= end; i++)
                max = Math.max(max, heights[i] * (end - i + 1));
            return max;
        }
        int result = heights[min_index] * (end - start + 1);
        if (min_index > start)
            result = Math.max(result, sub_largestRectangleArea(heights, start, min_index - 1));
        if (min_index < end)
            result = Math.max(result, sub_largestRectangleArea(heights, min_index + 1, end));
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] arr = new char[][]{{'0', '0', '0', '1', '0', '0'},
                {'0', '1', '1', '1', '0', '1'},
                {'0', '1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '1'},
                {'0', '1', '1', '1', '1', '1'}};
        System.out.println(s.maximalRectangle(arr));
    }
}

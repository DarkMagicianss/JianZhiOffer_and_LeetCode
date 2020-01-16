package LeetCode.数组.柱状图中最大的矩形_____同样是分治_不如大佬;


public class Solution {
    //分治办法 暴力1号 经过高手优化
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) return 0;
        if (heights.length == 1) return heights[0];
        return sub_largestRectangleArea(heights, 0, heights.length - 1);
    }

    public int sub_largestRectangleArea(int[] heights, int start, int end) {
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
        if (isSort) {//成阶梯状上升 每个点的最大面积为该点高 以及该点到末端的距离为宽
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
        int[] arr = new int[]{4,2};
        System.out.println(s.largestRectangleArea(arr));
    }
}

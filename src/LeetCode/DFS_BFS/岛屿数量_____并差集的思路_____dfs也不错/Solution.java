package LeetCode.DFS_BFS.岛屿数量_____并差集的思路_____dfs也不错;


public class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    //将所有与1相连的1全部置为0
                    sub_numIslands(grid, i, j);
                }
            }
        }
        return result;
    }

    void sub_numIslands(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        sub_numIslands(grid, i - 1, j);
        sub_numIslands(grid, i + 1, j);
        sub_numIslands(grid, i, j - 1);
        sub_numIslands(grid, i, j + 1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] arr = new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        char[][] arr1 = new char[][]{{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        char[][] arr2 = new char[][]{{'1', '0', '1', '1', '0'}};
        char[][] arr3 = new char[][]{{'1'}, {'0'}, {'1'}, {'1'}, {'0'}};
        char[][] arr4 = new char[][]{{'1'}};
        char[][] arr5 = new char[][]{{'0'}};
        System.out.println(s.numIslands(arr));
        System.out.println(s.numIslands(arr1));
        System.out.println(s.numIslands(arr2));
        System.out.println(s.numIslands(arr3));
        System.out.println(s.numIslands(arr4));
        System.out.println(s.numIslands(arr5));
    }
}

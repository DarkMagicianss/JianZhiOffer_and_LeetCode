package JianZhiOffer.JZ8回溯法.矩阵中的路径;


public class Solution {
    //再使用回溯法(尝试失败的话 返回上一步状态)写写看 感觉这里用回溯法有点像dfs
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (str == null || str.length == 0) return true;
        boolean[] flag = new boolean[matrix.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (sub_hasPath(matrix, rows, cols, i, j, str, 0, flag))
                    return true;
            }
        }
        return false;
    }
    public boolean sub_hasPath(char[] matrix, int rows, int cols, int x, int y, char[] str, int k, boolean[] flag) {
        int index = x * cols + y;
        if (x < 0 || x >= rows || y < 0 || y >= cols || flag[index] == true || str[k] != matrix[index])
            return false;
        if (k == str.length - 1)
            return true;
        flag[index] = true;
        if (sub_hasPath(matrix, rows, cols, x - 1, y, str, k + 1, flag) ||
                sub_hasPath(matrix, rows, cols, x + 1, y, str, k + 1, flag) ||
                sub_hasPath(matrix, rows, cols, x, y - 1, str, k + 1, flag) ||
                sub_hasPath(matrix, rows, cols, x, y + 1, str, k + 1, flag)) {
            return true;
        }
        flag[index] = false;
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        boolean result = s.hasPath("abcesfcsadee".toCharArray(), 3, 4, "abcb".toCharArray());
        System.out.println(result);
    }
}

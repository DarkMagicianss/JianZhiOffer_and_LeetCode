package LeetCode.数组.单词搜索;

public class Solution {
    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0) return false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (sub_exist(board, i, j, word, 0)) return true;
            }
        }
        return false;
    }

    public boolean sub_exist(char[][] board, int i, int j, String word, int index) {
        if (index == word.length()) return true;
        //一种稍稍看起来清楚一点的代码
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) return false;
        //System.out.println(index+"   "+i+"    "+j);
        char temp = board[i][j];
        board[i][j] = '*';//用*表示已经进行了查找
        if (sub_exist(board, i - 1, j, word, index + 1) ||
                sub_exist(board, i, j + 1, word, index + 1) ||
                sub_exist(board, i + 1, j, word, index + 1) ||
                sub_exist(board, i, j - 1, word, index + 1))
            return true;
        board[i][j] = temp;
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] arr = new char[][]{{'C', 'A', 'A'}, {'A', 'A', 'A'}, {'B', 'C', 'D'}};
        System.out.println(s.exist(arr, "AAB"));
    }
}

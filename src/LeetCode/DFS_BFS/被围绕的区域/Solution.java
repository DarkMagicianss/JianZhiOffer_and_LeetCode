package LeetCode.DFS_BFS.被围绕的区域;


public class Solution {
    public void solve(char[][] board) {
        if (board.length <= 1 || board[0].length <= 1) return;
        //上下边界
        for (int j = 0; j < board[0].length; j++) {
            if (board[0][j] == 'O') {
                sub_solve(board, 0, j);
            }
            if (board[board.length - 1][j] == 'O') {
                sub_solve(board, board.length - 1, j);
            }
        }
        //左右边界
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') {
                sub_solve(board, i, 0);
            }
            if (board[i][board[0].length - 1] == 'O') {
                sub_solve(board, i, board[0].length - 1);
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = board[i][j] == '-' ? 'O' : 'X';
            }
        }
        return;
    }

    public void sub_solve(char[][] board, int x, int y) {
        if (x < 0 || x > board.length - 1 || y < 0 || y > board[0].length - 1 || board[x][y] == '-') return;
        if (board[x][y] == 'X') return;
        board[x][y] = '-';
        sub_solve(board, x - 1, y);
        sub_solve(board, x + 1, y);
        sub_solve(board, x, y - 1);
        sub_solve(board, x, y + 1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] arr = new char[][]{{'X', 'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'O', 'X'}, {'X', 'X', 'O', 'O', 'X'}, {'X', 'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X', 'X'}};
        char[][] arr1 = new char[][]{{'O', 'X', 'O', 'O', 'X', 'X'}, {'O', 'X', 'X', 'X', 'O', 'X'}, {'X', 'O', 'O', 'X', 'O', 'O'}, {'X', 'O', 'X', 'X', 'X', 'X'}, {'O', 'O', 'X', 'O', 'X', 'X'}, {'X', 'X', 'O', 'O', 'O', 'O'}};
        s.solve(arr);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        s.solve(arr1);
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[0].length; j++) {
                System.out.print(arr1[i][j] + " ");
            }
            System.out.println();
        }
    }
}

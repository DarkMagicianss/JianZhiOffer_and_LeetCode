package LeetCode.数组.有效的数独;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] cols = new int[9][9];
        int[][] boxs = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int temp_num = board[i][j] - '1';//将1-9转成0-8
                    //行
                    if (rows[i][temp_num] == 1) {
                        //System.out.println("i:"+i+",temp_num"+temp_num);
                        return false;
                    }
                    else rows[i][temp_num] = 1;
                    //列
                    if (cols[j][temp_num] == 1) {
                        //System.out.println("j:"+j+",temp_num"+temp_num);
                        return false;
                    }
                    else cols[j][temp_num] = 1;
                    //box 9格
                    int index = i / 3 + 3 * (j / 3);
                    if (boxs[index][temp_num] == 1) {
                        //System.out.println("index:"+index+",temp_num"+temp_num);
                        return false;
                    }
                    else boxs[index][temp_num] = 1;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] arr = new char[][]{
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(s.isValidSudoku(arr));
    }
}


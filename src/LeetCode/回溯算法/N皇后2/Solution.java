package LeetCode.回溯算法.N皇后2;


public class Solution {
    int result = 0;

    public int totalNQueens(int n) {
        int[] lie_flag = new int[n];
        int[] zuo_flag = new int[2 * n - 1];//'\'代表左上到右下的斜边上有没有皇后 一共有n+n-1个斜边
        int[] you_flag = new int[2 * n - 1];//'/'代表右上到左下的斜边上有没有皇后
        sub_totalNQueens(lie_flag, zuo_flag, you_flag, 0, n);
        return result;
    }

    public void sub_totalNQueens(int[] lie_flag, int[] zuo_flag, int[] you_flag, int step, int n) {
        if (step == n) {
            result++;
            return;
        }
        for (int i = 0; i < n; i++) {//j代表列 遍历每一层的列
            int zuo_index = i - step + (n  - 1);//列减行 相同的为同一斜边
            int you_index = step + i;//行和列的和一样的为同一斜边
            if (lie_flag[i] == 0 && zuo_flag[zuo_index] == 0 && you_flag[you_index] == 0) {//找到一个未被占领的位置
                //将皇后能走到的点全部标记为1
                lie_flag[i] = 1;
                zuo_flag[zuo_index] = 1;
                you_flag[you_index] = 1;
                sub_totalNQueens(lie_flag, zuo_flag, you_flag, step + 1, n);
                //将上述的标记还原
                lie_flag[i] = 0;
                zuo_flag[zuo_index] = 0;
                you_flag[you_index] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.totalNQueens(5));
    }
}

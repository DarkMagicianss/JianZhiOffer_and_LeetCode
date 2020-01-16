package LeetCode.回溯算法.N皇后;


import java.util.LinkedList;
import java.util.List;

public class Solution {
    //N皇后的方法明显比N皇后2的麻烦 但是在LEETCODE上 速度却更快？？？一脸闷逼
    List<List<String>> result = new LinkedList<>();

    public List<List<String>> solveNQueens(int n) {
        int[][] flag = new int[n][n];
        int[] lie_flag = new int[n];
        sub_solveNQueens(new LinkedList<>(), flag,lie_flag, 0, n);
        return result;
    }

    public void sub_solveNQueens(LinkedList<String> list, int[][] flag,int[] lie_flag, int step, int n) {
        if (step == n) {
            result.add(new LinkedList<>(list));
            //System.out.println(list);
            return;
        }
        for (int i = 0; i < n; i++) {//j代表列 遍历每一层的列
            if (flag[step][i] == 0 && lie_flag[i] == 0) {//找到一个未被占领的位置
                lie_flag[i] = 1;
                //将皇后能走到的点全部标记为1
                mark(flag,step,n,i,1);
                list.addLast(create_str(i, n));
                sub_solveNQueens(list, flag,lie_flag, step + 1, n);
                list.removeLast();
                //将上述的标记还原
                mark(flag,step,n,i,-1);
                lie_flag[i] = 0;
            }
        }
    }

    public String create_str(int index, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i != index) sb.append('.');
            else sb.append('Q');
        }
        return sb.toString();
    }
    public void mark(int[][] flag,int step,int n,int i,int add){
        for (int left_x = step + 1, left_y = i - 1; left_x < n && left_y >= 0; left_x++, left_y--) {//左斜边
            flag[left_x][left_y] += add;
        }
        for (int right_x = step + 1, right_y = i + 1; right_x < n && right_y < n; right_x++, right_y++) {//右斜边
            flag[right_x][right_y] += add;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.solveNQueens(5);
        for (int i = 0; i < s.result.size(); i++) {
            System.out.println(s.result.get(i));
        }
        System.out.println(s.result.size());
    }
}

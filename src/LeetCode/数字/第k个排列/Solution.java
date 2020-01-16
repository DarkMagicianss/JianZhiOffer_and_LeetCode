package LeetCode.数字.第k个排列;


import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    //其实这应该是一道回溯的题目 但是通过找规律 解决了一部分
    public String getPermutation(int n, int k) {
        int[] arr = new int[n + 1];
        ArrayList<Integer> list = new ArrayList<>(n);
        arr[0] = 1;
        for (int i = 1; i < arr.length; i++) {//计算出阶乘
            arr[i] = arr[i - 1] * i;
            list.add(i);
        }
        System.out.println(list);
        System.out.println(Arrays.toString(arr));
        StringBuilder sb = new StringBuilder();
        int step = n;
        k = k - 1;
        while(step != 0){
            //System.out.println(k + "  " + step);
            int temp = k / arr[step - 1];
            sb.append((char) ('0' + list.get(temp)));
            list.remove(temp);
            k = k % arr[step - 1];
            step--;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.getPermutation(3, 2));
    }
}

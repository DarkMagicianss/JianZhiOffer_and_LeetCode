package JianZhiOffer.JZ18知识迁移能力.和为S的两个数;


import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        if (array == null || array.length <= 1) return result;
        for (int i = 0; i < array.length; i++) {
            int target = sum - array[i];
            int temp = Arrays.binarySearch(array, i + 1, array.length, target);
            if (temp >= 0) {
                result.add(array[i]);
                result.add(array[temp]);
                return result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = new int[]{-29,-25,-20,-19,-15,-11,-10,-5,-1,0};
        ArrayList<Integer> result = s.FindNumbersWithSum(arr, -30);
        System.out.println(result);
    }
}

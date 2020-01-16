package JianZhiOffer.JZDiff.和为S的两个数;


import java.util.ArrayList;


public class BetterSolution {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        if (array == null || array.length <= 1) return result;
        int left = 0, right = array.length - 1;
        while (left <= right) {
            int temp = array[left] + array[right];
            if (temp > sum){
                right--;
            }else if(temp < sum){
                left++;
            }else{
                result.add(array[left]);
                result.add(array[right]);
                return result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        BetterSolution s = new BetterSolution();
        int[] arr = new int[]{1, 2, 4, 5, 6, 7, 9, 11, 15, 16, 18, 25, 30};
        ArrayList<Integer> result = s.FindNumbersWithSum(arr, 31);
        System.out.println(result);
    }
}

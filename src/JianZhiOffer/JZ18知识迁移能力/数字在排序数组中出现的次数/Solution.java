package JianZhiOffer.JZ18知识迁移能力.数字在排序数组中出现的次数;


import java.util.Arrays;

public class Solution {
    public int GetNumberOfK(int [] array , int k) {
        if(array == null || array.length == 0)return 0;
        if(array.length == 1 && array[0] == k)return 1;
        int result = 0;
        int index = Arrays.binarySearch(array,0, array.length-1,k);
        if(index < 0)return 0;
        else result++;
        int left_index = index;
        int right_index = index;
        while(left_index >0 && array[left_index - 1] == array[left_index]) {
            result++;
            left_index--;
        }
        while(right_index <array.length - 1 && array[right_index + 1] == array[right_index]) {
            result++;
            right_index++;
        }
        return result;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] array = new int[]{1,1,2,2,2,3,4,5,6,7,8,9,11,11,11,11,11,11,11,12,15,79,89,99};
        System.out.println(s.GetNumberOfK(array,11));
    }
}

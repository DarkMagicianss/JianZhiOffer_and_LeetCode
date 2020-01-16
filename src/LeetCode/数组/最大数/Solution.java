package LeetCode.数组.最大数;


import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) return "";
        if (nums.length == 1) return "" + nums[0];
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length - 1 && sb.length() == 0 && arr[i].equals("0")) continue;
            sb.append(arr[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.largestNumber(new int[]{6}));
        System.out.println(s.largestNumber(new int[]{10, 2}));
        System.out.println(s.largestNumber(new int[]{3, 0, 34, 5, 9}));
        System.out.println(s.largestNumber(new int[]{3, 0}));
        System.out.println(s.largestNumber(new int[]{0, 0}));
        System.out.println(s.largestNumber(new int[]{1, 0, 0}));
    }
}


package JianZhiOffer.JZ16时间效率.数组中出现次数超过一半的数组;


import java.util.HashMap;

public class Solution {
    public int MoreThanHalfNum_Solution(int[] array) {
        int len = array.length;
        if (len == 0) return 0;
        if (len == 1) return array[0];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int count = 1;
            if (map.containsKey(array[i])) {
                count += map.get(array[i]);
                if (count > len / 2)
                    return array[i];
            }
            map.put(array[i], count);
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = new int[]{4, 2, 1, 4, 2, 4};
        int result = s.MoreThanHalfNum_Solution(arr);
        System.out.println(result);
    }
}

package JianZhiOffer.JZ16时间效率.把数组排成最小的数_____论熟练掌握StringAPI的好处;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public String PrintMinNumber(int[] numbers) {
        if (numbers.length == 0) return "";
        int len = numbers.length;
        String[] num_str = new String[len];
        for (int i = 0; i < len; i++) {
            num_str[i] = Integer.toString(numbers[i]);
        }
        Arrays.sort(num_str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //使用String类中自带的API方法多好compareTo
                //既然我们不知道o1o2排起来的数小还是o2o1排起来的数小 那就合在一下比一下大小就好了
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return s1.compareTo(s2);
//                //啊吼 白痴一般的做法
//                char[] c1 = o1.toCharArray();
//                char[] c2 = o2.toCharArray();
//                int len1 = o1.length();
//                int len2 = o2.length();
//                int len = Math.max(len1, len2);
//                for (int i = 0; i < len; i++) {
//                    if (i == len1 && i != len2) {
//                        int k = i;
//                        while (k < len2) {
//                            if (c2[k] > c1[i - 1]) return -1;
//                            k++;
//                        }
//                        return 1;
//                    }
//                    if (i == len2 && i != len1) {
//                        int k = i;
//                        while (k < len1) {
//                            if (c1[k] > c2[i - 1]) return 1;
//                            k++;
//                        }
//                        return -1;
//                    }
//                    if (c1[i] < c2[i]) {
//                        return -1;
//                    } else if (c1[i] > c2[i]) {
//                        return 1;
//                    }
//                }
//                return 0;
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(num_str[i]);
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = new int[]{3334, 3, 3333332};
        String result = s.PrintMinNumber(arr);
        System.out.println(result);
    }
}

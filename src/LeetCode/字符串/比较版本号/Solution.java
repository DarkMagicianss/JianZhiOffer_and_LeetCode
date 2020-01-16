package LeetCode.字符串.比较版本号;


public class Solution {
    public int compareVersion(String version1, String version2) {
        if (version1.equals(version2)) return 0;
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        int min_len = Math.min(arr1.length, arr2.length);
        //System.out.println(Arrays.toString(arr1));
        //System.out.println(Arrays.toString(arr2));
        for (int i = 0; i < min_len; i++) {
            int v1 = Integer.parseInt(arr1[i]);
            int v2 = Integer.parseInt(arr2[i]);
            if (v1 > v2) {
                return 1;
            } else if (v1 < v2) {
                return -1;
            }
        }
        if (min_len == arr1.length) {
            for (int i = min_len; i < arr2.length; i++) {
                if (Integer.parseInt(arr2[i]) != 0) return -1;
            }
            return 0;
        } else {
            for (int i = min_len; i < arr1.length; i++) {
                if (Integer.parseInt(arr1[i]) != 0) return 1;
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.compareVersion("0.1", "1.1"));
        System.out.println(s.compareVersion("1.0.1", "1"));
        System.out.println(s.compareVersion("7.5.2.4", "7.5.3"));
        System.out.println(s.compareVersion("1.01", "1.001"));
        System.out.println(s.compareVersion("1.0", "1.0.0"));
    }
}


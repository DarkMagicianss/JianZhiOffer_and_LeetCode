package LeetCode.字符串.复原IP地址;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        int len = s.length();
        if (len < 4 || len > 12) return list;
        int[] p = new int[5];
        for (int i = 0; i < 4; i++) {
            p[i] = i;
        }
        p[4] = s.length();
        while (p[1] <= len - 3) {
            //System.out.println(Arrays.toString(p));
            if (p[2] - p[1] >= 4 || p[3] - p[2] >= 4 || p[4] - p[3] >= 4) {
                add(p, len);
                continue;
            }
            String result = isValid(s, p);
            if (!result.equals("")) {
                list.add(result);
            }
            add(p, len);
        }
        return list;
    }

    private void add(int[] p, int len) {
        if (p[3] <= len - 1) {
            p[3]++;
        } else if (p[2] <= len - 2) {
            p[2]++;
            p[3] = p[2] + 1;
        } else {
            p[1]++;
            p[2] = p[1] + 1;
            p[3] = p[2] + 1;
        }
    }

    private String isValid(String s, int[] p) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < p.length; i++) {
            String temp = s.substring(p[i - 1], p[i]);
            //System.out.println(temp);
            if (temp.equals("") || Long.parseLong(temp) > 255 || (temp.length() != 1 && temp.charAt(0) == '0')) {
                return "";
            }
            sb.append(temp);
            if (i != p.length - 1) sb.append(".");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.restoreIpAddresses("010010"));
    }
}

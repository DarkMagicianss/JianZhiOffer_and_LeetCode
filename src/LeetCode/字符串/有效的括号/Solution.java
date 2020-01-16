package LeetCode.字符串.有效的括号;

import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        if (s.length() == 0) return true;//空则返回true
        if (s.length() % 2 == 1) return false;//奇数个必定为false
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {//记录并检查
            if (arr[i] == '(' || arr[i] == '[' || arr[i] == '{') {
                //左括号则进栈
                stack.push(arr[i]);
            } else {
                if (stack.isEmpty()) return false;
                //右括号则判断最后进去的左括号是否一致
                char last_char = stack.pop();
                if ((last_char == '(' && arr[i] == ')') ||
                    (last_char == '[' && arr[i] == ']') ||
                    (last_char == '{' && arr[i] == '}')) {
                    //两者相等则继续进行判断
                    continue;
                } else {//两者不想等则返回false
                    return false;
                }
            }
        }
        if (!stack.isEmpty()) return false;//判断所有括号是否均已经出栈
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "]";
        boolean b = s.isValid(str);
        System.out.println(b);
    }
}

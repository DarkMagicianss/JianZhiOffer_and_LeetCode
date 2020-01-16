package LeetCode.数组.逆波兰表达式求值;

import java.util.LinkedList;

public class Solution {
    public int evalRPN(String[] tokens) {
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                stack.addLast(stack.removeLast() + stack.removeLast());
            } else if (tokens[i].equals("-")) {
                int first = stack.removeLast();
                int second = stack.removeLast();
                stack.addLast(second - first);
            } else if (tokens[i].equals("*")) {
                stack.addLast(stack.removeLast() * stack.removeLast());
            } else if (tokens[i].equals("/")) {
                int first = stack.removeLast();
                int second = stack.removeLast();
                stack.addLast(second / first);
            } else {
                stack.addLast(Integer.valueOf(tokens[i]));
            }
        }
        return stack.removeLast();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        System.out.println(s.evalRPN(new String[]{"4", "13", "5", "/", "+"}));
        System.out.println(s.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }
}

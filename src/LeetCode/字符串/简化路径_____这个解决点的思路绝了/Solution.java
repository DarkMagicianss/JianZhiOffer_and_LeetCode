package LeetCode.字符串.简化路径_____这个解决点的思路绝了;


import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public String simplifyPath(String path) {
        //一句话解释: 栈解决,把当前目录压入栈中,遇到..弹出栈顶,最后返回栈中元素.
        Deque<String> stack = new LinkedList<>();
        for (String item : path.split("/")) {
            if (item.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else if (!item.isEmpty() && !item.equals(".")) stack.push(item);
        }
        String res = "";
        for (String d : stack) res = "/" + d + res;
        return res.isEmpty() ? "/" : res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.simplifyPath("/home/"));
        System.out.println(s.simplifyPath("/../"));
        System.out.println(s.simplifyPath("/home//foo/"));
        System.out.println(s.simplifyPath("/a/./b/../../c/"));
        System.out.println(s.simplifyPath("/a/../../b/../c//.//"));
        System.out.println(s.simplifyPath("/a//b////c/d//././/.."));
        System.out.println(s.simplifyPath("/..."));
        System.out.println(s.simplifyPath("/.../"));
        System.out.println(s.simplifyPath("/..hidden"));
        System.out.println(s.simplifyPath("/hidden"));
    }
}

package JianZhiOffer.JZ14举例让抽象问题具体化.包含min函数的栈;


import java.util.Stack;

public class Solution {
    Stack<Integer> st = new Stack<>();
    Stack<Integer> min = new Stack<>();

    public void push(int node) {
        st.push(node);
        if(min.empty())min.push(node);
        else if(node < min.peek())min.push(node);
    }

    public void pop() {
        Integer x = st.pop();
        if(x == min.peek())min.pop();
    }

    public int top() {
        return min.peek();
    }

    public int min() {
        return top();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.push(3);
        System.out.println(s.min());
        s.push(4);
        System.out.println(s.min());
        s.push(2);
        System.out.println(s.min());
        s.push(3);
        System.out.println(s.min());
        s.pop();
        System.out.println(s.min());
        s.pop();
        System.out.println(s.min());
        s.pop();
        System.out.println(s.min());
        s.push(0);
        System.out.println(s.min());

    }
}

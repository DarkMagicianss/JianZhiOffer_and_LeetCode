package LeetCode.数组.最小栈;

import java.util.LinkedList;

public class MinStack {
    /** initialize your data structure here. */
    private LinkedList<Integer> data = null;
    private LinkedList<Integer> min = null;
    public MinStack() {
        data = new LinkedList<>();
        min = new LinkedList<>();
    }

    public void push(int x) {
        if(data.isEmpty() || x < min.getLast()){
            data.addLast(x);
            min.addLast(x);
        }else{
            data.addLast(x);
            min.addLast(min.getLast());
        }
    }

    public void pop() {
        data.removeLast();
        min.removeLast();
    }

    public int top() {
        return data.getLast();
    }

    public int getMin() {
        return min.getLast();
    }

    public static void main(String[] args) {
        MinStack s = new MinStack();
        s.push(-2);
        s.push(0);
        s.push(-3);
        System.out.println(s.getMin());
        s.pop();
        System.out.println(s.top());
        System.out.println(s.getMin());

    }
}

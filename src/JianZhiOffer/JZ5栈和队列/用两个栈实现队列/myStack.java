package JianZhiOffer.JZ5栈和队列.用两个栈实现队列;

import java.util.Stack;

public class myStack {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    //自己想的方法 每次push时都将栈1里面的数据顺序通过栈2实现先进先出 pop直接pop栈1 实则浪费了时间
    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        //新方法：每当要pop时,将栈1的所有已有的数据pop在push到栈2 实现了先进先出
        //然后只要栈2不为空 就一直pop栈2 直到栈2为空为止
        if(stack2.empty()){
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}

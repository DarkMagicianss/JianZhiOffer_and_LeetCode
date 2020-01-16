package JianZhiOffer.JZDiff.栈的压入_弹出序列______思路不够好;

import java.util.Stack;

public class BetterSolution {
    public boolean IsPopOrder2(int[] pushA, int[] popA) {
        if (pushA == null || popA == null) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int index = 0;

        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while (!stack.isEmpty() && stack.peek() == popA[index]) {
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        BetterSolution s = new BetterSolution();
        int[] pushA = new int[]{1, 2, 3, 4, 5};
        int[] popA = new int[]{4, 5, 3, 1, 2};
        System.out.println(s.IsPopOrder2(pushA, popA));
    }
}

package JianZhiOffer.JZ6递归和循环.斐波那契数列;

public class Solution {
    public static int Fibonacci(int n) {
        if (n == 0) return 0;
        if(n == 1 || n == 2)return 1;
        int preTwo = 1, preOne = 1, result = 0;
        for (int i = 2; i < n; i++) {
            result = preTwo + preOne;
            preTwo = preOne;
            preOne = result;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Fibonacci(5));
    }
}

package JianZhiOffer.JZ10位运算.二进制中1的个数;

public class NumberOf1 {
    public static int NumberOf1(int n) {
        int sum=0;
        for(int i=0;i<32;i++){
            sum+=n&1;
            n = n>>>1;
        }
        return sum;
    }

    public static void main(String[] args){
        System.out.println(NumberOf1(-1));
    }
}

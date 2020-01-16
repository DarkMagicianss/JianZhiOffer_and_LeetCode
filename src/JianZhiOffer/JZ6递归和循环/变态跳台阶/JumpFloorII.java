package JianZhiOffer.JZ6递归和循环.变态跳台阶;

public class JumpFloorII {
    public static int JumpFloorII(int target) {
        //target阶台阶就是之前1到target-1阶台阶的次数加起来总和再加1
        //因为对于target阶台阶 他跳一阶接下来就是跳target-1的对应的那么多跳法 以此推类
        //因此1阶为1种 2阶为2种 3阶为4种。。。n阶为2^(n-1)种
        return (int)java.lang.Math.pow(2,target-1);
    }

    public static void main(String[] args) {

    }
}

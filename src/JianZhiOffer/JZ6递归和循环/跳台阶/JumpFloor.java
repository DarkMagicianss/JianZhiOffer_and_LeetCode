package JianZhiOffer.JZ6递归和循环.跳台阶;

public class JumpFloor {
    public static int JumpFloor(int target) {
        //一个个举例验算 貌似过于复杂 竟然想到了数学归纳法
        //想想若青蛙跳到target台阶有m种方法,跳到target-1台阶有n种方法
        //那么跳到target+1是不是只有两种可能
        //1.从target台阶跳1个台阶 这里有m种可能
        //2.从target-1台阶跳2个台阶 这里有n种可能
        //因此target+1台阶的结果就是斐波那契数列 只是初值不一样
        if (target == 0) return 0;
        if (target == 1) return 1;
        if (target == 2) return 2;
        int preTwo = 1, preOne = 2, result = 0;
        for (int i = 2; i < target; i++) {
            result = preTwo + preOne;
            preTwo = preOne;
            preOne = result;
        }
        return result;
    }

    public static void main(String[] args) {

    }
}

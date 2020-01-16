package JianZhiOffer.JZ6递归和循环.矩形覆盖;

import JianZhiOffer.JZ6递归和循环.跳台阶.JumpFloor;

public class RectCover {
    public static int RectCover(int target) {
        //仔细考虑过后就是斐波那契数列
//        if (target == 0) return 0;
//        if(target == 1)return 1;
//        if(target == 2)return 2;
//        int preTwo = 1, preOne = 2, result = 0;
//        for (int i = 2; i < target; i++) {
//            result = preTwo + preOne;
//            preTwo = preOne;
//            preOne = result;
//        }
//        return result;
        return JumpFloor.JumpFloor(target);
    }

    public static void main(String[] args) {
        System.out.println(RectCover(3));
    }
}

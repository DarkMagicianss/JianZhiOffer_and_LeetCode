package JianZhiOffer.JZ1数组.数组中重复的数字;

import java.util.HashSet;

public class Duplicate {
    public static boolean duplicate(int numbers[],int length,int [] duplication) {
        //一般的个人版本 28ms 时间复杂度为nlongn
//        if(length == 0 || numbers.length == 0)return false;
//        java.util.Arrays.sort(numbers);
//        for (int i=0;i<length-1;i++){
//            if(numbers[i] == numbers[i+1]){
//                duplication[0] = numbers[i];
//                return true;
//            }
//        }
//        return false;
        //HashSet表 23ms 时间复杂度为n
        if(length == 0 || numbers.length == 0)return false;
        HashSet set = new HashSet();
        for(int i=0;i<length;i++){
            if(set.contains(numbers[i])){
                duplication[0] = numbers[i];
                return true;
            }
            set.add(numbers[i]);
        }
        return false;
    }
    public static void main(String[] args){


    }
}

package JianZhiOffer.JZDiff.数组中只出现一次的数字;


import java.util.HashSet;
import java.util.Iterator;

public class Solution {
    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            if(set.contains(array[i])){
                set.remove(array[i]);
            }else{
                set.add(array[i]);
            }
        }
        Iterator it = set.iterator();
        num1[0] = (int) it.next();
        num2[0] = (int) it.next();
        return;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] array = new int[]{2,4,3,6,3,2,5,5};
        int[] a1 = new int[1];
        int[] a2 = new int[1];
        s.FindNumsAppearOnce(array,a1,a2);
        System.out.println(a1[0]);
        System.out.println(a2[0]);
    }
}

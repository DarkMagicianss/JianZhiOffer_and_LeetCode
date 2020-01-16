package JianZhiOffer.JZDiff.数组中只出现一次的数字;

public class BetterSolution {
    //遍历一遍 再遍历一遍 想法很好 空间复杂度上节省为O(1)
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if (array == null)
            return;
        num1[0] = 0;
        num2[0] = 0;
        int number = array[0];
        for (int i = 1; i < array.length; i++)
            number ^= array[i];
        // 异或后的数1出现在第几位
        int index = 0;
        while ((number & 1) == 0) {
            number = number >> 1;
            index++;
        }

        for (int i = 0; i < array.length; i++) {
            // 判断第index位是不是0
            boolean isBit = ((array[i] >> index) & 1) == 0;
            if (isBit) {
                num1[0] ^= array[i];
            } else {
                num2[0] ^= array[i];
            }
        }
    }

}

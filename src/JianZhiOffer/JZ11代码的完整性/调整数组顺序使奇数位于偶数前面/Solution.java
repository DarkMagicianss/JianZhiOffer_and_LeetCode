package JianZhiOffer.JZ11代码的完整性.调整数组顺序使奇数位于偶数前面;


public class Solution {
    public void reOrderArray(int[] array) {
        int len = array.length;
        int[] array_new = new int[len];
        int odd_index = 0;
        int even_index = 0;
        for (int i = 0; i<len; i++) {
            if (array[i]%2 == 1){
                array[odd_index]=array[i];
                odd_index++;
            }else{
                array_new[even_index] = array[i];
                even_index++;
            }
        }
        for(int i=0;i<even_index;i++){
            array[odd_index] = array_new[i];
            odd_index++;
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[10];
        Solution s = new Solution();
        s.reOrderArray(arr);
        System.out.println("1");
    }
}

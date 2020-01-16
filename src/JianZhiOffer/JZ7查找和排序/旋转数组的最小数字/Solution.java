package JianZhiOffer.JZ7查找和排序.旋转数组的最小数字;

public class Solution {
    public static int minNumberInRotateArray(int [] array) {
        if(array.length == 0)return 0;
        int mid;
        int start = 0;
        int end = array.length-1;
        //这个不减的数组 经过二维图像展示 就像一个上坡突然断崖然后再上坡
        //因此判断数组中间的值 若大于array[0]则断崖的mid后方
        //若小于array[0]则断崖在mid前方 以此循环
        while(start < end){
            mid = (start + end)>>1;
            if(array[mid] > array[start]){
                start = mid;
            }else if(array[mid] < array[end]){
                end = mid;
            }else{
                int min = array[mid];
                if(mid > 0 && array[mid - 1] < min){
                    min = array[mid - 1];
                }
                if(mid < array.length - 1 && array[mid + 1] < min){
                    min = array[mid + 1];
                }
                return min;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,4,5,1,2};
        System.out.println(minNumberInRotateArray(arr));
    }
}

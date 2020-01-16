package JianZhiOffer.JZ1数组.二维数组的查找;

public class Find {
    public static boolean Find(int target, int [][] array) {
        if(array.length == 0)return false;
        if(array[0].length == 0)return false;
        if(array.length == 1 && array[0].length == 1)return target == array[0][0];
        int length_x = array[0].length;
        int length_y = array.length;
        int[] last_x = array[length_y-1];
        int x_result = MyBinarySearch(last_x,target,0,last_x.length-1);
        int y_result = -1;
        if(x_result <length_x && last_x[x_result] == target)return true;
        else{
            int[] last_y = new int[length_y];
            for(int i=0;i<length_y;i++){
                last_y[i] = array[i][length_x-1];
            }
            y_result = MyBinarySearch(last_y,target,0,last_y.length-1);
            //查找到两个x,y的坐标点,缩小范围
            for(int i=y_result;i<length_y;i++){
                int result = MyBinarySearch(array[i],target,x_result,length_x);
                if(result < length_x && array[i][result] == target)return true;
            }
            return false;
        }
    }
    public static int MyBinarySearch(int[] nums,int key,int start,int end){
        int max,min,mid;
        max = end;
        min = start;
        mid = (max + min)>>1;
        while(min<=max){
            mid = (max + min)>>1;
            if(key>nums[mid]){
                min = mid + 1;
            }else if(key < nums[mid]){
                max = mid - 1;
            }else {
                return mid;
            }
        }
        return min;
    }
    public static void main(String[] args){
        int[][] nums = new int[][]{{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(Find(16,nums));
    }
}

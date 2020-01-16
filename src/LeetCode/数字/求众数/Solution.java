package LeetCode.数字.求众数;

public class Solution {
    public int majorityElement(int[] nums) {
        if(nums.length == 1)return nums[0];
        int last_num = nums[0];
        int last_count = 1;
        //考虑必定存在众数 因此若数和上一个数相同 则count++
        //不相同则将上一个数的count-- 一旦到0则替换成当前数字
        //可以这么想象 因为众数超过一半 最坏的情况因此每一个众数和不同的数抵消掉 最终留下的还是众数
        //而其他不同数字的抵消则不影响结果
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] != last_num){
                if(last_count == 0){
                    last_num = nums[i];
                    last_count = 1;
                }else {
                    last_count--;
                }
            }else{
                last_count++;
            }
        }
        return last_num;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.majorityElement(new int[]{3,2,3}));
        System.out.println(s.majorityElement(new int[]{2,2,1,1,1,2,2}));
    }
}

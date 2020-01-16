package LeetCode.数组.缺失的第一个正数;

public class Solution {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        if (nums == null || len == 0) return 1;
        if (len == 1) return nums[0] == 1 ? 2 : 1;
        for (int i = 0; i < len; i++) {
            //不断尝试将对应的数值放置到对应的位置 进行交换
            //经过分析这里总共至多只会交换n次
            //因为一旦某次交换了n/2次 那么后续这个已经交换的n/2个数值就不会再被进行交换
            while (nums[i] < i + 1 && nums[i] > 0 && nums[i] < len) {
                int swap_index = nums[i] - 1;//下标对应起来要减一
                if(nums[i] == nums[swap_index])break;//遇到目标位置数值和当前数值一样则break
                //不断进行和对应下标的数字进行交换
                int temp = nums[swap_index];
                nums[swap_index] = nums[i];
                nums[i] = temp;
            }
        }
        //System.out.println(Arrays.toString(nums));
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return (i + 1);
            }
        }
        return len + 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = new int[]{1, 1, 2, 2, 2, 3, 3, 3, 3, 4, 4, 6};
        System.out.println(s.firstMissingPositive(arr));
    }
}

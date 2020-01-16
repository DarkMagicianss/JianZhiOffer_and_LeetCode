package LeetCode.数组.最大间距;


public class Solution {
    public class Bucket {
        boolean hasNumber;
        int min;
        int max;

        public Bucket(boolean hasNumber, int min, int max) {
            this.hasNumber = hasNumber;
            this.min = min;
            this.max = max;
        }
    }

    public int maximumGap(int[] nums) {
        if (nums.length < 2) return 0;
        int max = Integer.MIN_VALUE;
        //尝试使用桶排序解决问题 逻辑上快了一些 但是为啥执行用时还没有排序完 再操作快。。。
        //思路:
        //先找到数组的最大值和最小值，记为max和min；
        //假设数组长度为N，准备N+1个桶，把max放在N+1号桶，nums中在[min,max)范围上的数放在1~N号桶中，对于1 ~ N号桶的每一个桶来说，负责的区间大小为(max - min )/N；
        //注意每个桶中存的不是很多的数，只存三个值，是否有数进入过这个桶，以及所有进入这个桶的数的最大值、最小值；
        //最后计算相邻非空桶的间距(当前桶的min 减去前一个桶的max) ，然后记录更新最大值；
        //!!!!!桶的容量为(max - min )/N 这个值为整个排序数组的最小间距了 按照最大和最小的均匀分布 结果就是这个桶的容量!!!!!
        int min_value = Integer.MAX_VALUE;
        int max_value = Integer.MIN_VALUE;
        Bucket[] arr = new Bucket[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {//一次n
            min_value = Math.min(nums[i], min_value);
            max_value = Math.max(nums[i], max_value);
            arr[i] = new Bucket(false, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        if (max_value == min_value) return 0;
        arr[nums.length] = new Bucket(true, max_value, max_value);
        int capacity = ((max_value - min_value) / nums.length) + 1;
        for (int i = 0; i < nums.length; i++) {//一次n
            int bucket_index = (nums[i] - min_value) / capacity;
            arr[bucket_index].hasNumber = true;
            arr[bucket_index].max = Math.max(arr[bucket_index].max, nums[i]);
            arr[bucket_index].min = Math.min(arr[bucket_index].min, nums[i]);
        }
        int last_bucket_index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (last_bucket_index == -1) {
                if (arr[i].hasNumber) {
                    last_bucket_index = i;
                }
                continue;
            }
            if (arr[i].hasNumber == false) continue;
            max = Math.max(max, (arr[i].min - arr[last_bucket_index].max));
            last_bucket_index = i;
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maximumGap(new int[]{3, 6, 9, 1}));
        System.out.println(s.maximumGap(new int[]{1, 1, 1, 1}));
        System.out.println(s.maximumGap(new int[]{1, 1, 1, 1, 1, 5, 5, 5, 5, 5}));
    }
}


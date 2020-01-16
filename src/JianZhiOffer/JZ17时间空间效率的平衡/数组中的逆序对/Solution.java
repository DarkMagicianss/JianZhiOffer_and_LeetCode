package JianZhiOffer.JZ17时间空间效率的平衡.数组中的逆序对;

public class Solution {
    int result;
    public int InversePairs(int[] array) {
        result = 0;
        //尝试使用归并排序解决这个逆序对的问题
        int[] copy = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i];
        }
        if (array != null && array.length != 0)
            sub_mergerSort(copy, array, 0, array.length - 1);
        return result;
    }

    public void sub_mergerSort(int[] copy, int[] arr, int start, int end) {
        if (start >= end) return;
        int mid = (start + end) >> 1;//划分子序列
        sub_mergerSort(copy, arr, start, mid);//对左侧子序列进行递归排序
        sub_mergerSort(copy, arr, mid + 1, end);//对右侧子序列进行递归排序
        sub_merge(copy, arr, start, mid, end);//合并
    }

    //两路归并算法，两个排好序的子序列合并为一个子序列
    public void sub_merge(int[] copy, int[] arr, int left, int mid, int right) {
        int p1 = left, p2 = mid + 1, k = left;//p1,p2是检测指针分别指向数组的末端,k是存放指针也指向当前这个小分组的末端
        while (p1 <= mid && p2 <= right) {
            if (arr[p1] >= arr[p2]) {
                copy[k++] = arr[p2++];
                //若p1分组当前最小的都比p2分组当前最小的大 说明p1分组后续的都比p2分组的当前值大 均为逆序对
                result += (mid + 1 - p1);//计算p1指针当前的位置距离p1分组末尾的距离
                if (result >= 1000000007) result %= 1000000007;
            } else {
                copy[k++] = arr[p1++];
            }
        }
        while (p1 <= mid) copy[k++] = arr[p1++];//如果第一个序列未检测完，直接将后面所有元素加到合并的序列中
        while (p2 <= right) copy[k++] = arr[p2++];//同上
        //复制回原数组
        for (int i = left; i <= right; i++) {
            arr[i] = copy[i];
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = new int[]{6, 3, 1, 8, 7, 9, 5, 4};
        System.out.println(s.InversePairs(arr));
    }
}

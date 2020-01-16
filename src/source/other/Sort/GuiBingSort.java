package source.other.Sort;

import java.util.Arrays;

//链表的归并和快排依据LeetCode medium中的内容来

//和选择排序一样，归并排序的性能不受输入数据的影响，但表现比选择排序好的多，因为始终都是O(n log n）的时间复杂度。代价是需要额外的内存空间。
//归并排序是建立在归并操作上的一种有效的排序算法。该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。归并排序是一种稳定的排序方法。
//!!!!!!!!!!将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。若将两个有序表合并成一个有序表，称为2-路归并 !!!!!!!!!!
//!!!!!!!!!!归并 最优情况O(n) 最差情况O(nlogn) 平均O(nlogn) 空间复杂O(n) 稳定!!!!!!!!!!
//!!!!!!!!!!分析时间复杂度 merger方法为O(n)的遍历的时间复杂度 因此T(n)=2T(n/2)+O(n)--->T(n)=2^logn * 1 + logn*O(n)=O(n)+O(nlogn)=O(nlogn)!!!!!!!!!!
//!!!!!!!!!!分析空间复杂度 主要为merge方法中的复制一个数组的O(n)的复杂度 以及递归时压入栈的常数个空间*logn因此是：O(n)+k*O(logn)=O(n)!!!!!!!!!!
public class GuiBingSort {
    public static void main(String[] args) {
        int[] arr = {9, 1, 4, 2, 8, 5, 3, 7, 6};
        GuiBingSort ds = new GuiBingSort();
        ds.mergerSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public void mergerSort(int[] arr, int start, int end) {
        if (start >= end) return;//当子序列中只有一个元素时结束递归
        int mid = (start + end) >> 1;//划分子序列
        mergerSort(arr, start, mid);//对左侧子序列进行递归排序
        mergerSort(arr, mid + 1, end);//对右侧子序列进行递归排序
        merge(arr, start, mid, end);//合并
    }

    //两路归并算法，两个排好序的子序列合并为一个子序列
    public void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];//创建一个和原数组一样大小的辅助数组
        int p1 = left, p2 = mid + 1, k = 0;//p1,p2是检测指针,k是存放指针
        while (p1 <= mid && p2 <= right) {
            temp[k++] = arr[p1] > arr[p2] ? arr[p2++] : arr[p1++];
        }

        while (p1 <= mid) temp[k++] = arr[p1++];//如果第一个序列未检测完，直接将后面所有元素加到合并的序列中
        while (p2 <= right) temp[k++] = arr[p2++];//同上

        //复制回原数组
        for (int i = 0; i < temp.length; i++) {
            arr[left + i] = temp[i];
        }
    }
}

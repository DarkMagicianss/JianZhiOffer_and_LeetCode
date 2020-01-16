package source.other.Sort;

import java.util.Arrays;

//!!!!!!!!!!通过一趟排序将待排记录分隔成独立的两部分，其中一部分记录的关键字均比另一部分的关键字小，则可分别对这两部分记录继续进行排序，以达到整个序列有序。!!!!!!!!!!
//!!!!!!!!!!快排 最优情况O(nlogn) 最差情况O(n2) 平均O(nlogn) 空间复杂O(logn) 不稳定!!!!!!!!!!
//!!!!!!!!!!分析时间复杂度 平均每次start到end遍历一次为O(n) 因此时间复杂度为T(n)=O(n)+2T[n/2]=logn*O(n)+2^logn*1=O(nlogn)!!!!!!!!!!
//!!!!!!!!!!分析时间复杂度 最差情况下逆序 导致每次只分出其中一个元素 要分n次 依次遍历n,n-1,n-2,,,,1次 因此最差情况下为O(n2)!!!!!!!!!!
//!!!!!!!!!!分析空间复杂度 递归时压入栈的常数个空间*logn因此是：k*O(logn)=O(logn) 但是空间复杂度最差情况下为O(n)!!!!!!!!!!
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {9, 1, 4, 2, 8, 5, 3, 7, 6};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public void sort(int[] arr, int start, int end) {
        if (start >= end) return;//保证start end间隔大于等于2
        int tartget_index = start;
        int left_index = start;
        for (int i = start + 1; i <= end; i++) {
            if (arr[i] < arr[tartget_index]) {
                left_index++;
                swap(arr, left_index, i);
            }
        }
        swap(arr, tartget_index, left_index);
        sort(arr, start, left_index - 1);
        sort(arr, left_index + 1, end);
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}

package source.other.Sort;


import java.util.Arrays;

//表现最稳定的排序算法之一，因为无论什么数据进去都是O(n2)的时间复杂度，所以用到它的时候，数据规模越小越好。
//唯一的好处可能就是不占用额外的内存空间了吧。
//选择排序(Selection-sort)是一种简单直观的排序算法。
//!!!!!!!!!!首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕!!!!!!!!!!
//!!!!!!!!!!最优情况O(n2) 最差情况O(n2) 平均O(n2) 空间复杂O(1) 不稳定(序列5 8 5 2 9， 我们知道第一遍选择第1个元素5会和2交换，则两个5的先后顺序被打破了)!!!!!!!!!!
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {9, 1, 4, 2, 8, 5, 3, 7, 6};
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void sort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        for (int i = 0; i < arr.length - 1; i++) {
            int min_index = i;//记录每次遍历的最小的数的下标 然后每次循环只交换一次位置
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min_index] > arr[j]) {
                    min_index = j;
                }
            }
            swap(arr, i, min_index);
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}


package source.other.Sort;


import java.util.Arrays;

//冒泡排序是一种简单的排序算法。它重复地走访过要排序的数列，一次比较两个元素，如果它们的顺序错误就把它们交换过来。
//!!!!!!!!!!这样每次循环过后 最大的元素就被放在最后面!!!!!!!!!!
//!!!!!!!!!!优化后的冒泡 最优情况O(n) 最差情况O(n2) 平均O(n2) 空间复杂O(1) 稳定!!!!!!!!!!
//走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成.
//这个算法的名字由来是因为越小的元素会经由交换慢慢“浮”到数列的顶端。
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {9, 1, 4, 2, 8, 5, 3, 7, 6};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void sort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    swap(arr, j, j + 1);
                }
                if (flag == false) break;//若没有出现交换 则为最优情况 退出
            }
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}

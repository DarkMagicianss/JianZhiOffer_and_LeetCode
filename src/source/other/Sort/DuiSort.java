package source.other.Sort;

import java.util.Arrays;

//堆排序（Heapsort）是指利用堆这种数据结构所设计的一种排序算法。堆积是一个近似完全二叉树的结构，并同时满足堆积的性质：即子结点的键值或索引总是小于（或者大于）它的父节点。
//!!!!!!!!!!
//将初始待排序关键字序列(R1,R2….Rn)构建成大顶堆，此堆为初始的无序区；
//将堆顶元素R[1]与最后一个元素R[n]交换，此时得到新的无序区(R1,R2,……Rn-1)和新的有序区(Rn),且满足R[1,2…n-1]<=R[n]；
//由于交换后新的堆顶R[1]可能违反堆的性质，因此需要对当前无序区(R1,R2,……Rn-1)调整为新堆，然后再次将R[1]与无序区最后一个元素交换，得到新的无序区(R1,R2….Rn-2)和新的有序区(Rn-1,Rn)。
//不断重复此过程直到有序区的元素个数为n-1，则整个排序过程完成。
//!!!!!!!!!!
//!!!!!!!!!!堆排 最优情况O(nlogn) 最差情况O(nlogn) 平均O(nlogn) 空间复杂O(1) 不稳定!!!!!!!!!!
//!!!!!!!!!!分析时间复杂度 1.原始数组的大顶堆的初始化规模为n/2 每次比较次数为logn 2.交换元素 调整堆 遍历次数为n 每次比较次数为logn 因此是n/2*O(logn)+n*O(logn)=O(nlogn)!!!!!!!!!!
//!!!!!!!!!!分析空间复杂度 这里没有涉及递归 因此栈空间不会叠加 因此空间复杂度是常数级别!!!!!!!!!!
public class DuiSort {
    public static void main(String[] args) {
        int[] arr = {9, 1, 4, 2, 8, 5, 3, 7, 6};
        DuiSort ds = new DuiSort();
        ds.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void sort(int[] arr) {
        //1.先将原先的数组进行大顶堆的初始化
        for (int i = arr.length / 2 - 1; i >= 0; i--) {//先从非叶子节点开始 从下到上依次进行三个元素的比较
            adjustDeap(arr, i, arr.length);
        }
        System.out.println(Arrays.toString(arr));
        //2.交换堆顶元素和末尾元素 调整堆
        for (int j = arr.length - 1; j >= 0; j--) {
            swap(arr, 0, j);
            adjustDeap(arr, 0, j);//注意堆的长度的调整j项已经完成排序
        }
    }

    private void adjustDeap(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            } else {//当前的节点已经是三个节点中最大的了
                break;
            }
        }
        arr[i] = temp;
    }


    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}

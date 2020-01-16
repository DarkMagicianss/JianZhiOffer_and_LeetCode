package JianZhiOffer.JZ16时间效率.最小的K个数;


import java.util.ArrayList;

public class Solution {
    ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        if(k> input.length)return list;
        my_DuiSort(input, k);
        return list;
    }

    public void my_DuiSort(int[] arr, int k) {
        //1.首先将原数组初始化成小顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {//先从非叶子节点开始 从下到上依次进行三节点比较
            adjustDeap(arr, i, arr.length);
        }
        //2.交换堆顶和末尾元素 然后调整之前的堆
        for (int j = arr.length - 1; j >= arr.length - 1 - k + 1; j--) {
            swap(0, j, arr);
            adjustDeap(arr, 0, j);//调整之前没排好序的数组
            list.add(arr[j]);
        }
    }

    private void adjustDeap(int[] arr, int index, int length) {
        int temp = arr[index];
        for (int i = index * 2 + 1; i < length; i = 2 * i + 1) {
            if (i + 1 < length && arr[i + 1] < arr[i]) {
                i++;
            }
            if (arr[i] < temp) {
                arr[index] = arr[i];
                index = i;
            } else {//当前节点已经是三个节点中最大的节点了
                break;
            }
        }
        arr[index] = temp;
    }

    private void swap(int a, int b, int[] arr) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = new int[]{4, 5, 1, 6, 2, 7, 3, 8};
        s.GetLeastNumbers_Solution(arr, 3);
    }
}

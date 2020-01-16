package JianZhiOffer.JZ16时间效率.数据流中的中位数_____后来想到的就是两个队列的操作;


import java.util.Comparator;
import java.util.PriorityQueue;

//思路：创建优先级队列维护大顶堆和小顶堆两个堆，并且小顶堆的值都大于大顶堆的值，2个堆的个数的差值小于等于1，
//所以当插入个数为奇数时：大顶堆个数就比小顶堆多1，中位数就是大顶堆堆头；(因为大顶堆整体小于小顶堆)
//当插入个数为偶数时，使大顶堆个数跟小顶堆个数一样，中位数就是 2个堆堆头平均数。(因为大顶堆整体小于小顶堆)
//也可使用集合类的排序方法。
public class BetterSolution {
    int count = 0;
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();//按照默认排序 从小到大
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {//按照比较器排序 从大到小
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    });

    public void Insert(Integer num) {
        count++;
        //当数据个数为奇数时进大顶堆 不管先进哪儿 都应该先进另一个去比较！！！
        if ((count & 1) == 1) {//位运算更快???
            //这里offer对应的就是add 在队伍尾添加
            //这里的poll对应的就是remove 删除队伍头节点
            minHeap.offer(num);//先放小顶堆 然后将小顶堆的最小的元素(小顶堆堆头)放入大顶堆
            maxHeap.offer(minHeap.poll());
        } else {
            maxHeap.offer(num);//先放大顶堆 然后将大顶堆的最大的元素(大顶堆堆头)放入小顶堆
            minHeap.offer(maxHeap.poll());
        }
    }

    public Double GetMedian() {
        if (count == 0) return null;
        //当个数是奇数时 中位数就是大顶堆的堆头
        if ((count & 1) == 1) {
            return Double.valueOf(maxHeap.peek());
        } else {
            return Double.valueOf(maxHeap.peek() + minHeap.peek()) / 2;
        }
    }

    public static void main(String[] args) {
        BetterSolution s = new BetterSolution();
        s.Insert(5);
        System.out.println(s.GetMedian());
        s.Insert(2);
        System.out.println(s.GetMedian());
        s.Insert(3);
        System.out.println(s.GetMedian());
        s.Insert(4);
        System.out.println(s.GetMedian());
        s.Insert(1);
        System.out.println(s.GetMedian());
        s.Insert(6);
        System.out.println(s.GetMedian());
        s.Insert(7);
        System.out.println(s.GetMedian());
        s.Insert(0);
        System.out.println(s.GetMedian());
        s.Insert(8);
        System.out.println(s.GetMedian());
    }
}

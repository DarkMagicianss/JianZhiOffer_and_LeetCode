package JianZhiOffer.JZ16时间效率.数据流中的中位数_____后来想到的就是两个队列的操作;

public class Solution {
    private class ListNode2 {
        public int val;
        public ListNode2 next;
        public ListNode2 pre;
        public ListNode2(int x) {
            val = x;
        }
    }
    ListNode2 head;
    ListNode2 tail;
    ListNode2 mid = null;
    double last_mid = 0;
    int len = 0;
    public void Insert(Integer num) {
        ListNode2 temp = new ListNode2(num);
        len++;
        if (len == 1) {
            head = temp;
            tail = temp;
            mid = temp;
            last_mid = temp.val;
            return;
        }
        if (num < head.val) {
            head.pre = temp;
            temp.next = head;
            head = temp;
        } else if (num >= tail.val) {
            tail.next = temp;
            temp.pre = tail;
            tail = temp;
        } else {
            ListNode2 step = head;
            while (step != null) {
                ListNode2 next = step.next;
                if (num >= step.val && num < next.val) {
                    step.next = temp;
                    temp.pre = step;
                    next.pre = temp;
                    temp.next = next;
                    break;
                } else {
                    step = next;
                }
            }
        }
        if (num > mid.val) {
            if (len % 2 == 0) {//大小为偶数 让mid节点停在中间靠左位置
                last_mid = (mid.val + mid.next.val) * 1.0 / 2;
            } else {//大小为奇数
                mid = mid.next;
                last_mid = mid.val;
            }
        } else {
            if (len % 2 == 0) {//大小为偶数 让mid节点停在中间靠左位置
                last_mid = (mid.val + mid.pre.val) * 1.0 / 2;
                mid = mid.pre;
            } else {//大小为奇数
                last_mid = mid.val;
            }
        }
    }

    public Double GetMedian() {
        return last_mid;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
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

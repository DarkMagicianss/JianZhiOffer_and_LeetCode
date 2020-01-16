package LeetCode.数字.两数相加;


import utils.ListNode;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode list1 = l1;
        ListNode list2 = l2;
        ListNode result_process = new ListNode(0);
        ListNode result = result_process;//保存链表头
        int add_carry = 0;
        while(list1.next != null || list2.next !=null){
            //通过计数器的方式进行加法 有进位 加上上一次进位
            int add_temp = list1.val + list2.val + add_carry;
            //保留当前数值进位
            if(add_temp >= 10)add_carry = 1;
            else add_carry = 0;
            //存储当前数值的个位
            result_process.val = add_temp%10;
            //若其中一个链表达到末端 则将该链表当前值赋值为0
            if(list1.next!=null)list1 = list1.next;
            else list1.val = 0;
            if(list2.next!=null)list2 = list2.next;
            else list2.val=0;
            //通过进位创建高一位
            result_process.next = new ListNode(add_carry);
            result_process = result_process.next;
        }
        //将最后的两个数加上
        int add_temp = list1.val + list2.val + add_carry;
        result_process.val = add_temp%10;
        if(add_temp >= 10){
            add_carry = 1;
            result_process.next = new ListNode(add_carry);
            result_process = result_process.next;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode l11 = new ListNode(2);//2
        ListNode l12 = new ListNode(4);//4
        ListNode l13 = new ListNode(3);//3
        ListNode l21 = new ListNode(5);//5
        ListNode l22 = new ListNode(6);//6
        ListNode l23 = new ListNode(4);//4
        l11.next = l12;
        l12.next = l13;
        l21.next = l22;
        l22.next = l23;
        Solution s = new Solution();
        ListNode result = s.addTwoNumbers(l11,l21);
        int i=0;
        for (i=0;result.next != null;i++){
            System.out.println(result.val);
            result = result.next;
        }
        System.out.println(result.val);
    }
}


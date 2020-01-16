package JianZhiOffer.JZ3链表.从尾到头打印链表;

import utils.ListNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class printListFromTailToHead {
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        //旧方法 23ms 9568k
        if(listNode == null) return new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();
        while(listNode != null){
            list.addFirst(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> a_list = new ArrayList<>(list.size());
        Iterator it = list.listIterator();
        while(it.hasNext()){
            a_list.add((int)it.next());
        }
        return a_list;
        //使用stack(栈)是一个好思路 毕竟这里涉及先进后出(后进先出)
    }
    public static void main(String[] args){

    }
}

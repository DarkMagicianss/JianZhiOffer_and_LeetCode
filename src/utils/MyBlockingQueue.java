package utils;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueue {
    //使用Lock机制实现阻塞队列
    private List<Integer> container = new LinkedList<>();
    private volatile int size;
    private volatile int capacity;
    private Lock lock = new ReentrantLock();
    //Condition
    private final Condition isFull = lock.newCondition();
    private final Condition isNull = lock.newCondition();

    MyBlockingQueue(int capacity){
        this.capacity = capacity;
    }

    //添加
    public void put(int data){
        try{
            lock.lock();
            try{
                while(size >= capacity){
                    System.out.println("阻塞队列满了!");
                    isFull.await();
                }
            } catch (InterruptedException e) {
                isFull.signal();
                e.printStackTrace();
            }
            size++;
            container.add(data);
            isNull.signal();
        }finally {
            lock.unlock();
        }
    }
    //移除
    public int take(){
        try{
            lock.lock();
            try{
                while(size <= 0){
                    System.out.println("阻塞队列为空!");
                    isNull.await();
                }
            } catch (InterruptedException e) {
                isNull.signal();
                e.printStackTrace();
            }
            size--;
            int res = container.remove(0);
            isFull.signal();
            return res;
        }finally {
            lock.unlock();
        }
    }
}

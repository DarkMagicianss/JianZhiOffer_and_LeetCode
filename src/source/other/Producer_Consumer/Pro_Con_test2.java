package source.other.Producer_Consumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Pro_Con_test2 {
    private static Integer count =0;
    private final Integer Full = 10;
    final Lock lock = new ReentrantLock();
    final Condition pro = lock.newCondition();
    final Condition con = lock.newCondition();

    class Producer implements Runnable{
        @Override
        public void run() {
            for(int i=0;i<Full;i++){
                lock.lock();
                try{
                    while(count == Full){
                        try {
                            System.out.println(Thread.currentThread().getName()+"生产者线程在等待，剩余"+count);
                            pro.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count++;
                    System.out.println(Thread.currentThread().getName()+"产出铁矿，剩余"+count);
                    con.signal();
                }finally {
                    lock.unlock();
                }
            }
        }
    }
    class Consumer implements Runnable{
        @Override
        public void run() {
            for(int i=0;i<Full;i++){
                lock.lock();
                try {
                    while (count == 0) {
                        try {
                            System.out.println(Thread.currentThread().getName() + "消费者线程在等待，剩余" + count);
                            con.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count--;
                    System.out.println(Thread.currentThread().getName() + "消耗铁矿，剩余" + count);
                    pro.signal();
                }finally {
                    lock.unlock();
                }
            }
        }
    }
    public static void main(String[] arg)   {
        Pro_Con_test2 pc_t = new Pro_Con_test2();
        for (int i=0;i<10;i++){
            new Thread(pc_t.new Producer()).start();
            new Thread(pc_t.new Consumer()).start();
        }
    }
}

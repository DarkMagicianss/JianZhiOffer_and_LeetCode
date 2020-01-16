package source.other.Producer_Consumer;


public class Pro_Con_test {
    private static Integer count =0;
    private final Integer Full = 10;
    private static String Lock = "Lock";

    class Producer implements Runnable{
        @Override
        public void run() {
            for(int i=0;i<Full;i++){
                synchronized (Lock){
                    while(count >= Full){//可能唤醒后还存在满了的问题
                        try {
                            System.out.println(Thread.currentThread().getName()+"生产者线程在等待，剩余"+count);
                            Lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count++;
                    System.out.println(Thread.currentThread().getName()+"产出铁矿，剩余"+count);
                    Lock.notifyAll();
                }
            }
        }
    }
    class Consumer implements Runnable{
        @Override
        public void run() {
            for(int i=0;i<Full;i++){
                synchronized (Lock){
                    while(count == 0){
                        try {
                            System.out.println(Thread.currentThread().getName()+"消费者线程在等待，剩余"+count);
                            Lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count--;
                    System.out.println(Thread.currentThread().getName()+"消耗铁矿，剩余"+count);
                    Lock.notifyAll();
                }
            }
        }
    }
    public static void main(String[] arg)   {
        Pro_Con_test pc_t = new Pro_Con_test();
        for (int i=0;i<10;i++){
            new Thread(pc_t.new Producer()).start();
            new Thread(pc_t.new Consumer()).start();
        }
    }
}

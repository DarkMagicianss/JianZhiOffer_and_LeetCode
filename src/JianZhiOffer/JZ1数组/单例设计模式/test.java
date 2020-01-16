package JianZhiOffer.JZ1数组.单例设计模式;

import java.util.ArrayList;
import java.util.HashSet;

public class test {
    public static void main(String[] args){
        ArrayList<Singleton2> list = new ArrayList<>();
        long t1  = System.currentTimeMillis();
        for(int j=0;j<50;j++)
        {
            HashSet<Singleton2> set = new HashSet<>();
            for (int i = 0; i < 10000; i++) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Singleton2 s = Singleton2.getInstance();
                        set.add(s);
                    }
                }).start();
            }
            System.out.println(set.size());
        }
        long t2  = System.currentTimeMillis()-t1;
        System.out.println(t2/1000);
    }
}

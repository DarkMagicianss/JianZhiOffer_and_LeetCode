package JianZhiOffer.JZ1数组.单例设计模式;

//饿汉式的单例模式 比较消耗资源 但是是线程安全的
//(饿汉比较急 所以类加载的时候就存在了实例对象)
//public class Singleton {
//    private static final Singleton singleton = new Singleton();
//    private Singleton(){
//    }
//    public static Singleton getInstance(){
//        return singleton;
//    }
//}
//(饿汉式)静态内部类
//public class Singleton {
//
//    private static class SingletonHolder {
//        private static Singleton singleton = new Singleton();
//    }
//
//    private Singleton() {
//    }
//
//    public Singleton getInstance() {
//        return SingletonHolder.singleton;//直接返回内部类的
//    }
//}

//懒汉式的单例模式 只有在需要这个对象的时候才创建实例 是线程不安全的
//(懒汉嘛 所以比较懒 要用的时候才创建实例对象)
public class Singleton {
    //volatile的作用是：保证可见性、禁止指令重排序，但不能保证原子性
    private static volatile Singleton singleton = null;

    private Singleton() {

    }

    //1.虽然线程安全了 但是所有想获取该对象的线程全部需要等待(即使已经不是null了)
//    public synchronized static Singleton getInstance() {
//        if (singleton == null) singleton = new Singleton();
//        return singleton;
//    }

    //2.为什么需要双重检查锁呢?
    //因为若两个线程通过过来,都没创建实例.因此会同时卡在synchronized同步代码块上
    //其中一个线程拿到了锁，然后创建实例后释放锁，而另一个线程也此时进入就没有再判断是否已经有实例了，因此会再创建一个实例
    //综上分析，加一个单独的同步代码块任然是线程不安全的，需要再加上一个判断。
    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
//我们再来思考一个问题，就是懒汉式的双重检查版本的单例模式，它一定是线程安全的吗？我会毫不犹豫的告诉你—不一定，因为在JVM的编译过程中会存在指令重排序的问题。
//其实创建一个对象，往往包含三个过程。
//对于singleton = new Singleton()，这不是一个原子操作，在 JVM 中包含的三个过程。
//1>给 singleton 分配内存
//2>调用 Singleton 的构造函数来初始化成员变量，形成实例
//3>将singleton对象指向分配的内存空间（执行完这步 singleton才是非 null 了）
//但是，由于JVM会进行指令重排序，所以上面的第二步和第三步的顺序是不能保证的，最终的执行顺序可能是 1-2-3 也可能是 1-3-2。
// 如果是 1-3-2，则在 3 执行完毕、2 未执行之前，被另一个线程抢占了，这时 instance 已经是非 null 了（但却没有初始化），所以这个线程会直接返回 instance，然后使用，那肯定就会报错了。
//原文：https://blog.csdn.net/baiye_xing/article/details/76427595
//针对这种情况，我们有什么解决方法呢？那就是把singleton声明成 volatile




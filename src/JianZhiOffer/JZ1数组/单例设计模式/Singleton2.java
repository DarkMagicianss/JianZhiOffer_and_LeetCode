package JianZhiOffer.JZ1数组.单例设计模式;

public class Singleton2 {
    private static Singleton2 singleton2;
    static{
        singleton2 = new Singleton2();
    }
    public static Singleton2 getInstance(){
        return singleton2;
    }
}

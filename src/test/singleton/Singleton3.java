package test.singleton;

public class Singleton3 {//单线程懒汉式
    private static volatile Singleton3 instance = null;

    private Singleton3(){}

    public static Singleton3 getInstance(){
        synchronized (Singleton3.class){
            if(instance == null){
                instance = new Singleton3();
            }
            return instance;
        }
    }
}

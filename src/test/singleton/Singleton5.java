package test.singleton;


public class Singleton5 {//静态内部类，只会加载一次
    private Singleton5(){}

    private static class Holder{
        private static Singleton5 instance = new Singleton5();
    }
    public static Singleton5 getInstance(){
        return Holder.instance;
    }
}

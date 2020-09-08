package test.hello;

public class LoggingWidget extends Widget {

    @Override
    public void test(){
        System.out.println("test");
        super.test();
    }

    public synchronized  void test2(){
        System.out.println("test2");
        for (;;){

        }
    }

    public static void main(String[] args) {
        LoggingWidget loggingWidget = new LoggingWidget();
        //都是锁的loggingWidget这个实例，没有什么子类对象父类对象一说
        //是谁调的就是锁的谁
        Thread t2 = new Thread(()-> loggingWidget.test2());
        t2.start();
        Thread t1 = new Thread(() -> loggingWidget.test());
        t1.start();
    }
}

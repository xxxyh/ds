package test;

public class TestInterrupt {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            while(true){
                try {
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().isInterrupted());
                    System.out.println("睡了2秒");
                } catch (InterruptedException e) {
                    System.out.println(Thread.interrupted());
                    System.out.println("接到中断通知");
                    System.out.println(Thread.currentThread().isInterrupted());
                    return;
                }
            }
        });
        t1.start();
        Thread.sleep(10000);
        t1.interrupt();
    }
}

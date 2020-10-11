package concurrent;

public class TestNotify {
    static volatile int count = 0;

    public static void main(String[] args) throws InterruptedException {
        Object obj = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (obj){
                while(count < 100){
                    System.out.println(Thread.currentThread().getName() + ":" + count++);
                    obj.notify();
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "threadA");

        Thread t2 = new Thread(() -> {
            synchronized (obj){
                while(count < 100){
                    System.out.println(Thread.currentThread().getName() + ":" +count++);
                    obj.notify();
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "threadB");
        t1.sleep(1000);
        t1.start();
        t2.start();
    }
}

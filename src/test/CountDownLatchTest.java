package test;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

    public static void main(String[] args) {
        CountDownLatch cdl = new CountDownLatch(2);
        Thread t1 = new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "收到通知");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "到了");
            cdl.countDown();
        }, "ThreadA");

        Thread t2 = new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "收到通知");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "到了");
            cdl.countDown();
        }, "ThreadB");
        System.out.println("发出通知，来开会");
        t1.start();
        t2.start();
        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("开始会议," + Thread.currentThread().getName() +"主持会议");
    }
}

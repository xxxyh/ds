package test;

public class DeadLockTest {
    public static void main(String[] args) {
        Object resourceA = new Object();
        Object resourceB = new Object();

        Thread threadA = new Thread(() -> {
            synchronized (resourceA){
                System.out.println(Thread.currentThread()+" get resourceA");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread()+" waitting resourceB");
                synchronized (resourceB){
                    System.out.println(Thread.currentThread()+" get resourceB");
                }
            }
        });

        Thread threadB = new Thread(() -> {
            synchronized (resourceB){
                System.out.println(Thread.currentThread()+" get resourceB");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread()+" waitting resourceA");
                synchronized (resourceA){
                    System.out.println(Thread.currentThread()+" get resourceA");
                }
            }
        });
        threadA.setName("threadA");
        threadA.start();
        threadB.setName("threadB");
        threadB.start();
    }
}

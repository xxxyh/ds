package concurrent;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerAndConsumer02 {
    private Queue<Integer> queue = new LinkedList<>();
    private int MAX_SIZE = 10;
    private Lock lock = new ReentrantLock();
    private Condition full = lock.newCondition();
    private Condition empty = lock.newCondition();

    class Producer extends Thread {

        public Producer(String name){
            super(name);
        }

        @Override
        public void run(){
            while(true){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try{
                    lock.lock();
                    while(queue.size() == MAX_SIZE){
                        full.await();
                    }
                    queue.add(1);
                    System.out.println(Thread.currentThread().getName() + "生产了一个产品，当前产品数量:" + queue.size());
                    empty.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    class Consumer extends Thread {

        public Consumer(String name){
            super(name);
        }

        @Override
        public void run() {
            while(true){
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try{
                    lock.lock();
                    while(queue.isEmpty()){
                        empty.await();
                    }
                    queue.poll();
                    System.out.println(Thread.currentThread().getName() + "消费了一个产品，当前产品数量:" + queue.size());
                    full.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        ProducerAndConsumer02 pc = new ProducerAndConsumer02();
        Producer p1 = pc.new Producer("producer-1");
        Producer p2 = pc.new Producer("producer-2");

        Consumer c1 = pc.new Consumer("consumer-1");
        Consumer c2 = pc.new Consumer("consumer-2");

        p1.start();
        p2.start();
        c1.start();
        c2.start();
    }
}

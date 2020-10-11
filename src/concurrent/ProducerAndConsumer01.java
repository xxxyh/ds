package concurrent;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerAndConsumer01 {

    private Queue<Integer> queue = new LinkedList<>();
    private int MAX_SIZE = 10;

    class Producer extends Thread{

        public Producer(String name){
            super(name);
        }
        @Override
        public void run() {
            while(true){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (queue){
                    while(queue.size() == MAX_SIZE){
                        System.out.println("当前队列满");
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.add(1);
                    System.out.println("生产者生产了一个产品，当前队列大小:" + queue.size());
                    queue.notifyAll();
                }
            }
        }
    }

    class Consumer extends Thread{

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
                synchronized (queue){
                    while(queue.isEmpty()){
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.poll();
                    System.out.println("消费者消费了一个产品，当前队列大小" + queue.size());
                    queue.notifyAll();
                }
            }
        }
    }

    public static void main(String[] args) {
        ProducerAndConsumer01 pc = new ProducerAndConsumer01();
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

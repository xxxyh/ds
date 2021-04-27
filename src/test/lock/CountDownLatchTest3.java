package test.lock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class CountDownLatchTest3 {

    public static void main(String[] args) throws InterruptedException {
        //线程池里面创建4个线程
        List<String> list = new ArrayList<>();
        list.add("Angel");
        list.add("baby");
        list.add("rose");
        list.add("joyce");

        AtomicInteger i= new AtomicInteger();
        ExecutorService executorService = Executors.newFixedThreadPool(4,(runnable)->{
            return new Thread(runnable,list.get(i.getAndIncrement()));
        });

        CountDownLatch latch = new CountDownLatch(4);
        Random random = new Random();
        for (int j = 0; j <4 ; j++) {//new 4个线程  并发执行
            int temp =j;
            executorService.submit(()->{
                //k标识的是准备进度 直到准备到100%
                for (int k = 0; k <100 ; k++) {
                    try {
                        TimeUnit.MILLISECONDS.sleep(random.nextInt(200));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    String name = Thread.currentThread().getName();
                    name=name+"("+k+"%)";//angel(3%) baby(10%) ...
                    list.set(temp,name);
                    System.out.print("\r"+ Arrays.toString(list.toArray()));
                }
                latch.countDown();
            });
        }
        latch.await();
        System.out.println("\n 结束...");
        executorService.shutdown();
    }
}

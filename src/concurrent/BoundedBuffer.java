package concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBuffer {

    private ReentrantLock lock = new ReentrantLock();
    private Condition notFull = lock.newCondition();
    private Condition notEmpty = lock.newCondition();

    public BoundedBuffer(int cap){
        items = new Object[cap];
    }

    private Object[] items;
    private int putIndex, takeIndex, count;

    public void put(Object x) throws InterruptedException {
        lock.lock();
        try{
            while(count == items.length){//满了
                notFull.await();
            }
            items[putIndex++] = x;
            if(putIndex == items.length){//循环使用
                putIndex = 0;
            }
            count++;
            notEmpty.signalAll();
        }finally {
            lock.unlock();
        }

    }

    public Object take() throws InterruptedException {
        Object res;
        lock.lock();
        try{
            while(count == 0){
                notEmpty.await();
            }
            res = items[takeIndex++];
            if(takeIndex == items.length){
                takeIndex = 0;
            }
            count--;
            notFull.signalAll();
        }finally {
            lock.unlock();
        }
        return res;
    }
}

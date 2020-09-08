package leetcode;

import java.util.concurrent.CountDownLatch;

public class Solution1114 {
    class Foo {
        CountDownLatch cdl = new CountDownLatch(1);
        CountDownLatch cdl2 = new CountDownLatch(1);
        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            cdl.countDown();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            cdl.await();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            cdl2.countDown();
        }

        public void third(Runnable printThird) throws InterruptedException {
            cdl2.await();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }
}

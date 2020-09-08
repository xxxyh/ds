package leetcode;


public class Solution1115 {
    class FooBar {
        private volatile boolean flag = true;
        private int n;

        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                // printFoo.run() outputs "foo". Do not change or remove this line.
                while(!flag){
                    Thread.yield();
                }
                if(flag){
                    printFoo.run();
                    flag = false;
                }
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                // printBar.run() outputs "bar". Do not change or remove this line.
                while(flag){
                    Thread.yield();
                }
                if(!flag){
                    printBar.run();
                    flag = true;
                }
            }
        }
    }

}

package jianzhioffer;

import java.util.PriorityQueue;

public class Solution41 {
    static class MedianFinder {
        PriorityQueue<Integer> queue1;
        PriorityQueue<Integer> queue2;

        /** initialize your data structure here. */
        public MedianFinder() {
            queue1 = new PriorityQueue<>((o1, o2) -> o2 - o1);
            queue2 = new PriorityQueue<>();
        }

        public void addNum(int num) {
            queue1.offer(num);
            queue2.offer(queue1.poll());
            if(queue2.size() > queue1.size() + 1){
                queue1.offer(queue2.poll());
            }
        }

        public double findMedian() {
            if(queue1.size() == queue2.size()){
                int p = queue1.peek();
                int q = queue2.peek();
                return (double)(p + q) / 2;
            }else{
                return queue2.peek();
            }
        }
    }
    public static void main(String[] args) {
        MedianFinder finder = new MedianFinder();
        finder.addNum(1);
        System.out.println(finder.findMedian());
        finder.addNum(2);
        System.out.println(finder.findMedian());
        finder.addNum(3);
        System.out.println(finder.findMedian());
        finder.addNum(4);
        System.out.println(finder.findMedian());
        finder.addNum(5);
        System.out.println(finder.findMedian());
    }
}

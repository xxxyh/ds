package zhousai;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution1834 {
    public int[] getOrder(int[][] tasks) {
        PriorityQueue<Task> taskQueue = new PriorityQueue((Comparator<Task>) (o1, o2) -> o1.enTime - o2.enTime);
        PriorityQueue<Task> workQueue = new PriorityQueue((Comparator<Task>) (o1, o2) -> o1.workTime == o2.workTime ? o1.index - o2.index : o1.workTime - o2.workTime);

        for(int i = 0;i < tasks.length;i++){
            taskQueue.offer(new Task(tasks[i][0], tasks[i][1], i));
        }

        int[] res = new int[tasks.length];
        int index = 0;
        int curTime = taskQueue.peek().enTime;
        while(!taskQueue.isEmpty() || !workQueue.isEmpty()){
            while(!taskQueue.isEmpty() && taskQueue.peek().enTime <= curTime){
                workQueue.offer(taskQueue.poll());
            }
            if(!workQueue.isEmpty()){
                Task task = workQueue.poll();
                curTime += task.workTime;
                res[index++] = task.index;
            }else{
                curTime = taskQueue.peek().enTime;
            }
        }
        return res;
    }


    class Task{
        private int enTime;
        private int workTime;
        private int index;

        public Task(int enTime, int workTime, int index) {
            this.enTime = enTime;
            this.workTime = workTime;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution1834().getOrder(new int[][]{{1,2},{2,4},{3,2},{4,1}}));
    }
}

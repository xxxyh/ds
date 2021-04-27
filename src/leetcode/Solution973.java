package leetcode;

import java.util.Arrays;

public class Solution973 {
    public int[][] kClosest(int[][] points, int K) {
        MaxHeap heap = new MaxHeap(K);
        for(int i = 0;i < points.length;i++){
            heap.insert(points[i]);
        }
        return heap.getRes();
    }

    class MaxHeap {
        private int[][] nums;
        private int cap;
        private int size;

        public MaxHeap(int cap){
            this.cap = cap;
            this.size = 0;
            this.nums = new int[cap + 1][2];
        }

        public void insert(int[] num){
            if(size >= cap){
                if(compare(nums[1], num) >0){
                    removeMax();
                }else{
                    return;
                }
            }
            size++;
            nums[size] = num;

            int i = size;
            while(i / 2 > 0 && compare(nums[i], nums[i / 2]) > 0){
                swap(i, i / 2);
                i /= 2;
            }
        }

        public int[] removeMax(){
            if(size == 0){
                throw new IllegalStateException("no data to remove");
            }
            int[] res = nums[1];
            nums[1] = nums[size];
            size--;
            heapify(size, 1);
            return res;
        }

        private void heapify(int endIndex, int startIndex){
            while(true){
                int finalPos = startIndex;
                if(startIndex * 2 <= endIndex && compare(nums[finalPos], nums[startIndex * 2]) < 0){
                    finalPos = startIndex * 2;
                }
                if(startIndex * 2 + 1 <= endIndex && compare(nums[finalPos], nums[startIndex * 2 + 1]) < 0){
                    finalPos = startIndex * 2 + 1;
                }
                if(startIndex == finalPos){
                    break;
                }
                swap(finalPos, startIndex);
                startIndex = finalPos;
            }
        }


        private int compare(int[] o1, int[] o2){
            return (o1[0] * o1[0] + o1[1] * o1[1]) - (o2[0] * o2[0] + o2[1] * o2[1]);
        }
        private void swap(int i, int j){
            int[] temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        public int[][] getRes(){
            return Arrays.copyOfRange(nums, 1, size + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution973().kClosest(new int[][]{{89,6},{-39,-4},{-13,91},{97,-61},{1,7},{-66,69},
                {-51,68},{82,-6},{-21,44},{-58,-83},{-40,73},{-88,-24}}, 8));
    }

}

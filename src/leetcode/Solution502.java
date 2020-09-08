package leetcode;

import java.util.Set;
import java.util.TreeSet;

public class Solution502 {
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        if(Profits == null || Profits.length == 0){
            return W;
        }
        Set<Obj> un = new TreeSet<>();
        for(int i = 0;i < Profits.length;i++){
            un.add(new Obj(Profits[i], Capital[i]));
        }
        while(k > 0){
            Obj current = null;
            for(Obj obj : un){
                if(obj.c <= W){
                    current = obj;
                    break;
                }
            }
            if(current != null){
                W = W + current.p;
                k--;
                un.remove(current);
            }else{
                return W;
            }

        }
        return W;
    }
    class Obj implements Comparable{
        Integer p;
        Integer c;
        public Obj(int p, int c){
            this.p = p;
            this.c = c;
        }

        @Override public int compareTo(Object o) {
            return -1 * this.p.compareTo(((Obj)o).p);
        }

    }

    public static void main(String[] args) {
        int k=2, W=0;
        int[] Profits= new int[]{1,2,3};
        int[] Capital = new int[]{0,1,1};
        System.out.println(new Solution502().findMaximizedCapital(k, W, Profits, Capital));
    }
}

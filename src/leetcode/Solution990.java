package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution990 {

    int[] parent = new int[26];
    int[] size = new int[26];

    private void init(){
        for(int i = 00;i < parent.length;i++){
            parent[i] = i;
            size[i] = 1;
        }
    }

    private boolean connected(int p, int q){
        int findP = find(p);
        int findQ = find(q);
        return findP == findQ;
    }

    private void union(int p, int q){
        int findP = find(p);
        int findQ = find(q);
        if(findP == findQ){
            return;
        }

        if(size[findP] < size[findQ]){//小树接到大树下面
            parent[findP] = findQ;
            size[findQ] += size[findP];
        }else{
            parent[findQ] = findP;
            size[findP] += size[findQ];
        }
        return;
    }

    private int find(int x){
        while(x != parent[x]){
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    public boolean equationsPossible(String[] equations) {
        List<List<Character>> eq = new ArrayList<>();
        List<List<Character>> neq = new ArrayList<>();
        for(String equation : equations){
            Character i = equation.charAt(0);
            Character j = equation.charAt(3);
            Character op = equation.charAt(1);
            if(op == '!'){//a != b
                neq.add(Arrays.asList(i, j));
            }else{
                eq.add(Arrays.asList(i, j));
            }
        }
        init();
        for(List<Character> eqList : eq){
            union(eqList.get(0) - 'a', eqList.get(1) - 'a');
        }

        for(List<Character> neqList : neq){
            boolean connected = connected(neqList.get(0) - 'a', neqList.get(1) - 'a');
            if(connected == true){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution990().equationsPossible(new String[]{"a==b","e==c","b==c","a!=e"}));
    }
}

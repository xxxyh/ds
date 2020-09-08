package moni;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution03 {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int n = price.size();
        for(Integer need : needs){
            if(need < 0){
                return -1;
            }
        }
        int c1 = 0;
        for(int i = 0;i < needs.size();i++){
            c1 += needs.get(i) * price.get(i);
        }
        int count = Integer.MAX_VALUE;
        boolean buy = false;
        for(List<Integer> currentSpecial : special){
            int currentCount = currentSpecial.get(n);
            List<Integer> currentNeed = new ArrayList<>();
            for(int i = 0;i < needs.size();i++){
                currentNeed.add(needs.get(i) - currentSpecial.get(i));
            }
            int ref = shoppingOffers(price, special, currentNeed);
            if(ref == -1){
                currentCount = Integer.MAX_VALUE;
            }else if(ref < c1){
                buy = true;
                currentCount += ref;
                if(currentCount > c1){
                    currentCount = c1;
                }
            }else{
                currentCount = c1;
            }
            if(currentCount < count){
                count = currentCount;
            }
        }
        if(!buy){
            return c1;
        }
        return count;
    }

    public static void main(String[] args) {
        List<Integer> price = Arrays.asList(2,3,4);
        List<List<Integer>> special = new ArrayList<>();
        special.add(Arrays.asList(1,1,0,4));
        special.add(Arrays.asList(2,2,1,9));
        List<Integer> needs = Arrays.asList(1,2,1);
        System.out.println(new Solution03().shoppingOffers(price, special, needs));
    }
}

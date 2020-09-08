package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution1276 {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> result = new ArrayList<>();
        int n = cheeseSlices * 2;
        int k = tomatoSlices - n;
        if(k % 2 == 0 && k / 2 >= 0 && cheeseSlices - k / 2 >=0){
            result.add(k / 2);
            result.add(cheeseSlices - k / 2);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1276().numOfBurgers(0, 0));
    }
}

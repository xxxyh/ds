package test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class pdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] nums = new int[n][6];
        for(int i = 0;i < n;i++){
            for(int j = 0;j < 6;j++){
                nums[i][j] = sc.nextInt();
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i < n;i++){
            int key1 = nums[i][0] + nums[i][1];
            int key2 = nums[i][2] + nums[i][3];
            int key3 = nums[i][4] + nums[i][5];
            map.put(key1 * key2 * key3, map.getOrDefault(key1 * key2 * key3, 0) + 1);
        }
        List<Integer> result = map.values().stream().sorted((s1, s2)-> -1 * s1.compareTo(s2)).collect(Collectors.toList());
        System.out.println(result.size());
        for(int num : result){
            System.out.println(num);
        }
    }
}

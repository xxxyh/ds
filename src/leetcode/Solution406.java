package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution406 {
    public int[][] reconstructQueue(int[][] people) {
        if (people.length == 0) {
            return people;
        }
        //按照身高降序 K升序排序
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
        List<int[]> list = new ArrayList<>();
        //K值定义为 排在h前面且身高大于或等于h的人数
        //因为从身高降序开始插入，此时所有人身高都大于等于h
        //因此K值即为需要插入的位置
        for (int[] i : people) {
            list.add(i[1], i);
        }
        return list.toArray(new int[list.size()][]);
    }
}

package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution721 {
    Map<String, String> fatherMap = new HashMap<>();
    Map<String, Integer> sizeMap = new HashMap<>();

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        for (List<String> account : accounts) {
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                fatherMap.put(email, email);
                sizeMap.put(email, 1);
            }
        }
        for (List<String> account : accounts) {
            if (account.size() > 1) {
                for (int i = 2; i < account.size(); i++) {
                    String email = account.get(i);
                    String pre = account.get(i - 1);
                    union(email, pre);
                }
            }
        }
        List<List<String>> res = new ArrayList<>();
        Map<String, Integer> mapToIndex = new HashMap<>();
        for(List<String> account : accounts){
            if(account.size() > 1){
                String email = account.get(1);
                String father = find(email);
                List<String> cur;
                if(mapToIndex.containsKey(father)){
                    int index = mapToIndex.get(father);
                    cur = res.get(index);
                }else{
                    cur = new ArrayList<>();
                    mapToIndex.put(father, res.size());
                    res.add(cur);
                }
                cur.addAll(account);
            }else{
                res.add(account);
            }
        }

        for(int i = 0;i < res.size();i++){
            List<String> cur = res.get(i);
            String name = cur.get(0);
            Set<String> set = cur.stream().collect(Collectors.toSet());
            set.remove(name);
            cur = new ArrayList<>();
            cur.add(name);
            cur.addAll(set.stream().sorted().collect(Collectors.toList()));
            res.set(i, cur);
        }
        return res;
    }

    public String find(String x) {
        String father = fatherMap.get(x);
        if (!x.equals(father)) {
            father = find(father);
        }
        fatherMap.put(x, father);
        return father;
    }

    private void union(String p, String q) {
        String fatherP = find(p);
        String fatherQ = find(q);

        if (fatherP.equals(fatherQ)) {
            return;
        }

        int sizeP = sizeMap.get(fatherP);
        int sizeQ = sizeMap.get(fatherQ);

        if (sizeP < sizeQ) {//p接到q下面
            fatherMap.put(fatherP, fatherQ);
            sizeMap.put(fatherQ, sizeP + sizeQ);
        } else {
            fatherMap.put(fatherQ, fatherP);
            sizeMap.put(fatherP, sizeP + sizeQ);
        }
    }

    private boolean connected(String p, String q) {
        return find(p).equals(find(q));
    }

    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("David","David0@m.co","David1@m.co");
        List<String> list2 = Arrays.asList("David","David3@m.co","David4@m.co");
        List<String> list3 = Arrays.asList("David","David4@m.co","David5@m.co");
        List<String> list4 = Arrays.asList("David","David2@m.co","David3@m.co");
        List<String> list5 = Arrays.asList("David","David1@m.co","David2@m.co");
        new Solution721().accountsMerge(Arrays.asList(list1, list2, list3, list4, list5));
    }
}

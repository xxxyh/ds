package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution842 {
    int max = Integer.MAX_VALUE -1;
    public List<Integer> splitIntoFibonacci(String S) {
        int n = S.length();
        int min = Math.min(n / 2, 10);
        List<Integer> list = new ArrayList<>();
        for(int i = 1;i <= min;i++){
            String s1 = S.substring(0, i);
            if(s1.startsWith("0") && s1.length() != 1){
                break;
            }
            Long f1 = Long.valueOf(s1);
            if(f1 > max){
                break;
            }
            for(int j = 1;j <= min;j++){
                String s2 = S.substring(i, i + j);
                if(s2.startsWith("0") && s2.length() != 1){
                    break;
                }
                Long f2 = Long.valueOf(s2);
                if(f2 > max){
                    break;
                }
                Long next = f1 + f2;
                if(next > max){
                    break;
                }
                list.add(f1.intValue());
                list.add(f2.intValue());
                boolean b = validate(s1, s2, S.substring(i + j), list);
                if(b && list.size() > 2){
                    return list;
                }else{
                    list.clear();
                }
            }
        }
        return list;
    }

    private boolean validate(String s1, String s2, String S, List<Integer> list){
        if(S.length() == 0){
            return true;
        }
        int f1 = list.get(list.size() - 2);

        int f2 = list.get(list.size() - 1);
        Long next = Long.valueOf(f1) + f2;
        if(next > max){
            return false;
        }
        String val = String.valueOf(next);
        if(S.startsWith(val)){
            list.add(next.intValue());
            return validate(s2, val, S.substring(val.length()), list);
        }
        return false;
    }

    public static void main(String[] args) {
        new Solution842().splitIntoFibonacci("1101111");
    }

}

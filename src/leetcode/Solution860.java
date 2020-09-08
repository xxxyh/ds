package leetcode;

public class Solution860 {
    public static boolean lemonadeChange(int[] bills) {
        int numOf5 = 0;
        int numOf10 = 0;
        //等于20的拿回来也不能找零，不用记录
        int len = bills.length;
        for(int i = 0; i < len;i++){
            int cost = bills[i];
            if(cost == 10) {
                numOf10++;
            }else if(cost == 5){
                numOf5++;
            }
            cost -= 5;
            while (cost > 0){
                if(cost >= 10){
                    if (numOf10 > 0){
                        cost -= 10;
                        numOf10--;
                    }else if(numOf5 > 0){
                        cost -= 5;
                        numOf5--;
                    }else{
                        return false;
                    }
                }else if(cost >= 5){
                    if(numOf5 > 0){
                        cost -= 5;
                        numOf5--;
                    }else{
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int bills[] = new int[]{5, 5 ,10};
        System.out.println(lemonadeChange(bills));
    }
}

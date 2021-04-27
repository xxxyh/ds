package zhousai;

public class Solution1835 {
    public int getXORSum(int[] arr1, int[] arr2) {
        int res1 = 0;
        for(int i = 0;i < arr1.length;i++){
            res1 ^= arr1[i];
        }

        int res2 = 0;
        for(int i = 0;i < arr2.length;i++){
            res2 ^= arr2[i];
        }

        return res1 & res2;
    }
    public int getXORSum2(int[] arr1, int[] arr2) {
        int res = 0;
        for(int i = 0;i < arr1.length;i++){
            for(int j = 0;j < arr2.length;j++){
                res ^= arr1[i] & arr2[j];
            }
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(new Solution1835().getXORSum(new int[]{1,2,3,4,5,6}, new int[]{7,9}));
        System.out.println(new Solution1835().getXORSum2(new int[]{1,2,3,4,5,6}, new int[]{7,9}));
    }
}

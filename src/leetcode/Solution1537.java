package leetcode;

public class Solution1537 {

    public int maxSum(int[] nums1, int[] nums2) {
        long result = 0;
        int i = 0, j = 0;
        long s1 = 0, s2 = 0;
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] < nums2[j]){
                s1 += nums1[i++];
            }else if(nums1[i] > nums2[j]){
                s2 += nums2[j++];
            }else{
                s1 += nums1[i++];
                s2 += nums2[j++];
                result += Math.max(s1, s2);
                s1 = 0;
                s2 = 0;
            }
        }
        while(i < nums1.length){
            s1 += nums1[i++];
        }
        while(j < nums2.length){
            s2 += nums2[j++];
        }
        result += Math.max(s1, s2);
        return (int)(result % (1000000007));
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,4,5,8,9,11,19};
        int[] nums2 = new int[]{2,3,4,11,12};
        System.out.println(new Solution1537().maxSum(nums1, nums2));
    }
}

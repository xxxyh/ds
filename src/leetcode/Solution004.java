package leetcode;

public class Solution004 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int left = (m + n + 1) / 2;
        int right = (m + n + 2) / 2;

        if(n == 0){
            return (double)(nums2[left - 1] + nums2[right - 1]) / 2;
        }
        if(m == 0){
            return (double)(nums1[left - 1] + nums1[right - 1]) / 2;
        }

        return (double)(findKth(nums1, 0, nums2, 0, left) + findKth(nums1, 0, nums2, 0, right)) / 2;
    }

    private int findKth(int[] nums1, int i, int[] nums2, int j, int k){
        if(i >= nums1.length){
            return nums2[j + k - 1];
        }
        if(j >= nums2.length){
            return nums1[i + k - 1];
        }
        if(k == 1){
            return Math.min(nums1[i], nums2[j]);
        }
        int midVal1 = (i + k / 2 - 1 < nums1.length) ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
        int midVal2 = (j + k / 2 - 1 < nums2.length) ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;
        if(midVal1 < midVal2){
            return findKth(nums1, i + k / 2, nums2, j, k - k / 2);
        }else{
            return findKth(nums1, i, nums2, j + k / 2, k - k / 2);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution004().
                findMedianSortedArrays(new int[]{3}, new int[]{-2,-1}));
    }
}

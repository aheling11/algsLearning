package leetcode;

import java.math.BigDecimal;

class numTriplets {
    public static int numTriplets(int[] nums1, int[] nums2) {
        int res = 0;
        for(int i = 0; i < nums1.length; i++){
            long temp = nums1[i] * nums1[i];
            for(int j = 0; j < nums2.length; j++){
                for(int k = j + 1; k < nums2.length; k++){
                    if(temp == nums2[j] * nums2[k]){
                        res++;
                    }
                }
            }
        }
        for(int i = 0; i < nums2.length; i++){
            long temp = nums2[i] * nums2[i];
            for(int j = 0; j < nums1.length; j++){
                for(int k = j + 1; k < nums1.length; k++){
                    if(temp == nums1[j] * nums1[k]){
                        res++;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = new int[]{43024,99908};
        int[] b = new int[]{1864};

        int i = numTriplets(a, b);
        System.out.println(i);
    }


}
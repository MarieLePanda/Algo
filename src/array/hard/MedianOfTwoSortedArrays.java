/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package array.hard;

/**
 *
 * @author lgirardin
 */
public class MedianOfTwoSortedArrays {
    //https://leetcode.com/problems/median-of-two-sorted-arrays/
}

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // [1,3,5,10,17,18,]
        int[] merged = merge(nums1, nums2); 
        int indexMiddle = merged.length / 2;
        //[1,2,3,4] middle = 2 [1]+[2]/2
        //[1,2,3,4,5] middle = 2
        //[1] middle = 0
        if(merged.length % 2 == 0){
            return (double) (merged[indexMiddle-1] + merged[indexMiddle])/2;
        }else{
            return (double) merged[indexMiddle];
        }
    }
    
    public int[] merge(int[] nums1, int[] nums2){
        int[] merged = new int[nums1.length + nums2.length];
        int i = 0;
        int j = 0;
        // nums1[1,4,8]
        // nums2[2,4,7]
        // merge [1]

        // nums1[4,8]
        // nums2[2,4,7]
        // merge [1, 2]
        
        // nums1[4,8]
        // nums2[4,7]
        // merge [1, 2, 4]

        // nums1[8]
        // nums2[4,7]
        // merge [1, 2, 4, 4]

        // nums1[8]
        // nums2[7]
        // merge [1, 2, 4, 4, 7]
        
        // nums1[8]
        // nums2[]
        // merge [1, 2, 4, 4, 7, 8]


        while(i < nums1.length && j < nums2.length){
            if(nums1[i] < nums2[j]){
                merged[i+j] = nums1[i];
                i++;
            }else{
                merged[i+j] = nums2[j];
                j++;
            }
        }
        
        if(i == nums1.length){
            for(; j < nums2.length; j++){
                merged[i+j] = nums2[j];
            }
        }else{
            for(; i < nums1.length; i++){
                merged[i+j] = nums1[i];
            }
        }
        
        return merged;
    }
}
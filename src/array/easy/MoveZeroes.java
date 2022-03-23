/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package array.easy;

/**
 *
 * @author lgirardin
 */
public class MoveZeroes {
    /*
    Given an integer array nums, move all 0's to the end of it while maintaining 
    the relative order of the non-zero elements.

    Note that you must do this in-place without making a copy of the array.



    Example 1:

    Input: nums = [0,1,0,3,12]
    Output: [1,3,12,0,0]

    Example 2:

    Input: nums = [0]
    Output: [0]



    Constraints:

        1 <= nums.length <= 104
        -231 <= nums[i] <= 231 - 1


    Follow up: Could you minimize the total number of operations done?
    */
    public static void main(String ... args){
        int[] nums1 = {0,1,0,3,12};
        int[] nums2 = {0};
        
        System.out.println("nums1");
        Solution.moveZeroes(nums1);
        for(int n : nums1)
            System.out.println(n);
        
        System.out.println("nums2");
        Solution.moveZeroes(nums2);
        for(int n : nums2)
            System.out.println(n);

    }
    
}

class Solution {
    public static void moveZeroes(int[] nums) {
        int size = nums.length;
        
        for(int i = 0; i < size; i++){
            if(nums[i] == 0 ){
                for(int j = i; j < size-1; j++){
                    nums[j] = nums[j+1];
                }
                size--;
                nums[size] = 0;
                i--;
            }
        }
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package array.easy;

import java.util.Arrays;

/**
 *
 * @author lgirardin
 */
public class SortArrayByParity {

    /*
    Given an integer array nums, move all the even integers at the beginning of 
    the array followed by all the odd integers.

    Return any array that satisfies this condition.



    Example 1:

    Input: nums = [3,1,2,4]
    Output: [2,4,3,1]
    Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.

    Example 2:

    Input: nums = [0]
    Output: [0]



    Constraints:

        1 <= nums.length <= 5000
        0 <= nums[i] <= 5000


    */
    public static void main(String ... args){
        int[] nums1 = {3,1,2,4};
        int[] nums2 = {0};
        
        System.out.println("nums2, expected: [2,4,3,1] Result:" + Arrays.toString(Solution.sortArrayByParity(nums1)));
        System.out.println("nums2, expected: [0] Result:" + Arrays.toString(Solution.sortArrayByParity(nums2)));

        System.out.println("nums2, expected: [2,4,3,1] Result:" + Arrays.toString(Solution.sortArraybyParityQuickSort(nums1)));
        System.out.println("nums2, expected: [0] Result:" + Arrays.toString(Solution.sortArraybyParityQuickSort(nums2)));

    }
    
}

class Solution {
    public static int[] sortArrayByParity(int[] nums) {
        int evenIndex = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] % 2 == 0){
                int toMove = nums[i];
                for(int j = i; j > evenIndex; j--){
                    nums[j] = nums[j-1];
                }
                nums[evenIndex] = toMove;
                evenIndex++;
            }
        }
        
        return nums;
    }
    
    public static int[] sortArraybyParityQuickSort(int[] nums){
        int i = 0;
        int j = nums.length -1;
        
        while(i < j){
            int cond1 = nums[i] % 2;
            int cond2 = nums[j] %2;
            if(cond1 > cond2){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
            
            if(nums[i] % 2 == 0)
                i++;

            if(nums[j] % 2 == 1)
                j--;                        
        }
        
        return nums;
    }
}
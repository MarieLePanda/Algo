/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP.easy;

import java.util.HashMap;

/**
 *
 * @author lgirardin
 */
public class ClimbingStairs {
    /*
    You are climbing a staircase. It takes n steps to reach the top.

    Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?



    Example 1:

    Input: n = 2
    Output: 2
    Explanation: There are two ways to climb to the top.
    1. 1 step + 1 step
    2. 2 steps

    Example 2:

    Input: n = 3
    Output: 3
    Explanation: There are three ways to climb to the top.
    1. 1 step + 1 step + 1 step
    2. 1 step + 2 steps
    3. 2 steps + 1 step



    Constraints:

        1 <= n <= 45


    */
}

class Solution {
    //HahsMap to memorize value already calculated <Stair number, number of way>
    private HashMap<Integer, Integer> memo = new HashMap<>();
    
    public int climbStairs(int n) {
        //To clinb the stair 1 there is one way (1)
        //To climb the stair 2 there is 2 way (1 + 1 or 2 + 2)
        if(n == 1 || n == 2)
            return n;
        
        //If my stair number was never calculate In must calculate it
        if(!memo.containsKey(n))
            //The stair n is the result of stair n-1 and n-2
            // Stair 3 = 3 = 1 (stair 1) + 1 + 1 (stair 2) or
            // Stair 3 = 3 = 1 (stair 1) + 2  (stair 2)
            //The result is save to be reuse in the futur
            memo.put(n,climbStairs(n-1) + climbStairs(n-2));

        return memo.get(n);
    }
}
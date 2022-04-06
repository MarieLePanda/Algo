/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package array.hard;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 *
 * @author lgirardin
 */
public class ShortestPathInAGridWithObstaclesElimination {
    /*
    You are given an m x n integer matrix grid where each cell is either 0 (empty) 
    or 1 (obstacle). You can move up, down, left, or right from and to an empty 
    cell in one step.

    Return the minimum number of steps to walk from the upper left corner (0, 0) 
    to the lower right corner (m - 1, n - 1) given that you can eliminate at most 
    k obstacles. If it is not possible to find such walk return -1.



    Example 1:

    Input: grid = [[0,0,0],[1,1,0],[0,0,0],[0,1,1],[0,0,0]], k = 1
    Output: 6
    Explanation: 
    The shortest path without eliminating any obstacle is 10.
    The shortest path with one obstacle elimination at position (3,2) is 6. 
    Such path is (0,0) -> (0,1) -> (0,2) -> (1,2) -> (2,2) -> (3,2) -> (4,2).

    Example 2:

    Input: grid = [[0,1,1],[1,1,1],[1,0,0]], k = 1
    Output: -1
    Explanation: We need to eliminate at least two obstacles to find such a walk.



    Constraints:

        m == grid.length
        n == grid[i].length
        1 <= m, n <= 40
        1 <= k <= m * n
        grid[i][j] is either 0 or 1.
        grid[0][0] == grid[m - 1][n - 1] == 0


    */
    
    public static void main(String ... args){
        int[][] grid1 = {{0,0,0},{1,1,0},{0,0,0},{0,1,1},{0,0,0}};
        int k1 = 1;
        
        System.out.println("Exemple 1, Expected: 6, Result:" + Solution.BFSSolution(grid1, k1));
        
        int[][] grid2 = {{0,1,1},{1,1,1},{1,0,0}};
        int k2 = 1;
        
        System.out.println("Exemple 2, Expected: -1, Result:" + Solution.BFSSolution(grid2, k2));

    }
}

class Solution{
    
    public static int BFSSolution(int[][] grid, int k){
    
        //Get the limit
        int rowSize = grid.length;
        int colSize = grid[0].length;
        //Get the objectif
        int[] target = {rowSize -1, colSize -1};
        
        //if I can reache the target with breaking wall
        if( k >= rowSize + colSize - 2)
            return rowSize + colSize -2;
        
        Queue<StepState> queue = new LinkedList<>();
        Set<StepState> seen = new HashSet<>();
        
        StepState start = new StepState(0, 0, 0, k);
        queue.add(start);
        
        while(queue.size() != 0){
            StepState current = queue.poll();
            seen.add(current);
            //System.out.println(current);
            
            if(target[0] == current.row && target[1] == current.col){
                return current.steps;
            }
            
            int[] nextSteps = new int[8];
            //step 1
            nextSteps[0] = current.row;
            nextSteps[1] = current.col+1;
            //step 2
            nextSteps[2] = current.row+1;
            nextSteps[3] = current.col;
            //step 3
            nextSteps[4] = current.row;
            nextSteps[5] = current.col-1;
            //step 4
            nextSteps[6] = current.row-1;
            nextSteps[7] = current.col;
            
            for(int i = 0; i < nextSteps.length; i = i + 2){
                int nextRow = nextSteps[i];
                int nextCol = nextSteps[i+1];
                
                //check if this position is outside from the grid
                if(nextRow < 0 || nextRow == rowSize
                   || nextCol < 0 || nextCol == colSize){
                    continue;
                }
              
                //Break the wall next if it's needed and possible
                int nextElimination = current.k - grid[nextRow][nextCol];
                
                //Register my new position (x, y, and break possible)
                StepState newState = new StepState(current.steps + 1, nextRow, nextCol, nextElimination);
                
                //Don't add the new test on my if I break a wall that was not possible to break
                //Or if I already pass in the place with this k number
                if(nextElimination >= 0 && !seen.contains(newState)){
                    queue.add(newState);
                }
            }
        }
        
        return -1;
    }
}

//Data object to keep the state info for each step
class StepState{
    
    public int steps;
    public int row;
    public int col;
    public int k;
    
    public StepState(int steps, int row, int col, int k){
        this.steps = steps;
        this.row = row;
        this.col = col;
        this.k = k;
    }
    
    @Override
    public int hashCode() {
        // needed when we put objects into any container class
        return (this.row + 1) * (this.col + 1) * this.k;
    }

    @Override
    public boolean equals(Object other) {
        /**
         * only (row, col, k) matters as the state info
         */
        if (!(other instanceof StepState)) {
            return false;
        }
        StepState newState = (StepState) other;
        return (this.row == newState.row) && (this.col == newState.col) && (this.k == newState.k);
    }

    @Override
    public String toString() {
        return String.format("%d %d %d", this.row, this.col, this.k);
    }
}

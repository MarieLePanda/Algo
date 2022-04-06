/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph.hard;

/**
 *
 * @author lgirardin
 */
public class BinaryTreeMaximumPathSum {
    //https://leetcode.com/problems/binary-tree-maximum-path-sum/
    //https://www.geeksforgeeks.org/find-level-maximum-sum-binary-tree/
    //https://www.geeksforgeeks.org/find-maximum-path-sum-two-leaves-binary-tree/
}


 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public int maxPathSum(TreeNode root) {
        MaxValue max = new MaxValue();
        return maxPathSumUtil(root, max);
    }
    
    public int maxPathSumUtil(TreeNode root, MaxValue max){
        if(root == null)
            return 0;
        
        if(root.left == null && root.right == null){
            return root.val;
        }
        
        int maxLeft = maxPathSumUtil(root.left, max);
        int maxRight = maxPathSumUtil(root.right, max);
        
        if(root.left != null && root.right!= null){

            if(max.val < (maxLeft + maxRight + root.val)){
                max.val = maxLeft + maxRight + root.val;
            }
        
            if( maxLeft < maxRight)
                return maxRight + root.val;
            else
                return maxLeft + root.val;
        }
        
        if(root.left == null)
            return maxRight + root.val;
        else
            return maxLeft + root.val;
    } 
}

class MaxValue{
    public int val;
    
    public MaxValue(){
        val = 0;
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 *
 * @author lgirardin
 */
public class StepByStepDirectionsFromABinaryTreeNodeToAnother {
    public static void main(String ... args){
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node4 = new TreeNode(4);
        
        node5.left = node1;
        node5.right = node2;
        node1.left = node3;
        node2.left = node6;
        node2.right = node4;

        System.out.println(Solution.getDirections(node5, 3, 6));
       
    }
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
    public static String getDirections(TreeNode root, int startValue, int destValue) {
        HashMap<ArrayList<TreeNode>, String> letterPath = new HashMap<>();
        ArrayList<TreeNode> shorterPathStart = Solution.getShorterPath(root, startValue, letterPath);
        ArrayList<TreeNode> shorterPathDest = Solution.getShorterPath(root, destValue, letterPath);
        
        return Solution.buildPath(startValue, destValue, shorterPathStart, shorterPathDest, letterPath);
    }
    
    public static ArrayList<TreeNode> getShorterPath(TreeNode root, int value, HashMap<ArrayList<TreeNode>, String> letterPath){
 
        Queue<ArrayList<TreeNode>> queue = new LinkedList<>(); 
        ArrayList<TreeNode> path = new ArrayList<>();
        path.add(root);
        letterPath.put(path, "");
        queue.add(path);
        
        while(!queue.isEmpty()){
            ArrayList<TreeNode> currentPath = queue.poll();
            TreeNode currentNode = currentPath.get(currentPath.size()-1);
            if(currentNode.val == value)
                return currentPath;
            
            if(currentNode.left != null){
                String letterCurrentPath = letterPath.get(currentPath);
                ArrayList<TreeNode> pathLeft = new ArrayList<>(currentPath);
                letterCurrentPath += "L";
                pathLeft.add(currentNode.left);
                letterPath.put(pathLeft, letterCurrentPath);
                queue.add(pathLeft);
            }
            if(currentNode.right != null){
                String letterCurrentPath = letterPath.get(currentPath);
                ArrayList<TreeNode> pathRight = new ArrayList<>(currentPath);
                letterCurrentPath += "R";
                pathRight.add(currentNode.right);
                letterPath.put(pathRight, letterCurrentPath);
                queue.add(pathRight);
            }   
        }

        return null;
    }
    
    public static String buildPath(int startVal, int destVal, 
            ArrayList<TreeNode> pathToStart, ArrayList<TreeNode> pathToDest, 
            HashMap<ArrayList<TreeNode>, String> letterPath){
        
        int LCA = -1;

        int i = 0;
        while (i < pathToDest.size() || i < pathToStart.size()){
            if(pathToStart.get(i).val != pathToDest.get(i).val)
                break;

            LCA = pathToStart.get(i).val;
            i++;
        }
        
        Collections.reverse(pathToStart);
        String result = "";
        for(TreeNode node : pathToStart){
            if(node.val == LCA)
                break;
            result += "U";
        }
        
        result += letterPath.get(pathToDest);
        return result;
    }
}
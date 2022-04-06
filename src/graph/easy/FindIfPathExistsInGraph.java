/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author lgirardin
 */
public class FindIfPathExistsInGraph {
    // https://leetcode.com/problems/find-if-path-exists-in-graph/
}

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {

        // {2, [1, 0]}
        // {0, [1, 2]}
        // {1, [2, 0]}
        Set<Integer> visited = new HashSet<>();
       HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for(int i = 0; i < edges.length; i++){
            int s = edges[i][0];
            int d = edges[i][1];
            
            if(!graph.containsKey(s)){
                ArrayList<Integer> otherNodes = new ArrayList<>();
                otherNodes.add(d);
                graph.put(s, otherNodes);
            }else{
                graph.get(s).add(d);
            }
            if(!graph.containsKey(d)){
                ArrayList<Integer> otherNodes = new ArrayList<>();
                otherNodes.add(s);
                graph.put(d, otherNodes);
            }else{
                graph.get(d).add(s);
            }
        }
        
        return DFS(source, destination, visited, graph);
        
    }
    
    public boolean DFS(int source, int destination, Set<Integer> visited,  HashMap<Integer, ArrayList<Integer>> graph)
    {
        //get node
        
        //If node == destination return true        
        if(source == destination)
            return true;
        
        // node visited
        visited.add(source);
        // get oter nodes
        ArrayList<Integer> otherNodes = graph.get(source);
        for(int node : otherNodes){
            if(!visited.contains(node)){
                boolean res = DFS(node, destination, visited, graph);
                if(res)
                  return true;
            }
            
        }
        
        
        return false;
        
    }
    

}
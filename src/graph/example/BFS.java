/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author lgirardin
 */
public class BFS {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> traverse = new ArrayList<>();
        Queue<Integer> path = new LinkedList<>();
        path.add(0);
        
        while(path.size() != 0){
            int currentNode = path.remove();
            if(!traverse.contains(currentNode))
                traverse.add(currentNode);
            for(int j = 0; j < adj.get(currentNode).size(); j++){
                if(!traverse.contains(adj.get(currentNode).get(j)))
                    path.add(adj.get(currentNode).get(j));
            }
        }
/*        for(int i = 0; i < adj.size(); i++){
            if(!traverse.contains(i))
                traverse.add(i);
            for(int j = 0; j < adj.get(i).size(); j++){
                if(!traverse.contains(j))
                    traverse.add(j);
            }
        }
  */      
        return traverse;
    }
}

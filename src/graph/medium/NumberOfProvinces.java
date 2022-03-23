/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph.medium;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author lgirardin
 */

public class NumberOfProvinces {



    public static void main(String ... args){
        
        int[][] isConnected = {{1,1,0}, {1,1,0}, {0,0,1}};
        Solution s = new Solution();
        s.findCircleNum(isConnected);
    }

    
}

class Solution {
    public int findCircleNum(int[][] isConnected) {
        
        DJ dj = new DJ(isConnected.length);
        
        for(int i = 0; i < isConnected.length; i++){
            for(int j = 0; j < isConnected[i].length; j++){
                if(isConnected[i][j] == 1 && i != j){
                    dj.union(i, j);
                }
            }
        }
        
        return dj.numberOfProvince();
        
    }
    
    class DJ{
        int[] rootArray;
        
        public DJ(int size){
            rootArray = new int [size];
            for(int i = 0; i < rootArray.length; i++ ){
                rootArray[i] = i;
            }
        }
        
        public int find(int node){
            if(node == rootArray[node]){
                return node;
            }
            
            node = find(rootArray[node]);
            return node;
        }
        
        public void union(int node, int otherNode){
            if(connected(node, otherNode))
                return;
            
            int rootNode = find(node);
            int rootOtherNode = find(otherNode);
            if(rootNode != rootOtherNode)
                rootArray[rootOtherNode] = node;
        }
        
        public int numberOfProvince(){
            Set<Integer> provinces = new HashSet<>();
            for(int i = 0; i < rootArray.length; i++){
                provinces.add(find(rootArray[i]));
            }
            
            return provinces.size();
        }
        
        public boolean connected(int x, int y){
            return find(x) == find(y);
        }
    }
}
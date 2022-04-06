/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph.medium;

/**
 *
 * @author lgirardin
 */
public class GraphValidTree {

    public static void main(String ... args){
        
        int[][] edge = {{0,1},{0,2},{0,3},{1,4}};
        Solution s = new Solution();
        System.out.println(s.validTree(5, edge));
    }
}
    class Solution {
       public boolean validTree(int n, int[][] edges) {
           DS ds = new DS(n);

           for(int i = 0; i < edges.length; i++){
               ds.union(edges[i][0], edges[i][1]);    
           }

           boolean[] validTree = new boolean[n];

           for(int i = 0; i < n; i++){
               for(int j = 0; j < n; j++){
                   if(i == j)
                       continue;
                   boolean connected = ds.isConnected(i,j);
                   if(connected == true && validTree[i] == true)
                       return false;
                   else if (connected){
                       validTree[i] = true;
                   }
               }
           }

           return true;
       }

       class DS{
           int[] rootArray;

           public DS(int size){
               rootArray = new int[size];
               for(int i = 0; i < size; i++){
                   rootArray[i] = i;
               }
           }

           public int find(int node){
               if(node == rootArray[node])
                   return node;

               return find(rootArray[node]);
           }

           public void union(int x, int y){
               int rootX = find(x);
               int rootY = find(y);

               if(rootX != rootY){
                   rootArray[y] = x;
               }
           }

           public boolean isConnected(int x, int y){
               return find(x) == find(y);
           }
       }
   }


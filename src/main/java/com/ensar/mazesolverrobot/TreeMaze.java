/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensar.mazesolverrobot;

/**
 *
 * @author ensar
 */

public class TreeMaze {
     
    private Vertex start, curr, end;
    
    private HashTable hashTable = new HashTable();

    public TreeMaze() {
    }  
    
    public void addVertex(int currDirection, int weight, short identifier, short x, short y){
        Vertex nVertex = new Vertex(identifier, x, y);
        if(start == null){
            start = nVertex;
            curr = nVertex;
            hashTable.add(nVertex);
        }
        else if(!hashTable.add(nVertex)){
            nVertex = (Vertex) hashTable.getCachedData();
            Edge nEdge = new Edge(weight, curr, nVertex);
            curr.setEdge(nEdge, currDirection);
            nVertex.setEdge(nEdge, Direction.reverseDirection(currDirection));
            curr = nVertex;
        }
        else{
            Edge nEdge = new Edge(weight, curr, nVertex);
            curr.setEdge(nEdge, currDirection);
            nVertex.setEdge(nEdge, Direction.reverseDirection(currDirection));
            curr = nVertex;
        }

    }

    public Vertex getOtherVertex(int index){
        return curr.edges[index].v1 == curr? curr.edges[index].v2:curr.edges[index].v1;
    }

    public boolean changeVertex(int index){
        curr = getOtherVertex(index);
        return true;
    }

    
    public Vertex getCurr(){
        return curr;
    }

    public void setCurr(Vertex curr) {this.curr = curr;}
    
    public Vertex getStart(){
        return start;
    }
    
    public Vertex getEnd(){
        return end;
    }
    
    public void markAsEnd(){
        end = curr;
    }

    public HashTable getHashMap(){
        return hashTable;
    }

}

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
public class Vertex implements Hashable{
    public Edge edges [] = new Edge[4];
    public boolean start, end;
    final public short identifier;
    final public short vX, vY;
    public byte visitCounter = 0;
    public Vertex(short identifier, short x, short y) {
        this.identifier = identifier;
        this.vX = x;
        this.vY = y;
    }
    
    public Vertex getVertex(int direction){
        Edge edge = edges[direction];
        return !edge.v1.equals(this)? edge.v1:edge.v2;
    }
    
    public void setEdge(Edge edge, int direction){
        edges[direction] = edge;
    }

    @Override
    public int hash() {
        int x = (int) vX;
        int y = (int) vY;
        
        return (x << 8) | y;
    }

    @Override
    public String toString(){
        return vX + " " + vY;
    }

    @Override
    public boolean equals(Object obj) {
        Vertex v = (Vertex) obj;
        return v != null && v.hash() == this.hash();
    }
}


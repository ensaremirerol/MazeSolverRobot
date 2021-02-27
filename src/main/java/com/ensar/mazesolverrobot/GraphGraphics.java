package com.ensar.mazesolverrobot;

import java.awt.*;

public class GraphGraphics extends Canvas {
    int MULTIPILER = 50;
    HashMap vertexes;
    public GraphGraphics(HashMap vertexes){
        this.vertexes = vertexes;
    }
    public void paint(Graphics g){
        setBackground(Color.white);
        for(Hashable data: vertexes){
            Vertex vertex = (Vertex) data;
            Vertex oVertex;
            g.setColor(Color.black);
            g.drawOval(vertex.vX*MULTIPILER, vertex.vY * MULTIPILER,  MULTIPILER, MULTIPILER);
            for (int i = 0; i <4; i++){
                if(vertex.edges[i] != null){
                    oVertex = vertex.getVertex(i);
                    int xMid = (Math.abs(vertex.vX - oVertex.vX) - MULTIPILER)/ 2;
                    int yMid = (Math.abs(vertex.vY - oVertex.vY) - MULTIPILER) / 2;
                    g.drawLine(vertex.vX*MULTIPILER +MULTIPILER/2, vertex.vY*MULTIPILER+MULTIPILER/2,
                            oVertex.vX*MULTIPILER+MULTIPILER/2, oVertex.vY*MULTIPILER+MULTIPILER/2);
                }
            }
        }
    }
}

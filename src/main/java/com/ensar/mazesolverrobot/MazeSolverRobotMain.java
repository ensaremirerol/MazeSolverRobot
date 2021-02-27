package com.ensar.mazesolverrobot;

import java.util.Iterator;

public class MazeSolverRobotMain {
    public static void main(String[] args) {
        int [][] m =
                {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 1, 0, 0, 0, 1},
                {1, 0, 1, 1, 0, 1, 0, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 0, 1, 0, 1, 0, 1},
                {1, 0, 0, 1, 0, 0, 0, 1, 0, 1},
                {1, 0, 1, 0, 0, 1, 1, 1, 0, 1},
                {1, 0, 1, 1, 0, 1, 1, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
        Maze maze = new Maze(m);
        Explorer explorer = new Explorer(maze, (short)1,(short)1);
        explorer.explore();
        for (Hashable data : explorer.graph.getHashMap()) {
            System.out.println(data);
        }
    }
}

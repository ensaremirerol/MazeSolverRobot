package com.ensar.mazesolverrobot;

class DijkstraData{
    Vertex data;
    Vertex from;
    int weight;
    boolean visited;

    public DijkstraData(Vertex data){
        this.data = data;
        this.weight = Integer.MAX_VALUE;
    }
}
public class Dijkstra {
    private DijkstraData [] dijkstraData;
    private static int from;
    private static int currData;

    public Dijkstra(HashTable vertices, Vertex currentVertex){
        dijkstraData = new DijkstraData[vertices.getSize()];
        int i = 0;
        for(Hashable data: vertices){
            Vertex v = (Vertex) data;
            dijkstraData[i] = new DijkstraData(v);
            if(v.equals(currentVertex)) currData = i;
            i++;
        }
        from = currData;
    }

    private void initDijkstra(){
        dijkstraData[from].visited = true;
        dijkstraData[from].weight = -1;
        for (int i = 0; i < 4; i++){
            if (dijkstraData[from].data.edges[i] != null){
                Vertex oV = dijkstraData[from].data.getVertex(i);
                for (DijkstraData item: dijkstraData){
                    if (item.data.equals(oV)){
                        item.weight = dijkstraData[from].data.edges[i].weight;
                        item.from = dijkstraData[from].data;
                    }
                }
            }
        }
    }

    private int getMin(){
        int minVal = Integer.MAX_VALUE;
        int minIndex = -1;
        for(int i = 0; i<dijkstraData.length; i++){
            if(dijkstraData[i].weight < minVal && !dijkstraData[i].visited){
                minVal = dijkstraData[i].weight;
                minIndex = i;
            }
        }
        return  minIndex;
    }

    public Vertex getClosestNull(){
        initDijkstra();
        Vertex retVal;
        for (int i = 0; i < dijkstraData.length; i++){
            currData = getMin();
            if(currData == -1){
                return null;
            }
            retVal = dijkstraData[currData].data;
            if(((retVal.identifier & Direction.NORTH) == Direction.NORTH && retVal.edges[0] == null) ||
                    ((retVal.identifier & Direction.EAST) == Direction.EAST && retVal.edges[1] == null) ||
                    ((retVal.identifier & Direction.SOUTH) == Direction.SOUTH && retVal.edges[2] == null) ||
                    ((retVal.identifier & Direction.WEST) == Direction.WEST && retVal.edges[3] == null)){
                return retVal;
            }
            dijkstraData[currData].visited = true;
            for (int j = 0; j < 4; j++){
                if(retVal.edges[j] != null){
                    Vertex oV = retVal.getVertex(j);
                    for (DijkstraData item: dijkstraData){
                        if (item.data.equals(oV) && item.weight > retVal.edges[j].weight){
                            item.weight = dijkstraData[currData].data.edges[j].weight;
                            item.from = dijkstraData[currData].data;
                        }
                    }
                }
            }
        }
        return null;

    }


}

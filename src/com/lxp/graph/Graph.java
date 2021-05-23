package com.lxp.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graph {
    private List<String> vertexList = new ArrayList<String>();
    private int[][] edges;
    private int count;

    public Graph(String vertexs) {
        String[] split = vertexs.split(",");
        for (String s : split) {
            vertexList.add(s);
        }
        count = split.length;
        edges = new int[count][count];
    }

    public static void main(String[] args) {
        Graph graph = new Graph("A,B,C,D,E");
        graph.addEdges(0,1,1);
        graph.showEdges();
    }

    public void showEdges(){
        for (int[] edge : edges) {
            System.out.println(Arrays.toString(edge));
        }
    }

    public int getEdges(int v1,int v2){
        return edges[v1][v2];
    }

    public void addEdges(int v1,int v2,int value){
        edges[v1][v2] = value;
        edges[v2][v1] = value;
    }

}

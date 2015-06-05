package com.test.algo.graph;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

    private int data;
    private boolean isVisited;
    private List<Vertex> virtexs =  new ArrayList<Vertex>();

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public List<Vertex> getVirtexs() {
        return virtexs;
    }

    public void setVirtexs(Vertex v) {
        this.virtexs.add(v);
    }
}

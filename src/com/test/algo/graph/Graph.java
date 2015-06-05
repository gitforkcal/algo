package com.test.algo.graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    private List<Vertex> virtises = new ArrayList<Vertex>();

    public List<Vertex> getVirtises() {
        return virtises;
    }

    public void addVirtex(Vertex v) {
        this.virtises.add(v);
    }

    public Vertex getFirstNode() {
        return virtises.get(0);
    }
}

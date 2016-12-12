package com.company;

/**
 * Created by d.lihodedov on 12.12.2016.
 */
public class Vertex {
    JQueue queue = new JQueue(100);
    private String label;
    public boolean isVisited;

    public Vertex(String label)
    {
        this.label = label;
        isVisited = false;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean isVisited) {
        this.isVisited = isVisited;
    }

}

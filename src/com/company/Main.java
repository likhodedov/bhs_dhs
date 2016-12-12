package com.company;

public class Main {

    public static void main(String[] args) {
	Graph mygraph = new Graph();
        for (int i=0;i<100;i++){
            String name ="Vershina_"+i;
            mygraph.addVertex(name);
        }
mygraph.bfs(5);
System.out.println("-----------");
mygraph.dfs(7);

    }




}

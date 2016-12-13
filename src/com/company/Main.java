package com.company;

public class Main {

    public static void main(String[] args) {
	Graph mygraph = new Graph();
        for (int i=0;i<100;i++){
            String name ="Vershina_"+i;
            mygraph.addVertex(name);
        }
        long start= System.nanoTime();
mygraph.bfs(5);
        long finish=System.nanoTime();

System.out.println("-----------");
        long start2= System.nanoTime();
mygraph.dfs(7);
        long finish2=System.nanoTime();
        System.out.println(finish-start);
        System.out.println(finish2-start2);
    }




}

package Graphs;

import java.util.ArrayList;

import Hashing.validAnagram;
import Queue.circularqueueUsingArr;

public class hasPath {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0 - vertex
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        // 1 - vertex
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        // 2vertex
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        // 3vertex
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        // 4vertex
        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));
       
        graph[5].add(new Edge(6, 5, 1));
    }

    public static boolean hasPaths(ArrayList<Edge>[] graph,int src , int dest , boolean vis[]){
        if(src == dest){
            return true;
        }
        vis[src] = true;

        for(int i = 0 ; i < graph[src].size();i++){
                 Edge e = graph[src].get(i);
                 if(!vis[e.dest] && hasPaths(graph, e.dest, dest, vis)){
                    return true;
                 }
        }
        return false;
    }

    public static void main(String[] args) {
          int V = 7;
        // array of arraylist
        ArrayList<Edge>[] graph = new ArrayList[V]; // null--> empty arraylist
        createGraph(graph);
        System.out.println(hasPaths(graph, 0, 5, new boolean[V]));
    }
}

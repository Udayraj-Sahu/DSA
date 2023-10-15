package Graphs;

import java.util.ArrayList;

public class cycleDetection {
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

    public static boolean detectCycle(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (detectCycleUtil(graph, vis, i, -1)) {
                    return true;
                }

            }
        }
        return false;

    }

    public static boolean detectCycleUtil(ArrayList<Edge>[] graph, boolean vis[], int curr, int parent) {
         vis[curr] = true;
         for(int i = 0 ; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            //case 3
            if(!vis[e.dest]) {
                if(detectCycleUtil(graph,vis,e.dest,curr))
                return true;
            }
            //case1
            else if(vis[e.dest] && e.dest != parent){
                return true;

            }
            //case 2 -> do nothing -> continue
         }
         return false;
    }

    public static void main(String[] args) {
        int V = 7;
        // array of arraylist
        ArrayList<Edge>[] graph = new ArrayList[V]; // null--> empty arraylist
        createGraph(graph);
        System.out.println(detectCycle(graph));
    }
}

/**
 * The TopologicalSorting class implements topological sorting of a directed graph using both DFS and
 * BFS algorithms.
 */
package Graphs;

import java.util.*;

public class TopologicalSorting {
    static class Edge {
        int src;
        int dest;
        int weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[2].add(new Edge(2, 3, 1));

        graph[3].add(new Edge(3, 1, 1));

        graph[4].add(new Edge(4, 0, 1));
        graph[4].add(new Edge(4, 1, 1));

        graph[5].add(new Edge(5, 0, 1));
        graph[5].add(new Edge(5, 2, 1));
    }

    // Topological sort using DFS algorithm
    public static void topSort(ArrayList<Edge>[] graph) {
        boolean[] vis = new boolean[graph.length];
        Stack<Integer> s = new Stack<Integer>();

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                topSortUtil(graph, i, vis, s);
            }
        }

        while (!s.isEmpty()) {
            System.out.println(s.pop() + " ");
        }
    }

    public static void topSortUtil(ArrayList<Edge>[] graph, int curr, boolean[] vis, Stack<Integer> stack) {
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if (!vis[e.dest]) {
                topSortUtil(graph, e.dest, vis, stack);
            }
        }

        stack.push(curr);
    }

    // Topological sort Using BFS (Kahn's algorithm)
   // The `calcIndeg` method calculates the in-degree of each vertex in the graph. The in-degree of a
   // vertex is the number of incoming edges to that vertex. It takes an array of ArrayLists `graph`
   // representing the graph and an array `indeg` to store the in-degree of each vertex. It iterates
   // over each vertex in the graph and for each vertex, it iterates over its adjacent vertices and
   // increments the in-degree of the destination vertex of each edge.
    public static void calcIndeg(
            ArrayList<Edge>[] graph, int indeg[]) {
            for(int i= 0 ; i < graph.length;i++) {
                int v = i;
                for(int j = 0 ; j < graph[v].size();j++) {
                    Edge e = graph[v].get(j);
                    indeg[e.dest]++;
                }
            }
    }

    public static void topSortBFS(ArrayList<Edge>[] graph) {
        int indeg[] = new int[graph.length];
        calcIndeg(graph, indeg);
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0 ; i < indeg.length;i++){
            if(indeg[i] ==0){
                q.add(i);
            }
        }

        //bfs
        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr+" ");


            for(int i= 0 ; i< graph[curr].size();i++){
                Edge e = graph[curr].get(i);
                indeg[e.dest]--;
                if(indeg[e.dest] == 0){
                    q.add(e.dest);
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        topSortBFS(graph);
    }
}

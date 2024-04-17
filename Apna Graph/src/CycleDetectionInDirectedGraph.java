import java.util.ArrayList;

public class CycleDetectionInDirectedGraph {
    static class Edge{
        int src;
        int dest;
        Edge(int src,int dest){
            this.src = src;
            this.dest = dest;
        }
    }
    static void create(ArrayList<Edge>[] graph){
        for (int i =0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        // cycle exist in this graph
        graph[0].add(new Edge(0,2));
        graph[1].add(new Edge(1,0));
        graph[2].add(new Edge(2,3));
        graph[3].add(new Edge(3,0));

    }
    static void create2(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // no cycle graph
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,3));
        graph[2].add(new Edge(2,3));
        //        graph[0].add(new Edge(0,1));
    }
    // O(V+E)
    public static boolean isCycle(ArrayList<Edge>[] graph){
        boolean[] vis = new boolean[graph.length];
        boolean[] stack = new boolean[graph.length];

        for (int i = 0; i<graph.length; i++){
            if (!vis[i]){
                if (isCycleUtil(graph,i,vis,stack)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean isCycleUtil(ArrayList<Edge>[] graph, int curr,boolean[] vis,boolean[] stack){
        vis[curr] = true;
        stack[curr] = true;

        for (int i =0 ; i< graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            // case:1
            if (stack[e.dest]){ // if curr node neigbhour are already true in stack mean cycle exist
                return true;
            }
            // case:2
            if (!vis[e.dest] && isCycleUtil(graph,e.dest,vis,stack)){
                return true;
            }
        }
        stack[curr] = false;
        return false;
    }
    public static void main(String[] args) {
        int v = 4;
        ArrayList<Edge>[] graph = new ArrayList[v];
        create2(graph);
        System.out.println(isCycle(graph));
    }
}

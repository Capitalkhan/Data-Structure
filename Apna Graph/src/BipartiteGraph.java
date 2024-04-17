import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {
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

        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,1));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,3));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,4));

        graph[3].add(new Edge(3,1));
//        graph[3].add(new Edge(3,4));

        graph[4].add(new Edge(4,2));
//        graph[4].add(new Edge(4,3));
    }
    // O(V+E)
    public static boolean isBipartite(ArrayList<Edge>[] graph){
        int[] col = new int[graph.length];
        for (int i =0; i<col.length; i++){
            col[i] = -1; // no color
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i =0; i<graph.length; i++){ // BFS
            if (col[i] == -1){
                q.add(i);
                col[i] = 0; // yellow color
                while (!q.isEmpty()){
                    int curr = q.remove();
                    for (int j = 0; j<graph[curr].size(); j++){
                        Edge e = graph[curr].get(j);
                        if (col[e.dest] == -1){
                            int nextCol = col[curr] == 0 ? 1 : 0; // 0 mean blue
                            col[e.dest] = nextCol;
                            q.add(e.dest);
                        }else if(col[e.dest] == col[curr]){
                            return false; // not bipartite graph
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        // we use BFS tecnigue
        // if graph have dos,nt cycle then this graph is Bipartite
        // if node are even the return true
        // if node are odd the return true

        int v = 5;
        ArrayList<Edge>[] graph = new ArrayList[v];
        create(graph);
        System.out.println(isBipartite(graph));
    }
}

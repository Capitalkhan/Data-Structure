import java.util.ArrayList;

public class ConnectedComponents {
    static class Edge{
        int src;
        int dest;
        int w;
        Edge(int src,int dest,int w){
            this.src = src;
            this.dest = dest;
            this.w = w;
        }
    }

    static void create(ArrayList<Edge>[] graph){
        for (int i =0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,1,1));
        graph[0].add(new Edge(0,2,1));

        graph[1].add(new Edge(1,0,1));
        graph[1].add(new Edge(1,3,1));

        graph[2].add(new Edge(2,0,1));
        graph[2].add(new Edge(2,4,1));

        graph[3].add(new Edge(3,1,1));
        graph[3].add(new Edge(3,4,1));
        graph[3].add(new Edge(3,5,1));

        graph[4].add(new Edge(4,2,1));
        graph[4].add(new Edge(4,3,1));
        graph[4].add(new Edge(4,5,1));

        graph[5].add(new Edge(5,3,1));
        graph[5].add(new Edge(5,4,1));
        graph[5].add(new Edge(5,6,1));

        graph[6].add(new Edge(6,5,1));

    }
    static void dfs(ArrayList<Edge>[] graph){
        boolean[] vis = new boolean[graph.length];
        for (int i =0; i < graph.length; i++){
            dfsUtils(graph, i, vis);
        }
    }
    static void dfsUtils(ArrayList<Edge>[] graph,int curr,boolean[] vis){
        System.out.print(curr+" ");
        vis[curr] = true;

        for (int i =0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]){
                dfsUtils(graph,e.dest,vis);
            }
        }
    }

    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge>[] graph = new ArrayList[V];
        create(graph);
        dfs(graph);
    }
}

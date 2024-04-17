import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class HasPath {
    static class Edge{
        int src;
        int dest;
        int weight;
        Edge(int src,int dist,int weight){
            this.src = src;
            this.dest = dist;
            this.weight = weight;
        }
    }
    static void createGraph(ArrayList<Edge> graph[]){

        for (int i=0; i<graph.length; i++){
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

    static void bfs(ArrayList<Edge>[] graph){ // O(v+e) n = vertexes and e = edges (v,e control time complex of bfs
        // witch is more )
        Queue<Integer> q = new LinkedList<>();
        boolean vist[] = new boolean[graph.length];
        q.add(0); // source of graph

        while (!q.isEmpty()){
            int curr = q.remove();

            if (!vist[curr]){
                System.out.print(curr+" ");
                vist[curr] = true;
                for (int i =0; i<graph[curr].size(); i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }
    static boolean hasPath(ArrayList<Edge>[] graph,int scr,int dest,boolean[] vis){
        if (scr == dest){
            return true;
        }
        vis[scr] = true;
        for (int i =0; i < graph[scr].size(); i++){
            Edge e = graph[scr].get(i);
//            e.dest = neighbour
            if (!vis[e.dest] && hasPath(graph,e.dest,dest,vis)){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {

        int V = 7;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
//        System.out.println(hasPath(graph,0,5,new boolean[V]));
        System.out.println(hasPath(graph,0,7,new boolean[V]));
    }
}

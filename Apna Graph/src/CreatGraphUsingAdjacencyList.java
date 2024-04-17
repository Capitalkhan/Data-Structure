import java.util.ArrayList;

public class CreatGraphUsingAdjacencyList {
    static class Edge{
        int src;
        int dist;
        int weight;
        Edge(int src,int dist,int weight){
            this.src = src;
            this.dist = dist;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        // first we need to know no. of vertexes of graph
        int v = 5;
        ArrayList<Edge>[] graph = new ArrayList[5];

        for (int i =0; i<v; i++){
            graph[i] = new ArrayList<>();
        }
        // now store data
        graph[0].add(new Edge(0,1,5));

        graph[1].add(new Edge(1,2,1));
        graph[1].add(new Edge(1,3,3));

        graph[2].add(new Edge(2,1,1));
        graph[2].add(new Edge(2,3,1));
        graph[2].add(new Edge(2,4,2));

        graph[3].add(new Edge(3,1,3));
        graph[3].add(new Edge(3,2,1));

        graph[4].add(new Edge(4,2,2));

        // Question: find 2nd vertex neighbors
        for (int i=0; i<graph[2].size(); i++){
            Edge e = graph[2].get(i);
            System.out.println(e.dist);
        }




    }
}

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;



public class Adjasensy_List {

    private LinkedList <Integer> adjacency[];

    public Adjasensy_List(int v){
        adjacency = new LinkedList[v];
        
        for(int i = 0; i < v; i++){

            adjacency[i] = new LinkedList<Integer>();
        }
    }

    public void insertEdge(int s,int d) {
        
        adjacency[s].add(d);
        adjacency[d].add(s);

        // System.out.print(adjacency[d]);
        // System.out.print(adjacency[s]);
        // System.out.println();
    }

    public void bfs(int source){
        
        Boolean visited_Nodes[] = new Boolean[adjacency.length];
        int parent_Nodes[] = new int[adjacency.length];
        Queue<Integer> q = new LinkedList<>();

        q.add(source);

        visited_Nodes[source] = true;
        parent_Nodes[source] = -1;

        while(!q.isEmpty()){

            int p = q.poll();
            System.out.print(p);

            for(int i : adjacency[p]){

                if(visited_Nodes[i] != true){
                
                    visited_Nodes[i] = true;
                    q.add(i);
                    parent_Nodes[i] = p;
                
                }

                
            }
        }


    }

    public void Dfs(int source){
        
        Boolean visited_Nodes[] = new Boolean[adjacency.length];
        int parent_Nodes[] = new int[adjacency.length];
        Stack<Integer> q = new Stack<>();

        q.add(source);

        visited_Nodes[source] = true;
        parent_Nodes[source] = -1;

        while(!q.isEmpty()){

            int p = q.pop();
            System.out.print(p);

            for(int i : adjacency[p]){

                if(visited_Nodes[i] != true){
                
                    visited_Nodes[i] = true;
                    q.add(i);
                    parent_Nodes[i] = p;
                
                }

                
            }
        }


    }
    

    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Number of vertixes : ");
        int v = sc.nextInt();

        System.out.print("Enter Number of edges : ");
        int e = sc.nextInt();

        Adjasensy_List g = new Adjasensy_List(v);

        for(int i = 0; i < e; i++){

            System.out.print("Enter source : ");
            int s = sc.nextInt();

            System.out.print("Enter destination : ");
            int d = sc.nextInt();

            g.insertEdge(s,d);
        }


        System.out.println("Enter source of bfs : ");
        int source = sc.nextInt();

        g.bfs(source);
        g.Dfs(source);
    }
    
}
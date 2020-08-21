import java.util.Scanner;
import java.util.*;

public class Question3
{   
    // class data type for storing information regarding an edge 
    public static class Edge
    {
        int source, destination, weight;
    }


    // class called graph which has variables as vertices, edges and an array of type edge
    public static class Graph
    {
        int V, E;
        Edge edge[];
    }

    public static boolean isNegativeCycle(Graph graph, int source, int v1, int v2)
    {
        int V = graph.V;
        int E = graph.E;
        int[] dist = new int[V];

        for (int i = 0; i < V; i++)
            dist[i] = Integer.MAX_VALUE; //Initialize distances from source to all other vertices as INFINTE
        dist[source] = 0;

        for (int i = 1; i <= V - 1; i++)
        {
            for (int j = 0; j < E; j++)
            {
                int u = graph.edge[j].source;
                int v = graph.edge[j].destination;
                int weight = graph.edge[j].weight;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v])
                    dist[v] = dist[u] + weight;
            }
        }

        for (int i = 0; i < E; i++)
        {
            if(v1 == graph.edge[i].source && v2 == graph.edge[i].destination)
            {
                int weight = graph.edge[i].weight;
                if (dist[v1] != Integer.MAX_VALUE && dist[v1] + weight < dist[v2])
                    return true;
            }
        }
        return false;
    }

    private static void allPaths(int vertices, int source, int destination, boolean[][] g, ArrayList<Integer> v,
            int distance, boolean[] visited) {
        v.add(source);
        visited[source] = true;
        if (source == destination) {
            System.out.print("\nPath: ");
            for (Integer integer : v) {
                System.out.print(integer + 1 + " ");
            }
            System.out.println("\nDistance From Source: " + distance);
            visited[source] = false;
            v.remove(v.size() - 1);
            return;
        }

        for (int i = 0; i < vertices; i++) {
            if (visited[i] == false && g[source][i]) {
                allPaths(vertices, i, destination, g, v, distance + 1, visited);
            }
        }
        visited[source] = false;
        v.remove(v.size() - 1);
    }


    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        int V = sc.nextInt();
        System.out.print("Enter the number of edges: ");
        int E = sc.nextInt();
        System.out.println();
        
        // creatig the graph, given the number of vertices and edges
        Graph graph = new Graph();
        graph.V = V;
        graph.E = E;
        graph.edge = new Edge[graph.E];

        for (int i = 0; i < graph.E; i++)
        {
            graph.edge[i] = new Edge();
        }
        

        //Taking input for the values of Graph
        for(int i=0; i<E; i++)
        {
            System.out.print("Enter the first vertex: ");
            graph.edge[i].source = sc.nextInt();

            System.out.print("Enter the second vertex: ");
            graph.edge[i].destination = sc.nextInt();

            System.out.print("Enter the weight of the edge: ");
            graph.edge[i].weight = sc.nextInt();

            System.out.println();
        }


        // vetices should be numbered from 1 to n
        // not 0 to n-1
        System.out.print("Enter the source node: ");
        int v1 = sc.nextInt();
        System.out.print("Enter the destination node: ");
        int v2 = sc.nextInt();

        System.out.println();

        if(isNegativeCycle(graph, 0, v1, v2))
            System.out.println("Negative Cycle Exists");
        else
        {   
            // a boolean array to maintain a list of all the vertices that have been visited
            boolean[] visited = new boolean[V];
            ArrayList<Integer> pathList = new ArrayList<>();
            boolean[][] g = new boolean[V][V];
            for (Edge e : graph.edge) {
                g[e.source-1][e.destination-1] = true;
        }
            // printAllPaths(graph, v1, v2, isVisited, pathList);
            allPaths(V, v1-1, v2-1, g, pathList, 0, visited);
        }
    }
}

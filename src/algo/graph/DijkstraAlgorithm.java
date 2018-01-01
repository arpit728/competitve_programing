package algo.graph;

import java.util.*;

/**
 * Created by Arpit on 13-Dec-15.
 */
public class DijkstraAlgorithm {

    private int[] distances;
    private Set<Integer> settled;
    private Set<Integer> unsettled;
    private int number_of_nodes;
    private int adjacencyMatrix[][];

    public DijkstraAlgorithm(int number_of_nodes){

        this.number_of_nodes = number_of_nodes;
        distances = new int[number_of_nodes + 1];
        settled = new HashSet<Integer>();
        unsettled = new HashSet<Integer>();
        adjacencyMatrix = new int[number_of_nodes + 1][number_of_nodes + 1];
    }

    public void dijkstra_algorithm(int adjacency_matrix[][], int source){
        int evaluationNode;
        for (int i = 1; i <= number_of_nodes; i++)
            for (int j = 1; j <= number_of_nodes; j++)
                adjacencyMatrix[i][j] = adjacency_matrix[i][j];

        for (int i = 1; i <= number_of_nodes; i++)
        {
            distances[i] = Integer.MAX_VALUE;
        }

        unsettled.add(source);
        distances[source] = 0;
        while (!unsettled.isEmpty())
        {
            evaluationNode = getNodeWithMinimumDistanceFromUnsettled();
            unsettled.remove(evaluationNode);
            settled.add(evaluationNode);
            evaluateNeighbours(evaluationNode);
            System.out.println(unsettled);
        }
    }

    private int getNodeWithMinimumDistanceFromUnsettled(){
        int min ;
        int node = 0;

        Iterator<Integer> iterator = unsettled.iterator();
        node = iterator.next();
        min = distances[node];
        for (int i = 1; i <= distances.length; i++)
        {
            if (unsettled.contains(i)){
                if (distances[i] <= min)
                {
                    min = distances[i];
                    node = i;
                }
            }
        }
        return node;
    }

    private void evaluateNeighbours(int evaluationNode){
        int edgeDistance = -1;
        int newDistance = -1;

        for (int destinationNode = 1; destinationNode <= number_of_nodes; destinationNode++)
        {
            if (!settled.contains(destinationNode))
            {
                if (adjacencyMatrix[evaluationNode][destinationNode] != Integer.MAX_VALUE){
                    edgeDistance = adjacencyMatrix[evaluationNode][destinationNode];
                    newDistance = distances[evaluationNode] + edgeDistance;
                    if (newDistance < distances[destinationNode])
                    {
                        distances[destinationNode] = newDistance;
                    }
                    unsettled.add(destinationNode);
                }
            }
        }
    }

    public static void main(String... arg)
    {
        int adjacency_matrix[][];
        int number_of_vertices;
        int source = 0;
        Scanner scan = new Scanner(System.in);
        try
        {
            System.out.println("Enter the number of vertices");
            number_of_vertices = scan.nextInt();
            adjacency_matrix = new int[number_of_vertices + 1][number_of_vertices + 1];

            System.out.println("Enter the Weighted Matrix for the graph");
            for (int i = 1; i <= number_of_vertices; i++)
            {
                for (int j = 1; j <= number_of_vertices; j++)
                {
                    adjacency_matrix[i][j] = scan.nextInt();
                    if (i == j)
                    {
                        adjacency_matrix[i][j] = 0;
                        continue;
                    }
                    if (adjacency_matrix[i][j] == 0)
                    {
                        adjacency_matrix[i][j] =  Integer.MAX_VALUE;
                    }
                }
            }

            System.out.println("Enter the source ");
            source = scan.nextInt();

            DijkstraAlgorithm dijkstrasAlgorithm = new DijkstraAlgorithm(number_of_vertices);
            dijkstrasAlgorithm.dijkstra_algorithm(adjacency_matrix, source);

            System.out.println("The Shorted Path to all nodes are ");
            for (int i = 1; i <= dijkstrasAlgorithm.distances.length - 1; i++)
            {
                System.out.println(source + " to " + i + " is "+ dijkstrasAlgorithm.distances[i]);
            }
            System.out.println(dijkstrasAlgorithm.settled);
        } catch (InputMismatchException inputMismatch)
        {
            System.out.println("Wrong Input Format");
        }
        scan.close();
    }

}

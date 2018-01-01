package algo.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Arpit on 13-Dec-15.
 */
public class DijkstrasUsingLists {

    int distance[];
    HashSet<Integer>permanentList;
    HashSet<Integer>temporaryList;
    int[][]adjacencyMatrix;
    int v;

    public DijkstrasUsingLists(int[][] adjacencyMatrix, int v) {
        adjacencyMatrix=new int[v][v];
        this.adjacencyMatrix = adjacencyMatrix;
        this.v = v;
        permanentList= new HashSet<>();
        temporaryList=new HashSet<>();
        distance=new int[v];
        for (int i = 0; i < v; i++) {
            distance[i]=Integer.MAX_VALUE;
        }
        System.out.println(Arrays.toString(this.adjacencyMatrix));
    }

    HashSet<Integer>shortestPath(int s){

        int evaluationNode;

        temporaryList.add(s);
        distance[s]=0;

        while (!temporaryList.isEmpty()){
            evaluationNode=getMinimumDistantNode();
            temporaryList.remove(evaluationNode);
            permanentList.add(evaluationNode);
            evaluateNeighbours(evaluationNode);
            //System.out.println("tl"+temporaryList);
           // System.out.println(permanentList);

        }

        return permanentList;
    }

    void evaluateNeighbours(int evaluationNode){
        int edgeDistance,newDistance;
        System.out.println(evaluationNode);
        System.out.println(permanentList);
        for (int i = 0; i < v; i++) {
            if (!permanentList.contains(i)) {
                if (adjacencyMatrix[evaluationNode][i] != Integer.MAX_VALUE)
                {

                    edgeDistance = adjacencyMatrix[evaluationNode][i];
                    newDistance = edgeDistance + distance[evaluationNode];

                    if (newDistance < distance[i]) {
                        distance[i] = newDistance;
                    }
                    temporaryList.add(i);
                    System.out.println(temporaryList);
                    //break;
                }
            }

        }
    }

    int getMinimumDistantNode(){
        int min,node=0;
        Iterator<Integer> itr=temporaryList.iterator();
        node=itr.next();
        min=distance[node];
        for (int i = 0; i < v; i++) {
            if (temporaryList.contains(i)){
                if (distance[i]<min){
                    min=distance[i];
                    node=i;
                }
            }
        }
        return node;
    }


    public static void main(String[] args) {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Scanner sc=new Scanner(System.in);
        DijkstrasUsingLists dijkstrasUsingLists;
        int n,v[][],source,temp;

        System.out.println("Enter no. of vertices : ");
        try {
            n=Integer.parseInt(br.readLine());
            v=new int[n][n];
            System.out.println("Enter adjacency matrix : ");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    v[i][j]=sc.nextInt();
                    if(i==j){
                        v[i][j]=0;
                        continue;
                    }
                    if (v[i][j]==0)v[i][j]=Integer.MAX_VALUE;
                }
            }
            for (int i = 0; i < n; i++) {
                System.out.println(Arrays.toString(v[i]));
            }
            dijkstrasUsingLists=new DijkstrasUsingLists(v,n);
            System.out.println("Enter source : ");
            source=sc.nextInt();

            System.out.println(dijkstrasUsingLists.shortestPath(source));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

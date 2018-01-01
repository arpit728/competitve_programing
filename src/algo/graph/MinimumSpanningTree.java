package algo.graph;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by Arpit on 11-Dec-15.
 */

//This is implementation for finding for minimum spanning tree using kruskal's algorithm.
public class MinimumSpanningTree {

    public static void main(String[] args) {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Vertex v[]=null;
        int n=0,e=0,mst[]=null,weight=0;
        Edge edgeList[]=null;
        try {

            System.out.print("Enter no of vertices : ");
            n=Integer.parseInt(br.readLine());
            v=new Vertex[n];
            System.out.println();

            for (int i = 0; i < n; i++) {

                Vertex vTemp=new Vertex(0,i);
                vTemp.parent=vTemp;

                v[i]=vTemp;
                System.out.println(v[i].parent);
            }

            System.out.print("Enter no. of edges : ");

            e=Integer.parseInt(br.readLine());
            edgeList=new Edge[e];

            for (int i = 0; i < e; i++) {
                String s[]=new String[3];
                s=br.readLine().split("\\s");
                Edge eTemp=new Edge(Integer.parseInt(s[0]),Integer.parseInt(s[1]),Integer.parseInt(s[2]));
                edgeList[i]=eTemp;
            }
            Arrays.sort(edgeList);
            System.out.println(Arrays.toString(edgeList));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        mst=new int[n];

        for (int i = 0,j=0; i < e; i++) {

            Vertex v1 = v[edgeList[i].a];
            Vertex v2 = v[edgeList[i].b];
            Vertex parentV1 = findParent(v1);
            Vertex parentV2 = findParent(v2);

            if (!(parentV1.equals(parentV2))) {
                mst[j] = i;
                j++;
                calculateUnion(parentV1, parentV2);
                weight=weight+edgeList[i].w;
            }
        }

        for (int i=0;i<n-1;i++) System.out.println(edgeList[mst[i]]);
        System.out.println("minimum weight = "+weight);
    }

    static Vertex findParent(Vertex v){
        Vertex temp=v;
        while (temp.parent!=temp){
            temp=temp.parent;
        }
        return temp;
    }

    static  Vertex calculateUnion(Vertex v1,Vertex v2){
        Vertex v;
        if (v1.rank<v2.rank){
            v1.parent=v2.parent;
            v=v1;
            v.rank=v1.rank+v2.rank;
        }
        else{
            v2.parent=v1.parent;
            v=v2;
            v.rank=v1.rank+v2.rank;
        }
        return v;
    }
}
class Vertex{
    int rank,val;
    Vertex parent;

    public Vertex(int rank, int val) {
        this.rank = rank;
        this.val = val;
    }
}

class Edge implements Comparable{
    int a,b,w;

    public Edge(int a, int b, int w) {
        this.a = a;
        this.b = b;
        this.w = w;
    }

    @Override
    public int compareTo(Object o) {
        int a=this.w;
        Edge e= (Edge) o;

        if (a<e.w)return -1;

        else return 0;
    }

    @Override
    public String toString() {
        return "[a="+a+", b="+b+", w="+w+"]";
    }
}

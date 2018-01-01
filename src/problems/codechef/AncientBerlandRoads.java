package problems.codechef;

import sun.reflect.generics.tree.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Arpit on 31-Dec-15.
 */
public class AncientBerlandRoads {

    static int region[];
    static TreeSet<Pair<Integer,Integer>>max;

    public static void main(String[] args) throws IOException {

        int n,m,q,query[][];

        String s[];
        City city[];
        Road road[];
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        s=br.readLine().split("\\s");

        n=Integer.parseInt(s[0]);
        m=Integer.parseInt(s[1]);
        q=Integer.parseInt(s[2]);


        query=new int[q+1][];
        city=new City[n+1];
        road=new Road[m+1];
        region=new int[n+1];


      /* max=new TreeSet<>( new Comparator<Pair<Integer, Integer>>() {
           @Override
           public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
               if (o1.getLeft()==o2.getLeft()){
                   o2.setRight(o1.getRight());
                   return 0;
               }
               else {
                   if (o1.getRight() < o2.getRight()) return -1;
                   else if (o1.getRight() > o2.getRight()) return 1;
                   else return 1;
               }
           }
       });*/

        s=br.readLine().split("\\s");

        for (int i = 1; i <=n; i++) {

            city[i]=new City(Integer.parseInt(s[i-1]),i);
            region[i]=city[i].population;

        }

        int from,to;

        for (int i = 1; i <=m; i++) {

            s=br.readLine().split("\\s");
            from=Integer.parseInt(s[0]);
            to=Integer.parseInt(s[1]);
            road[i]=new Road(from,to,false);
        }

        for (int i = 0; i <q; i++) {

            s=br.readLine().split("\\s");
            query[i]=new int[s.length];

            int temp;
            char ch=s[0].charAt(0);

            if (ch=='P'){

                query[i][0]='P';
                query[i][1]=Integer.parseInt(s[1]);
                temp=Integer.parseInt(s[2]);
                query[i][2]=city[query[i][1]].population;
                city[query[i][1]].population=temp;
                region[query[i][1]]=temp;

            }
            else {

                query[i][0]='D';
                query[i][1]=Integer.parseInt(s[1]);
                road[query[i][1]].setStatus(true);

            }

        }

        for (int i = 1; i <=m; i++) {

            if (!road[i].getStatus()) {

                City x,y;
                from=road[i].getFrom();
                to=road[i].getTo();

                x=city[from].getParent();
                y=city[to].getParent();

                calculateUnion(x, y);

            }
        }
        Stack<Integer>ans=new Stack<>();

        for (int i = q-1; i>=0; i--) {

            ans.push(getMax(region));

            if (query[i][0]=='P'){

                int x=city[query[i][1]].getParent().data;
                region[x]-=city[query[i][1]].population-query[i][2];
                city[query[i][1]].population=query[i][2];

            }

            else {

                City x,y;
                int a,b;
                a=road[query[i][1]].getFrom();
                b=road[query[i][1]].getTo();
                x=city[a].getParent();
                y=city[b].getParent();
                calculateUnion(x, y);

            }
        }

        Collections.reverse(ans);

        Iterator<Integer>itr=ans.iterator();

        while (itr.hasNext()) System.out.println(itr.next());

    }

    static int getMax(int a[]){
        int big=a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i]>big)big=a[i];
        }
        return big;
    }


    static void calculateUnion(City c1,City c2){
        if (c1==c2)return ;

        else if (c1.rank<c2.rank){

            c1.parent=c2;
            region[c2.data]+=region[c1.data];

        }

        else if (c1.rank==c2.rank){

            c2.parent=c1;
            c1.rank++;
            region[c1.data]+=region[c2.data];

        }

        else {
            c2.parent=c1;
            region[c1.data]+=region[c2.data];
        }
    }
}
class City{
    int population;
    City parent;
    int rank,data;

    public City(int population,int index) {

        this.population = population;
        this.data=index;
        parent=this;

    }

    public City getParent() {

        City temp=this;

        while (temp.parent!=temp){
            temp=temp.parent;
        }

        return temp;
    }
}

class Road{
    private int from,to;
    private boolean status;

    public Road(int from, int to, boolean status) {
        this.from = from;
        this.to = to;
        this.status = status;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }
}
class CityComparator implements Comparator<City>{

    @Override
    public int compare(City o1, City o2) {
        if (o1.population<o2.population)return 1;
        else if(o1.population>o2.population) return -1;
        else return 0;
    }
}
class Pair<L,R>{
    private L left;
    private R right;

    public Pair(L left, R right) {
        this.left = left;
        this.right = right;
    }

    public L getLeft() { return left; }
    public R getRight() { return right; }

    public void setLeft(L left) {
        this.left = left;
    }

    public void setRight(R right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }
}

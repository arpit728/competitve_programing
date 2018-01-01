package hiringchallenges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Created by arpit on 3/2/17.
 */
public class MaximalConnection {

    static final int MAX=100000;

    static int []parent=new int[MAX];
    static boolean[]special=new boolean[MAX];

    static HashMap<Integer,Integer> connectionPower =new HashMap<>();
    static HashMap<Integer,Integer> regionSize =new HashMap<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n,m,x;

        String []s=br.readLine().split("\\s");

        n=Integer.parseInt(s[0]);
        m=Integer.parseInt(s[1]);
        x=Integer.parseInt(s[2]);


        for (int i = 0; i < n; i++) {
            parent[i]=i;
        }

        s=br.readLine().split("\\s");

        //marks special cities true
        for (int i = 0; i < m; i++) {
            special[Integer.parseInt(s[i])-1]=true;
        }

        //Make disjoint sets

        for (int i = 0; i < x; i++) {
            s=br.readLine().split("\\s");
            int u=Integer.parseInt(s[0]);
            int v=Integer.parseInt(s[1]);
            setUnion(u-1,v-1);
        }

        System.out.println(solve(n,m,x));
    }

    private static long solve(int n, int m, int x) {
        pathCompression(n);
        calculateConnectionPower(n);
        calculateRegionSize(n);

        Integer keySet[]=new Integer[regionSize.size()];
        regionSize.keySet().toArray(keySet);

        return calculateTotalConnectionPower(keySet,n);

      /*for (int i = 0; i < n; i++) {
            System.out.print(parent[i]+" ");
        }
        System.out.println();*/
  /*      for (int i = 0; i < n; i++) {
            int count=1;

            for (int j = i+1  ; j<n ; j++) {

                if (parent[i]==parent[j]){
                    i=j;
                    count++;
                }
                else {
                    i=j-1;
                    break;
                }
            }
            if (connectionPower.containsKey(parent[i]))
                ans+=count*connectionPower.get(findSet(i));
            //System.out.println(ans);
        }*/
    }

    private static long calculateTotalConnectionPower(Integer[] keySet, int n) {
        long ans=0;
        for (int i = 0; i < keySet.length; i++) {
            if (connectionPower.containsKey(keySet[i])){
                ans+=(long) connectionPower.get(keySet[i])* regionSize.get(keySet[i]);
            }
        }

        return ans;
    }

    private static void calculateRegionSize(int n) {
        for (int i = 0; i < n; i++) {

            if (regionSize.containsKey(parent[i])){

                int temp= regionSize.get(parent[i]);
                temp++;
                regionSize.put(parent[i], temp);
            }else {
                regionSize.put(parent[i], 1);
            }
        }

    }

    private static void calculateConnectionPower(int n) {

        for (int i = 0; i < n; i++) {

            if (special[i]){

                if (connectionPower.containsKey(parent[i])){
                    int temp= connectionPower.get(parent[i]);
                    temp++;
                    connectionPower.put(parent[i], temp);
                }
                else connectionPower.put(parent[i],1);
            }

        }
    }

    private static void pathCompression(int n) {

        for (int i = 0; i < n; i++) {
            findSet(i);
        }
    }


    static void setUnion(int a,int b)
    {
        parent[findSet(a)]=findSet(b);
    }

    static int findSet(int a){

        if (parent[a]==a)return a;

        parent[a]=findSet(parent[a]);

        return parent[a];
    }
}

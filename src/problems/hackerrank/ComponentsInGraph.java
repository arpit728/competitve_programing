package hackerrank;

import java.io.*;
import java.util.Arrays;

/**
 * Created by arpit on 8/12/16.
 */
public class ComponentsInGraph {

    static int x[]=new int[30000];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;
        String s[];
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i<2*n; i++) x[i] = i;

        for (int i = 0; i < n; i++) {

            s = br.readLine().split("\\s");
            union(Integer.parseInt(s[0]) - 1, Integer.parseInt(s[1]) - 1);
        }
        System.out.println(getMinAndMaxRegion(n));
    }

    private static void union(int a, int b) {

        x[findSet(a)]=findSet(b);
    }

    private static int findSet(int a) {

        if (x[a]!=a)
            x[a]=findSet(x[a]);

        return x[a];
    }


    public static String getMinAndMaxRegion(int n) {

        int small=Integer.MAX_VALUE,big=Integer.MIN_VALUE,count;


        //This loop performs path compression
        for (int i = 0; i < (2*n); i++) {
            findSet(i);
        }

        Arrays.sort(x,0,2*n);

        int j;
        for (int i = 0; i < (2*n-1); i++)
        {
            count=1;

            for (j =i+1; j <2*n; j++) {
                if (x[i]!=x[j]){
                    break;
                }
                count++;
            }

            if (count>1){
                small=Integer.min(small,count);
                big=Integer.max(big,count);
            }

            i=j-1;//initialize i to next element
        }
        return small+" "+big;
    }
}

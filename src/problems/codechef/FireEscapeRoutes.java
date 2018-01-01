package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by hardCode on 2/20/2016.
 */
public class FireEscapeRoutes {

    static int x[];
    final static long M=1000000007;
    static BufferedReader br;

    public static void main(String[] args) throws IOException {

        br=new BufferedReader(new InputStreamReader(System.in));
        int t;
        int n,m;
        String s[];
        t=Integer.parseInt(br.readLine());

        x=new int[100001];
        while (t-->0){

            s=br.readLine().split("\\s");
            n=Integer.parseInt(s[0]);
            m=Integer.parseInt(s[1]);

            for (int i = 1; i <=n; i++) {
                x[i]=i;
            }

            solve(n, m);
        }


    }



    static void solve(int n,int m) throws IOException {
        //System.out.println(Arrays.toString(x));
        String s[];
        long prod=1,count=0;

        for (int i = 0; i <m ; i++) {
            s=br.readLine().split("\\s");
            setUnion(Integer.parseInt(s[0]),Integer.parseInt(s[1]));
        }

        for (int i = 1; i <= n; i++) {
            findSet(i);
        }

        Arrays.sort(x,1,n+1);
        //System.out.println(Arrays.toString(x));

        for (int i = 1,j; i <= n; i++) {

            for (j = i+1; j <= n; j++) {
                if (x[i]!=x[j])break;
            }
            count++;
            prod=prod*(j-i)%M;
            i=j-1;
        }

        System.out.println(count+" "+prod);

    }

    static void setUnion(int a,int b)
    {
        x[findSet(a)]=findSet(b);
    }

    static int findSet(int a){

       /* int i=0,y[]=new int[100001];

        while (x[xenny]!=xenny){

            y[i]=xenny;
            xenny=x[xenny];
            i++;

        }

        for (int j = 0; j < i; j++) {
            x[y[j]]=x[xenny];
        }
*/
        if (x[a]!=a)x[a]=findSet(x[a]);
        return x[a];
    }
}
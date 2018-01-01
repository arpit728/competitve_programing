package linkedin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by arpit on 4/11/16.
 */
public class MaximumReputation {

    static final int MAX=100001;
    static int a[]=new int[MAX],b[]=new int[MAX];

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t,n;
        long k;
        String s1[],s2[];
        t=Integer.parseInt(br.readLine());

        while(t-->0){
            s1=br.readLine().split("\\s");
            n=Integer.parseInt(s1[0]);
            k=Long.parseLong(s1[1]);
            s1=br.readLine().split("\\s");
            s2=br.readLine().split("\\s");
            for (int i = 0; i < n; i++) {
                a[i]=Integer.parseInt(s1[i]);
                b[i]=Integer.parseInt(s2[i]);
            }

            System.out.println(solve(a,b,n,k));
        }
    }

    private static long solve(int[] a, int[] b, int n, long k) {

        long res=calInteraction(a, b, n);

        //return calMaximumInteraction(a,b,n,k,res);
        return Long.max(calMaximumInteraction(a,b,n,k,res),calMaximumInteraction(b,a,n,k,res));
    }

    private static long calMaximumInteraction(int[] a, int[] b, int n, long k, long res) {


        long actualRes=res;

        for (int i = 0; i < n; i++) {
            res=Long.max(res,actualRes+k*b[i]);
            res=Long.max(res,actualRes-k*b[i]);
        }
        return res;
    }

    private static long calInteraction(int[] a, int[] b, int n) {

        long res=0;
        long temp=0;
        for (int i = 0; i < n; i++){
            temp=(long)a[i] * b[i];
            res +=temp;
        }
        return res;
    }
}

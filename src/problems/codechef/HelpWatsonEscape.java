package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by hardCode on 4/26/2016.
 */
public class HelpWatsonEscape {

    final static int M=1000000007;



    public static void main(String[] args) throws IOException {
        long t,k,n;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        t=Integer.parseInt(br.readLine());
        while (t-->0){
            String s[]=br.readLine().split("\\s");
            n=Long.parseLong(s[0]);
            k=Long.parseLong(s[1]);
            System.out.println(solve(k,n));
        }
    }

    private static long solve(long k, long n) {
        long result=k;
        n--;
        k--;
        while (n>0){
            if ((n&1)!=0)result=(result*k)%M;
            k=(k*k)%M;
            n>>=1;
        }
        return result;
    }
}

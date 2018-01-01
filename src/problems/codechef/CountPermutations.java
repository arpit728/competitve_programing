package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by arpit on 5/12/16.
 */
public class CountPermutations {

    public static final int M=1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine()),n;
        while (t-->0){
            n=Integer.parseInt(br.readLine());

            System.out.println(solve(n));
        }
    }

    private static int solve(int n) {

        if (n==1)return 0;
        return power2(n-1)-2;
    }

    private static int power2(int n) {

        if (n==0)return 1;

        if ((n&1)==1){
            int h=power2((n-1)/2);

            return (int)(((long)(h%M)*(h%M)*2)%M);
        }

        else {
            int h=power2(n/2);
            return (int)((((long)h%M)*(h%M))%M);
        }
    }


}

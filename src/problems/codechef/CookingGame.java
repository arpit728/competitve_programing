package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by hardCode on 2/20/2017.
 */
public class CookingGame {

    final static int MAX=100000,M=1000000007;
    static int[]a=new int[MAX];
    static BufferedReader br;

    public static void main(String[] args) throws IOException {

        br=new BufferedReader(new InputStreamReader(System.in));
        int t,n;
        String[]s;
        t=Integer.parseInt(br.readLine());
        while (t-->0){
            n=Integer.parseInt(br.readLine());
            readArray(a,n);
            System.out.println(solve(a,n));
        }
    }

    private static long solve(int[] a, int n) {

        if(a[0]==-1)a[0]=1;
        if (a[0]!=1)return 0;

        //This functions fills the position which can be determined, if(xenny[i+1]>1) then xenny[i] has to be xenny[i+1]-1
        if (fillDeterminedPositions(a,n)==0)return 0;

        int k=0;
        for (int i = 0; i < n; i++) {
            if (a[i]==-1)k++;
        }
/*

        for (int i = 0; i < n; i++) {
            System.out.print(xenny[i] + " ");
        }
        System.out.println();
*/
        return binaryExponentiation(2,k);
    }

    public static long binaryExponentiation(long base,long exp){
        long ans=1;
        while (exp>0){
            if (exp%2==1)
                ans=(ans*base)%M;
            base=(base*base)%M;
            exp>>=1;
        }
        return ans;
    }

    private static int fillDeterminedPositions(int[] a, int n) {

        for (int i =n-2 ; i>=0 ; i-- ) {

            if (a[i+1]>1){
                if (a[i]!=a[i+1]-1 && a[i]>-1)return 0;
                if (a[i]==-1)a[i]=a[i+1]-1;

            }

        }
        return 1;
    }

    private static void readArray(int[] a, int n) throws IOException {
        String[]s;
        s=br.readLine().split("\\s");
        for (int i = 0; i < n; i++) {
            a[i]=Integer.parseInt(s[i]);
        }
    }
}

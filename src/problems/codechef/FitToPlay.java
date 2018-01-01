package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by arpit on 17/1/17.
 */
public class FitToPlay {
    static final int MAX=100000;
    static int a[]=new int[MAX];

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t,n;
        String[]s;
        t=Integer.parseInt(br.readLine());
        while (t-->0){
            n=Integer.parseInt(br.readLine());
            s=br.readLine().split("\\s");
            for (int i = 0; i < n; i++) {
                a[i]=Integer.parseInt(s[i]);
            }
            System.out.println(solve(a,n));
        }

    }

    private static String solve(int[] a, int n) {
        int ans=-1,minSoFar=Integer.MAX_VALUE;
        for (int i = 0; i < n-1; i++) {
            minSoFar=Integer.min(minSoFar,a[i]);
            ans=Integer.max(ans,a[i+1]-minSoFar);
        }

        if (ans<=0)
            return "UNFIT";

        return ans+"";
    }

}

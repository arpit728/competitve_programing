package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by arpit on 30/12/16.
 */
public class Walk {

    static int w[]=new int[100000];

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t,n;
        String[]s;
        t=Integer.parseInt(br.readLine());
        while (t-->0){
            n=Integer.parseInt(br.readLine());
            s=br.readLine().split("\\s");
            for (int i = 0; i < n; i++) {
                w[i]=Integer.parseInt(s[i]);
            }
            System.out.println(solve(w,n));
        }
    }

    private static int solve(int[] w, int n) {

        int ans=0;
        for (int i = n-1; i>=0; i--) {
            ans++;
            if (ans<w[i])
                ans=w[i];
        }
        return ans;
    }
}

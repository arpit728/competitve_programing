package hiringchallenges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by arpit on 14/5/17.
 */
public class SimpleGraph {

    static int MAX=100;
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

        int sum=0;
        for (int i = 0; i < n; i++) {
            if (a[i]>n-1)
                return "NO";

            sum+=a[i];
        }
        if (sum%2==0) return "YES";


        return "NO";
    }
}

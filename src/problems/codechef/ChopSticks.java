package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by arpit on 10/1/17.
 */
public class ChopSticks {
    static final int MAX=100000;
    static int a[]=new int[MAX];

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n,d;
        String[]s;
        s=br.readLine().split("\\s");
        n=Integer.parseInt(s[0]);
        d=Integer.parseInt(s[1]);
        for (int i = 0; i < n; i++) {
            a[i]=Integer.parseInt(br.readLine());
        }
        System.out.println(solve(a,n,d));
    }

    private static int solve(int[] a, int n, int d) {

        Arrays.sort(a,0,n);
        int ans=0;
        for (int i = 1; i <n ; i++) {
            if (a[i]-a[i-1]<=d){
                ans++;
                i++;
            }
        }
        return ans;
    }
}

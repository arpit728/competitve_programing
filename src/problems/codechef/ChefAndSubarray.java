package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by arpit on 18/1/17.
 *
 * problem link:-https://www.codechef.com/problems/CHEFZOT
 */
public class ChefAndSubarray {

    static final int MAX=100000;
    static int a[]=new int[MAX];

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n;
        String[]s;

        n=Integer.parseInt(br.readLine());
        s=br.readLine().split("\\s");
        for (int i = 0; i < n; i++) {
            a[i]=Integer.parseInt(s[i]);
        }
        System.out.println(solve(a,n));

    }

    private static int solve(int[] a, int n) {
        int ans=0,cnt=0;
        for (int i = 0; i < n; i++) {
            if (a[i]!=0)cnt++;
            else {
                ans=Integer.max(ans,cnt);
                cnt=0;
            }
        }
        //this line has been included to handle the cases like 2 3 0 4 1 2 3 4,
        //Since there is no zero at the end else part will not be executed at last
        ans=Integer.max(ans,cnt);
        return ans;
    }

}

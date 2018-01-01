package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by arpit on 6/2/17.
 */
public class ChefAndHisApartmentDues {


    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n,t;
        String[]s;
        t=Integer.parseInt(br.readLine());
        while (t-->0){
            n=Integer.parseInt(br.readLine());
            s=br.readLine().split("\\s");
            System.out.println(solve(s,n));
        }
    }

    private static int solve(String[] s, int n) {
        int ans=0,i,k=0,one=0;

        for (i = 0; i < n; i++) {

            if ("0".equals(s[i])){
                break;
            }
        }
        k=i;
        for (; i<n ; i++) {
            if ("1".equals(s[i]))one++;
        }
        ans+=1100*(n-k)-one*1000;

        return ans;
    }
}

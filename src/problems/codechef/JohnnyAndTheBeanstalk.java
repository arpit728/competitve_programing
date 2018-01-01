package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by arpit on 13/1/17.
 */
public class JohnnyAndTheBeanstalk {

    static int a[]=new int[1000000];
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t,k;
        String[]s;
        t=Integer.parseInt(br.readLine());
        while (t-->0){
            k=Integer.parseInt(br.readLine());
            s=br.readLine().split("\\s");
            for (int i = 0; i < k; i++) {
                a[i]=Integer.parseInt(s[i]);
            }

            System.out.println(solve(a,k));
        }
    }

    private static String solve(int[] a, int k) {
        if (a[0]>1)return "No";
        if (a[0]==1){
            if (k==1)return "Yes";
            else return "No";
        }
        int stem=1;
        for (int i = 1; i <k-1 ; i++) {
            int branch=stem*2;
            if (0 <= a[i] && a[i]<= branch)
                stem=branch-a[i];
            else return "No";
        }
        if (a[k-1]==stem*2)return "Yes";
        return "No";
    }
}

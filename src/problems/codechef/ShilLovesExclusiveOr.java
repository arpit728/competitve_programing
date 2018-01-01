package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by arpit on 31/1/16.
 */
public class ShilLovesExclusiveOr {
    public static void main(String[] args) throws IOException {
        int t;
        long x;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        t= Integer.parseInt(br.readLine());
        while (t-->0){
            x= Long.parseLong(br.readLine());
            long ans=0,flag=0;
            for (long i = 1; i <=x; i++) {
                ans^=i;
                if (ans==x){
                    flag=1;
                    break;
                }
            }
            if (flag==1) System.out.println(ans);
            else System.out.println(-1);
        }
    }
}

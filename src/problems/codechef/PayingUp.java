package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Arpit on 29-Dec-15.
 */
public class PayingUp {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t,m,n,notes[],dp[][];
        String s[];

        t=Integer.parseInt(br.readLine());

        while (t-->0){

            s=br.readLine().split("\\s");
            n=Integer.parseInt(s[0]);
            m=Integer.parseInt(s[1]);

            dp=new int[n+1][m+1];
            notes=new int[n+1];

            for (int i = 1; i <=n; i++) {
                notes[i]=Integer.parseInt(br.readLine());
            }
            notes[0]=0;
            int temp,flag=0;

            for (int i = 1; i <=n; i++) {

                for (int j = 1; j <=m; j++) {

                    temp=j-notes[i];

                    if (temp==0)dp[i][j]=j;

                    else if (temp<0)dp[i][j]=dp[i-1 ][j];

                    else dp[i][j]=(dp[i-1][temp]+notes[i]==j?j:dp[i-1][j]);

                    /*if (dp[i-1][j]!=0) dp[i][j]=dp[i-1][j];

                    if (temp>=0){
                        dp[i][j]=(dp[i-1][temp]+notes[i]==j?j:dp[i-1][j]);
                    }*/
                }
            }

            for (int i = 1; i <=n; i++) {
                if (dp[i][m]==m){
                    flag=1;
                    break;
                }
            }

            if (flag==1){
                System.out.println("Yes");
            }
            else System.out.println("No");


        }

    }
}

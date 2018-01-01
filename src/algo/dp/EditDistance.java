package algo.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by arpit on 15/8/16.
 */
public class EditDistance {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t,dp[][];
        char x[],y[];
        String s[];
        t=Integer.parseInt(br.readLine());
        dp=new int[100][100];

        while (t-->0){

            s=br.readLine().split("\\s");
            x=s[0].toCharArray();
            y=s[1].toCharArray();

            for (int i = 0; i <=y.length; i++) {
                for (int j = 0; j <=x.length; j++) {
                    dp[i][j]=-1;
                    if (i==0)dp[i][j]=j;
                    if (j==0)dp[i][j]=i;
                }

                //System.out.println(Arrays.toString(dp[i]));
            }
            //System.out.println(editDistance(x, y, x.length, y.length));
            System.out.println(editDistanceMemoized(x, y, x.length, y.length, dp));

            /*for (int i = 0; i < y.length; i++) {
                System.out.println(Arrays.toString(dp[i]));
            }
*/
        }

    }

    private static int editDistanceMemoized(char[] x, char[] y, int m, int n, int[][] dp) {

        if (m==0)return n;
        if (n==0)return m;

        if (dp[n][m]!=-1)return dp[n][m];

        if (x[m-1]==y[n-1])dp[n][m]=editDistanceMemoized(x,y,m-1,n-1,dp);

        else dp[n][m]=1+Integer.min(Integer.min(editDistanceMemoized(x,y,m,n-1,dp),//Insert
                                                        editDistanceMemoized(x,y,m-1,n,dp)),//Delete
                                                        editDistanceMemoized(x,y,m-1,n-1,dp));//Replace
        return dp[n][m];
    }


    //This solution is the exhaustive solution to the edit distance problem which takes exponential time.
    private static int editDistance(char[] x, char[] y, int m, int n) {

        if (m==0 )return n;

        if (n==0)return m;

        if (x[m-1]==y[n-1])return editDistance(x,y,m-1,n-1);

        else return 1+Integer.min(Integer.min(editDistance(x,y,m,n-1),editDistance(x,y,m-1,n)),editDistance(x,y,m-1,n-1));
    }


}

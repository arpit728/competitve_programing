package algo.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by arpit on 14/8/16.
 */
public class LongestCommonSubsequence {

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

            System.out.println(solve(x,y,x.length,y.length,dp));

            System.out.println(getSequence(x,y,x.length,y.length,dp));
        }
    }

    private static ArrayList<Character> getSequence(char[] x, char[] y, int m, int n,int dp[][]) {

        int i=m-1,j=n-1;

        ArrayList<Character> seq=new ArrayList<>();
        while (i>=0 && j>=0){

            if (x[i]==y[j]){
                seq.add(x[i]);
                i--;
                j--;
            }
            if (i==0){
                if (x[i]==y[j]){
                    seq.add(x[i]);
                    break;
                }
                j--;

            }
            if (j==0){
                if (x[i]==y[j]){
                    seq.add(x[i]);
                    break;
                }
                i--;
            }
            else if (dp[i][j]==dp[i-1][j])i--;
            else if (dp[i][j]==dp[i][j-1])j--;


        }
        Collections.reverse(seq);
        return seq;
    }


    private static int solve(char[] x, char[] y, int m, int n, int dp[][]) {

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j]=-1;
            }
        }
        
        return lcsMemoized(x,y,m,n,dp);
        
    }

    //This function is the top down solution for LCS and uses dp
    private static int lcsMemoized(char[] x, char[] y, int m, int n,int dp[][]) {

        if (m==0 || n==0){
            return 0;
        }

        if (dp[m-1][n-1]!=-1)return dp[m-1][n-1];

        if (x[m-1]==y[n-1]){

            dp[m-1][n-1]=1+lcsMemoized(x,y,m-1,n-1,dp);

        }
        
        else{
            dp[m-1][n-1]=Integer.max(lcsMemoized(x, y, m - 1, n, dp),lcsMemoized(x,y,m,n-1,dp));
        }

        return dp[m-1][n-1];
    }


    //This function is the recursive solution to the lcs problem which takes exponential time so above is the dp problem.
    private static int lcs(char[] x, char[] y, int m, int n, ArrayList<Character> seq, boolean[] hash) {

        if (m==0 || n==0)return 0;

        if (x[m-1]==y[n-1]){
            if (!hash[x[m-1]]){
                seq.add(x[m-1]);
                hash[x[m-1]]=true;
            }
            return 1+lcs(x, y, m - 1, n - 1, seq,hash);
        }

        else return Integer.max(lcs(x,y,m,n-1, seq, hash),lcs(x,y,m-1,n, seq, hash));

    }


}

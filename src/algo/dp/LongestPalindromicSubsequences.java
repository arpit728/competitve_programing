package algo.dp;

import java.util.Arrays;

/**
 * Created by arpit on 10/12/16.
 *
 * problem link:-http://www.geeksforgeeks.org/dynamic-programming-set-12-longest-palindromic-subsequence/
 */
public class LongestPalindromicSubsequences {

    static int dp[][]=new int[15][15];

    public static void main(String[] args) {
        char[] s="GEEKSFORGEEKS".toCharArray();

        System.out.println(lpsDP(s, 0, s.length - 1));

    }

    //top down dp
    private static int lpsDP(char[] s, int i, int j){

        if (i==j)return 1;
        if (s[i]==s[j] && j==i+1)return 2;

        if (dp[i][j]>0)return dp[i][j];

        if (s[i]==s[j])
            dp[i][j]=2+lpsDP(s, i + 1, j - 1);
        else dp[i][j]=Integer.max(lpsDP(s,i+1,j),lpsDP(s,i,j-1));

        return dp[i][j];
    }
    private static int lps(char[] s, int i, int j) {

        if (i==j)return 1;

        /*
        * This base case is considered because if j=i+1 and a[i]==a[j] it will cause bound overflows
        * say i=2 and j=3 and a[2]==a[3] then it will call lps(s,i+1,j-1) i.e,lps(3,2)
        * */
        if (s[i]==s[j] && j==i+1)return 2;
        //System.out.println("i = "+i+" "+j);
        if (s[i]==s[j])return 2+lps(s,i+1,j-1);

        return Integer.max(lps(s,i,j-1),lps(s,i+1,j));
    }
}

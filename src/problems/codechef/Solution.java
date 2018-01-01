package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by hardCode on 4/12/2016.
 */
public class Solution {
    public	static	final	String	SOLUTION_OWNER_NAME	="Arpit Agrawal";
    public	static	final	String	SOLUTION_OWNER_EMAIL="agrawal.arpit35@gmail.com";

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s=br.readLine();
        System.out.println(makeChange(s));

    }

    public	static	String	makeChange(String	input)	{

        String s[]=input.split(",");
        int n=s.length;
        int a[]=new int[s.length-1],amount=0;

        try {

            amount=Integer.parseInt(s[0]);
            for (int i = 1,j=0; i<n; i++,j++) a[j] = Integer.parseInt(s[i]);
            n--;
        }
        catch (NumberFormatException e)
        {
            return "Please enter the input in proper format.";
        }

        int dp[][]=new int[(int) n][(int) (amount+1)];
        createDP(dp,a,n,amount);
       /* for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }*/
        return	printConfiguration(dp, a, n, amount);
    }

    static void createDP(int dp[][],int a[],int n,int amount){
        for (int i = 1; i <=amount ; i++) {
            if (i%a[0]==0)dp[0][i]= (int) (i/a[0]);
        }

        int same,prev;
        for (int i = 1; i < n; i++) {

            for (int j = 1; j <=amount; j++) {

                if (j >= a[i]){
                    same=dp[i][j-a[i]];
                    prev=dp[i-1][j];

                    if (same==0 && prev==0)dp[i][j]=0;

                    else if (j%a[i]==0)dp[i][j]=j/a[i];

                    else if (same==0||prev==0)dp[i][j]=(same!=0?same+1:prev);

                    else dp[i][j] = min(dp[i - 1][j], dp[i][j - a[i]] + 1);
                }

                else dp[i][j] = dp[i - 1][j];
            }

        }

    }

    static String printConfiguration(int[][] dp, int a[], int n, int p){

        StringBuilder soln=new StringBuilder();

        if (dp[n-1][p]==0)return "Nil";

        else {

            for (int i = n - 1, j = p; i >= 0 && j > 0; ) {

                if (i == 0) {
                    j -= a[0];
                    soln.append(a[0] + ",");

                } else if (j == a[i]) {
                    soln.append(a[i] + ",");
                    j -= a[i];
                } else if (dp[i][j] == dp[i - 1][j]) i--;

                else {

                    j = j - a[i];
                    soln.append(a[i] + ",");

                }
            }
        }
        return soln.substring(0,soln.lastIndexOf(","));
    }

    static int min(int a,int b){
        return a<b?a:b;
    }

}

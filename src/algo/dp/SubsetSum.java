package algo.dp;

import java.io.*;
/**
 * Created by hardCode on 4/26/2016.
 */
public class SubsetSum {

	public static void main(String[] args)throws IOException{
		
		int n,k,a[];
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String s[]=br.readLine().split("\\s");
		n=Integer.parseInt(s[0]);
		k=Integer.parseInt(s[1]);
		s=br.readLine().split("\\s");

		
		a=new int[n];

		for (int i=0;i<n;i++ ) {
			a[i]=Integer.parseInt(s[i]);
		}

		System.out.println(solve(a,n,k));

	}

	public static boolean solve(int a[],int n,int k){

		boolean dp[][]=new boolean[n][k+1];

		for (int i=0;i<n;i++ ) {
			dp[i][0]=true;
		}

		if (a[0]<=k)dp[0][a[0]]=true;

		for (int i=1; i<n; i++) {
			for (int j=1;j<=k ;j++ ) {
				if (j<a[i])dp[i][j]=dp[i-1][j];
				else dp[i][j]=dp[i-1][j]|dp[i-1][j-a[i]];
			}
		}

		return dp[n-1][k];
	}
}

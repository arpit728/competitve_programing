package algo.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) throws IOException {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t,n,arr[]=null;
		String s[];
		t=Integer.parseInt(br.readLine());
		while(t-->0){
			n= Integer.parseInt(br.readLine());
			s=br.readLine().split("\\s");
			arr=new int[n];
			for (int i = 0; i <n; i++) {
				arr[i]=Integer.parseInt(s[i]);
			}
			s=null;
		}

		System.out.println(Lis(arr));
	}


	public static int Lis(int arr[]){

		int dp[]=new int[arr.length],length,max,sol[]=new int[arr.length],k=0,n=arr.length;
		dp[0]=1;
		max=0;

		Arrays.fill(dp,1);

		for (int i = 1; i<n ; i++) {

			for (int j=0;j<i;j++){
				if (arr[j]<arr[i])
					dp[i]=max(dp[j] + 1, dp[i]);
			}

		}
		length=dp[0];
		for (int i = 1; i < dp.length; i++) {
			if (dp[i]>length) {
				length=dp[i];
			}
		}
		System.out.println(Arrays.toString(dp));
		return dp[n-1];
	}

	static int max(int a,int b){
		return a>b?a:b;
	}


}

package misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestPalindromicSubstring {

	static boolean dp[][]=new boolean[100][100];
	static char[]s;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		while(t-->0) {
			s=br.readLine().toCharArray();
			System.out.println(solve(s,s.length));
		}
	}
	private static String solve(char[] s, int n) {
		
		
		return longestPalindromicSubstring(s,n);
	}
	private static String longestPalindromicSubstring(char[] s, int n) {
		
		int maxLength=1,start=0,end=0;
		StringBuilder sbr=new StringBuilder();
		for (int i = 0; i < n; i++) {
			dp[i][i]=true;
			
		}
		for (int i = 0; i < n-1; i++) {
			if (s[i]==s[i+1]) {
				dp[i][i+1]=true;				
			}
		}
		for (int j = 3; j <=n;j++) {
			for (int i = 0; i <=n-j; i++) {
				int k=i+j-1;
				dp[i][k]=(dp[i+1][k-1])&&(s[i]==s[k]);
				if (dp[i][k]) {
					if(j>maxLength) {
						maxLength=j;
						start=i;
						end=k;
					}
				}
			}
		}
		for(int i=start;i<=end;i++) {
			sbr.append(s[i]);
		}
		return sbr.toString();
	}
}

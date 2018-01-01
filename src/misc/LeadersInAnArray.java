package misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LeadersInAnArray {

	static int []a=new int[1001];
	static int[]maxFromRight=new int[10];

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t,n;
		String[]s;
		t=Integer.parseInt(	br.readLine());
		while (t-->0) {
			n=Integer.parseInt(br.readLine());
			s=br.readLine().split("\\s");
			int i=0;
			a[n]=-1;
			maxFromRight[n]=-1;
			for (String string : s) {
				a[i++]=Integer.parseInt(string);
			}
			System.out.println(solve(a,n));
		}
	}

	private static String solve(int[] a, int n) {
		
		StringBuilder sbr=new StringBuilder();
		for (int i = n-1; i>=0; i--) {
			maxFromRight[i]=Integer.max(a[i], maxFromRight[i+1]);
		}
		//System.out.println(Arrays.toString(maxFromRight));
		for (int i = 0; i < n; i++) {
			if (a[i]>maxFromRight[i+1]) {
				sbr.append(a[i]+" ");
			}
		}
		sbr.deleteCharAt(sbr.length()-1);
		// TODO Auto-generated method stub
		return sbr.toString();
	}


}

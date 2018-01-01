package misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MissingNumber {

	static int []a=new int[1001];

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
			for (String string : s) {
				a[i++]=Integer.parseInt(string);
			}
			System.out.println(solve(a,n));
		}
	}

	private static int solve(int[] a, int n) {
		int expectedNumber=1;
		for (int i = 0; i < n; i++) {
			if (a[i]!=expectedNumber) {
				return expectedNumber;
			}
			expectedNumber++;
		}
		return -1;
	}

}

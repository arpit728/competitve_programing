package misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EqilibriumPoint {

	static int []a=new int[100];
	static int []suffix=new int[101];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t,n;
		String[]s;
		t=Integer.parseInt(br.readLine());
		while(t-->0) {
			n=Integer.parseInt(br.readLine());
			s=br.readLine().split("\\s");
			suffix[n]=0;
			for (int i = 0; i < n; i++) {
				a[i]=Integer.parseInt(s[i]);
			}
			System.out.println(solveWithoutSpace(a,n));
			
		}
	}

	private static int solveWithoutSpace(int[] a, int n) {
		
		//This functino find the equilibrium point without using the extra space, other approach which uses 
		//auxiliary array suffix is used in the solve function below and uses the fillSuffix as the helping function
		int prefixSum=0,suffixSum=0;
		
		for (int i = 0; i < n; i++) {
			suffixSum+=a[i];			
		}
		for (int i = 0; i < n; i++) {
			suffixSum-=a[i];
			if (prefixSum==suffixSum) {
				return i+1;
			}
			prefixSum+=a[i];
		}
		return -1;
	}
	
/*	private static int solve(int[] a2, int n) {
	// TODO Auto-generated method stub
		fillFuffix(a,n);
		int prefixSum=0;
		for (int i = 0; i < n; i++) {
			if (prefixSum==suffix[i+1]) {
				return i+1;
			}
			prefixSum+=a[i];
		}
		return -1;
	}
	
	private static void fillFuffix(int[] a, int n) {
		
		for(int i=n-1;i>=0;i--) {
			suffix[i]=suffix[i+1]+a[i];
		}
		// TODO Auto-generated method stub
		
	}*/
}

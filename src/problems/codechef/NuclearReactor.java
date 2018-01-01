package problems.codechef;

import java.io.*;


//problem link:- https://www.codechef.com/problems/NUKES
class NuclearReactor{
	static int c[];
	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int a,n,k;
		String s[];
		c=new int[101];
		s=br.readLine().split("\\s");
		
		a=Integer.parseInt(s[0]);
		n=Integer.parseInt(s[1]);
		k=Integer.parseInt(s[2]);

		solve(a,n,k);

		for (int i=0; i<k-1; i++) {
			System.out.print(c[i]+" ");
		}
		System.out.println(c[k-1]);
	}

	static void solve(int a,int n,int k){
		for (int i=0; i<a; i++) {
			bombard(0,n,k);
		}
	}

	static void bombard(int i, int n,int k){

		if (i<k) {
			if (c[i]<n) {
				c[i]++;
			}
			else {
				c[i]=0;
				bombard(i+1,n,k);
			}
		}
	}
}
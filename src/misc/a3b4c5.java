import java.io.*;
import java.util.*;
class a3b4c5{

	public static void main(String[] args)throws Exception {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		char[]a;
		int hash[]=new int[126];
		while(t-->0){
			a=br.readLine().toCharArray();
			Arrays.fill(hash,0);
			System.out.println(solve(a,hash));
		}
	}

	static String solve(char[]a,int[]hash){
		StringBuilder sbr=new StringBuilder();
		for (int i=0;i<a.length ;i++ ) {
			hash[a[i]]++;
		}
		for (int i=65;i<126 ;i++ ) {
			if(hash[i]>0){
				sbr.append((char)i);
				sbr.append(hash[i]);
			}
		}
		return sbr.toString();
	}
	static String solve1(String s){
		int hash[]=new int[126];
		int n=s.length();
		StringBuilder sbr=new StringBuilder();

		for (int i=0;i<n ;i++ ) {
			hash[s.charAt(i)]++;
		}

		for (int i=0;i<126 ;i++ ) {
			if(hash[i]>0){
				sbr.append(hash[i]);
				sbr.append((char)i);
			}
		}
		return sbr.toString();
	}
}
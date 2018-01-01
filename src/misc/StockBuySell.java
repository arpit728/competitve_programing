import java.io.*;
import java.util.*;

class StockBuySell{

	static int a[]=new int[10000];

	public static void main(String[] args)throws IOException {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[]s;
		int n,t;
		
		t=Integer.parseInt(br.readLine());

		while(t-->0){
			n=Integer.parseInt(br.readLine());
			s=br.readLine().split("\\s");

			for (int i=0; i<n; i++) {
				a[i]=Integer.parseInt(s[i]);
			}
			System.out.println(solve(n));
		}

	}

	public static int solve(int n){

		int i,profit,buy,sell;
		if(n==1)return 0;

		profit=i=buy=sell=0;

		while(i<n)
		{
			while(((i+1)<n) && (a[i]>=a[i+1])){
				i++;
				buy=i;
			}

			if (i==(n-1))break;

			while(((i+1)<n) && (a[i]<=a[i+1]) ){
				i++;
				sell=i;
			}

			profit+=a[sell]-a[buy];
		}

		return profit;
	}
}
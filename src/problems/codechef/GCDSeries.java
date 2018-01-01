package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GCDSeries {
	
	static double gcd(int dp[][],int n1,int n2){
	    
		if(n1==n2)return n1;
	    
	    
	    else if(dp[n1][n2]!=0)return dp[n1][n2];
	    
	    else if(dp[n2][n1]!=0)return dp[n2][n1];
	    
	    else if(n1==1||n2==1)return 1;
	    
	   /* else if(n1%n2==0)return n2;
	    
	    else if(n2%n1==0)return n1;
	    */
	    else dp[n1][n2]=(int) (n1>n2?gcd(dp,n1-n2,n2):gcd(dp,n1,n2-n1));
	    
	    return dp[n1][n2];
	}
	
	static double gcd(long n1,long n2){
		while(n1!=n2){
			if(n1>n2)n1=n1-n2;
			else n2=n2-n1;
		}
		return n1;
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int t,n;
		BufferedReader b=new BufferedReader(new InputStreamReader(System.in));
		t=Integer.parseInt(b.readLine());
		while(t-->0){
			long temp1=System.nanoTime();
			double ans=1,temp=0;
			n=Integer.parseInt(b.readLine());
			//int dp[][]=new int[n+1][n+1];
			
			for(int i=2;i<=n;i++){
				/*if(n%i==0)temp=i;
				else*/ temp=gcd(i,n);
	            ans=ans+1/temp;
	            //System.out.println((long)gcd(dp,i,n));
	        }
	        ans=ans*n;
	        long temp2=System.nanoTime();
	        System.out.println("Hey, I am the time using dp : "+(temp2-temp1));
	        
	        /*ans=0;
	        temp1=System.nanoTime();
	        for(int i=1;i<=n;i++){
	            ans=ans+1/gcd(i,n);
	            //System.out.println((long)gcd(dp,i,n));
	        }
	        ans=ans*n;
	        temp2=System.nanoTime();
	        System.out.println("Hey, I am the time without using dp : "+(temp2-temp1));
	        //System.out.println((long)ans);
*/	        
		}
	}
}

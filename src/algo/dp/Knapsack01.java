package algo.dp;

import java.util.Arrays;

public class Knapsack01 {

	public static void main(String[] args) {
		int wt[]={1,3,4,5},p[]={1,4,5,7},size=4,w=7;
		int temp[][]=new int[size+1][w+1],sol[]=new int[size];
		
		for (int i = 1; i <= size; i++) {
			
			for(int j=1;j<=w;j++){
				if(j>=wt[i-1])
				{
					int a = p[i-1]+temp[i-1][j-wt[i-1]];
					int b=temp[i-1][j];
					temp[i][j]=Math.max(a,b);
					
				}
				else{
					temp[i][j]=temp[i-1][j];
				}System.out.print(temp[i][j]+" ");
			}
			System.out.println();
		}
		
		for(int i=size,j=w,k=0;i>0;k++){
			if(temp[i][j]!=temp[i-1][j]){
				sol[i-1]=1;
				System.out.println(j+" ");
				j=j-wt[i-1];
				System.out.println(j+" ");
				i--;
			}
			else{
				i--;
			}
		}
		
		System.out.println(temp[size][w]);
		System.out.println(Arrays.toString(sol));
	}

}

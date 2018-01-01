package examples.colletionframework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

public class Experiment {

	public static void main(String[] args) {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		try {
			int t= Integer.parseInt(br.readLine()),m,n;
			while (t-->0){
				String[]s=br.readLine().split("\\s");
				m=Integer.parseInt(s[0]);
				n=Integer.parseInt(s[1]);
				int high=0,temp=m*n,tempM=m;
				while (tempM<temp){
					tempM=tempM*2;
					high++;
					if (tempM>=temp){
						high--;
						break;
					}
				}
				//System.out.println(high);
				while (high>=0){
					System.out.print("("+m+"<<"+high+")");
					if (high!=0) System.out.print("+");
					high--;
				}
				System.out.println();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

package problems.codechef;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class IOExperiment {

	static long readInput(){
		long ret = 0;
		try{
			
			BufferedInputStream b=new BufferedInputStream(System.in);
			char c = (char) b.read();
			while(c<'0' || c>'9') c = (char) b.read();
			
			while(c>='0' && c<='9') {
				ret = 10 * ret + c - 48;
				c = (char) b.read();
			}
			b.close();
		}catch (IOException e) {
						
			e.printStackTrace();
		}
		return ret;
	}
	public static String readInputDemo(){
		BufferedInputStream b=new BufferedInputStream(System.in);
		StringBuilder s=new StringBuilder();
		long val=0;
		try {
			int c=b.read();
			while(c!='\n'){
				s.append((char)c);
				c=b.read();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return s.toString();
	}
	public static void main(String[] args) {
		long temp1=System.nanoTime(),temp2;
		int  a,b;
		
		String s[]=readInputDemo().split("\\s");
		a=Integer.parseInt(s[0]);
		b=Integer.parseInt(s[1]);
		System.out.println(a+" "+b);
		temp2=System.nanoTime();
		System.out.println(temp2-temp1);
		
		temp1=System.nanoTime();
		Scanner sc=new Scanner(System.in);
		a=sc.nextInt();
		b=sc.nextInt();
		System.out.println(a+" "+b);
		temp2=System.nanoTime();
		System.out.println(temp2-temp1);
		
		temp1=System.nanoTime();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		try {
			String p[]=br.readLine().split("\\s");
			a=Integer.parseInt(p[0]);
			b=Integer.parseInt(p[1]);
			System.out.println(a+" "+b);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		temp2=System.nanoTime();
		System.out.println(temp2-temp1);
		
		/*BufferedInputStream b=new BufferedInputStream(System.in);
		try {
			System.out.println((char)b.read());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

}

package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Arpit on 14-Dec-15.
 */
public class JosephusCircular {
    public static void main(String[] args) {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t,n,p;
        String temp[];
        try {
            t=Integer.parseInt(br.readLine());
            while(t-->0){
                temp=br.readLine().split("\\s");
                n= Integer.parseInt(temp[0]);
                p= Integer.parseInt(temp[1]);
                int m= (int) ( Math.log(n)/Math.log(2));
                int f= (int) Math.pow(2,m);
                if (f==n)f=p;
                else {
                    f=2*(n-f)+p;
                    if (f>n)f=f%n;
                }
                System.out.println(f);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by hardCode on 1/25/2016.
 */
public class ChefAndFruits {
    public static void main(String[] args) throws IOException {
        int n,m,k,p,q,t,temp;
        String s[];
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        t=Integer.parseInt(br.readLine());

        while (t-->0){
            s=br.readLine().split("\\s");
            n=Integer.parseInt(s[0]);
            m=Integer.parseInt(s[1]);
            k=Integer.parseInt(s[2]);

            p=(n<m?n:m);
            q=(n>m?n:m);
            p+=k;
            temp=p-q;

            if (temp>=0) System.out.println(0);
            else System.out.println(Math.abs(temp));
        }
    }
}

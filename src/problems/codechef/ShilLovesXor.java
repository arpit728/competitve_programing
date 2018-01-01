package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by hardCode on 3/30/2016.
 */
public class ShilLovesXor {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        long t=Long.parseLong(br.readLine()),n;
        while (t-->0){
            n=Long.parseLong(br.readLine());
            if (n==0)
                System.out.println(3);
            else if (n==1)
                System.out.println(1);
            else if (n%4==0)
                System.out.println(n);
            else if (n%4==3)
                System.out.println(n-1);
            else System.out.println(-1);
        }

    }
}

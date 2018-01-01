package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by hardCode on 3/5/2016.
 */
public class MaximizeTheSum {
    static final int MAX=10000001;

    public static void main(String[] args) throws IOException {

        int t;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        t= Integer.parseInt(br.readLine());
        String s1[],s2[];

        long n,k;
        while (t-->0){
            s1=br.readLine().split("\\s");

            n=Long.parseLong(s1[0]);
            k=Long.parseLong(s1[1]);

            s1=br.readLine().split("\\s");
            s2=br.readLine().split("\\s");
            long sum=0,temp1,temp2,sum1=0;

            for (int i = 0; i <n ; i++) {

                temp1=Integer.parseInt(s1[i]);
                temp2=Integer.parseInt(s2[i]);

                sum+=temp1*temp2;
                sum1=max(sum1,Math.abs(temp2));

            }
            sum+=k*sum1;
            System.out.println(sum);
        }
    }

    public static long max(long a,long b){
        return a>b?a:b;
    }
}
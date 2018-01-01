package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Arpit on 20-Dec-15.
 */
public class MathFindSum {
    public static void main(String[] args) throws IOException {
        long t,n,sum;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        t=Integer.parseInt(br.readLine());
        while(t-->0){
            n= Integer.parseInt(br.readLine());
            n=n/10;
            sum=n*(10+(n-1)*5);
            System.out.println(sum);
        }
    }
}

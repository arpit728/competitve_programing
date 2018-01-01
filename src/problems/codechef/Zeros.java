package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by arpit on 17/1/16.
 */
public class Zeros {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n,q;
        long prod=1;

        n=Integer.parseInt(br.readLine());

        String s[]=br.readLine().split("\\s");
        int arr[]=new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=Integer.parseInt(s[i]);
            prod=prod*arr[i];
        }
        int m;
        q= Integer.parseInt(br.readLine());

        for (int i = 0; i < q; i++) {
            q= Integer.parseInt(br.readLine());
            m=Integer.parseInt(convert(prod,q));
            System.out.println(trailingZeros(m));
        }

    }
    public static String convert(long number, int base)
    {
        long quotient = number / base;
        long remainder = number % base;

        if(quotient == 0) // base case
        {
            return Long.toString(remainder);
        }
        else
        {
            return convert(quotient, base) + Long.toString(remainder);
        }
    }

    public static int trailingZeros(int n){

        int count=0;
        while (n%10==0){
            count++;
            n/=10;
        }
        return count;
    }
}

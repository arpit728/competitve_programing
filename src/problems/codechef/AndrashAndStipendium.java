package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by hardCode on 7/5/2016.
 */
public class AndrashAndStipendium {
    static final int MAX_SIZE=100001;
    static byte a[]=new byte[MAX_SIZE];


    public static void main(String[] args)throws IOException{
        int t,n;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[]s;
        t=Integer.parseInt(br.readLine());
        while(t-->0){
            n= Integer.parseInt(br.readLine());
            s=br.readLine().split("\\s");
            for (int i = 0; i < n; i++) {
                a[i]=Byte.parseByte(s[i]) ;
            }
            System.out.println(solve(n));
        }
    }

    private static String solve(int n) {

        if (!failInAny(n) && maxInAny(n) && avg(n)>=4)return "Yes";
        return "No";
    }

    private static byte avg(int n) {
        int sum=0;
        for (int i = 0; i < n; i++) {
            sum+=a[i];
        }
        return (byte)(sum/n);
    }

    private static boolean maxInAny(int n) {
        for (int i = 0; i < n; i++) {
            if (a[i]==5)return true;
        }
        return false;
    }

    private static boolean failInAny(int n) {
        for (int i = 0; i < n; i++) {
            if (a[i]==2)return true;
        }
        return false;
    }
}

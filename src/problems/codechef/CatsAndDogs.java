package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by arpit on 7/1/17.
 */
public class CatsAndDogs {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t,c,d,l;
        String []s;
        t=Integer.parseInt(br.readLine());
        while (t-->0){
            s=br.readLine().split("\\s");
            c=Integer.parseInt(s[0]);
            d=Integer.parseInt(s[1]);
            l=Integer.parseInt(s[2]);
            System.out.println(solve(c,d,l));
        }
    }

    private static String solve(int c, int d, int l) {

        long minLegs=d;
        long totalLegs=(long)(c+d)*4;

        if (c>2*d)
            minLegs+=c-2*d;

        minLegs*=4;

        if (l>=minLegs && l<=totalLegs && l%4==0)return "yes";

        return "no";
    }}

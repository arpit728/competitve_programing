package problems.codejam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by hardCode on 4/9/2016.
 */
public class RevengeOfPancakes {
    static char s[],aux[];

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t;

        aux=new char[101];
        t=Integer.parseInt(br.readLine());
        int k=1;
        while(t-->0){
            StringBuilder s1=new StringBuilder(br.readLine());
            s1.reverse();
            s=s1.toString().toCharArray();
            System.out.println("Case #"+k+": "+foo(s));
            k++;
        }
    }

    private static long foo(char[] s) {
        long count=0;
        for (int i = 0; i < s.length-1; i++) {
            if (s[i]!=s[i+1]){
                count++;
            }
        }
        if (s[0]=='-')count++;
        return count;
    }
}

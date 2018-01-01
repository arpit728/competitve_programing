package misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by arpit on 9/9/16.
 */
public class Binarian {

    final static int MAX=10000001;


    public static void main(String[] args) throws IOException {

        int a[]=new int[100000];
        Arrays.fill(a,10000);
        System.out.println("Length : "+a.length);
        System.out.println(solve(a,a.length));
    }

    private static int solve(int[] a, int length) {
        int hash[]=new int[MAX];

        for (int i = 0; i < length; i++) {
            hash[a[i]]++;
        }

        for (int i = 0; i < (MAX-1); i++) {
            hash[i+1]+=hash[i]/2;
            hash[i]%=2;
        }

        int count=0;
        for (int i = 0; i < (MAX-1); i++) {
            if (hash[i]>0)count++;
        }

        return count;
    }
}

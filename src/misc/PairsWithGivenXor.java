package misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by arpit on 7/12/16.
 */
public class PairsWithGivenXor {

    static final int MAX=100000;

    static int a[]=new int[MAX];
    static int hash[]=new int[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n,x;
        String s[];
        s=br.readLine().split("\\s");
        n=Integer.parseInt(s[0]);
        x=Integer.parseInt(s[1]);
        s=br.readLine().split("\\s");
        for (int i = 0; i <n ; i++) {
            a[i]=Integer.parseInt(s[i]);
        }
        System.out.println(solve(a,n,x));
    }

    private static long solve(int[] a, int n, int x) {

        long result=0;
        for (int i = 0; i < n; i++) {
            hash[a[i]]++;
        }

        for (int i = 0; i < n; i++) {
            int temp=a[i]^x;

            if (temp<=MAX)
                result+=hash[temp];
        }
        if (x==0)
            result-=n;//because pairs(i,i) for all i will have also been added

        result/=2;//because (i,j) and (j,i) both pairs will have added.
        return result;
    }
}

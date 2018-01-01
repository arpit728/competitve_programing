package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by arpit on 19/12/16.
 */
public class ChefAndSubArrays {

    static int[]a=new int[100000];
    static int[]bitCount=new int[32];

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t,n,k;
        String[]s;
        t=Integer.parseInt(br.readLine());

        while (t-->0){
            s=br.readLine().split("\\s");
            n=Integer.parseInt(s[0]);
            k=Integer.parseInt(s[1]);

            s=br.readLine().split("\\s");
            Arrays.fill(bitCount,0);
            for (int i = 0; i < n; i++) {
                a[i]=Integer.parseInt(s[i]);
            }
            System.out.println(solve(n,k));
        }
    }

    private static long solve(int n, int k) {


        //l represents left index and r represents right index of the sub array.
        int l,r=0;
        long ans=0;
        for (l = 0; l < n; l++) {

            while ((r<n) && bitwiseOr(bitCount)<k){

                for (int j =0; j<32; j++) {
                    if ((a[r]&(1<<j))>=1)
                        bitCount[j]++;
                }
                r++;
            }

            if (bitwiseOr(bitCount)>=k)
                ans+=(n-r+1);

            //This loop removes the effect of element with lth index from bitcount array.
            for (int j = 0; j < 32; j++) {
                if ((a[l]&(1<<j))>=1)bitCount[j]--;
            }
        }
        return ans;
    }

    //returns the bitwise xor of elements between l to r inclusive based on bitcount array.
    private static long bitwiseOr(int[] bitCount) {

        long ans=0;
        for (int i = 0; i < 32; i++) {
            if (bitCount[i]>0)ans+=(1<<i);
        }
        return ans;
    }
}

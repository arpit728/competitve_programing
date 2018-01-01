package hiringchallenges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by arpit on 8/2/17.
 */
public class CoolNumbers {

    static int coolNumbers[]=new int[1023];
    static int idx=0,k;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t,l,r;
        String[]s;
        t=Integer.parseInt(br.readLine());
        generate(1,0);
        Arrays.sort(coolNumbers);
        System.out.println(Arrays.toString(coolNumbers));
        while (t-->0){
            k=0;
            s=br.readLine().split("\\s");
            l=Integer.parseInt(s[0]);
            r=Integer.parseInt(s[1]);
            System.out.println(solve(l,r));
        }
    }

    private static void generate(int i, int n) {
        if (i<10){
            int x=n*10+2;
            int y=n*10+5;
            coolNumbers[idx++]=x;
            coolNumbers[idx++]=y;
            generate(i+1,x);
            generate(i+1,y);
        }
    }

    private static long solve(int l, int r) {

        long ans=0,a=0;
        for (long i =l; i <=r; ) {a++;
            long x=gt(i);

            if (x>=r){
                ans+= (r-i+1) *x;
                break;
            }
            else {
                ans+= (x-i+1) *x;
                i=x+1;
            }
            //if (a%100000==0) System.out.println(ans+ " "+x+" "+i);
            //System.out.println("x = "+x+" "+" ans = "+ans);
        }
        return ans;
    }
    private static long gt(long i) {

        //if (coolNumbers[k]>i)return coolNumbers[k];
        for (int k=0; k <1023; k++) {
            if (coolNumbers[k]>=i)return coolNumbers[k];
        }
        return 2222222222L;
    }
}

package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by hardCode on 4/17/2016.
 */
public class OddDivisors {
    static final int MAX_lIMIT = 100001;
    static int[]lp=new int[MAX_lIMIT];
    static long  []dp= new long[MAX_lIMIT];

    //for sieve based solution
     static long []f=new long[MAX_lIMIT];

    static void sieve(){
        for (int i=2;i<MAX_lIMIT;i+=2){
            lp[i]=2;
        }
        for (int i=3;i<MAX_lIMIT; i+=2){

            if (lp[i]==0){
                lp[i]=i;
                for (int j=i*i;j<MAX_lIMIT && j>0;j+=2*i){
                    if (lp[j]==0){
                        lp[j]=i;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine()),n,l,r;
        String s[];
        sieve();
        sieve2();//for based solution
        //System.out.println(Arrays.toString(f));
        dp[1]=1;
        lp[1]=1;
        while (t-->0){
            s=br.readLine().split("\\s");
            l=Integer.parseInt(s[0]);
            r=Integer.parseInt(s[1]);
            System.out.println(sieveBasedSolution(l,r));
        }
    }

    private static long findSum(int l, int r) {

        long sum=0;

        for (int i = l; i <= r; i++) {
            sum+=oddSum(i);
            //System.out.println("sum "+i+": "+sum);
        }
        return sum;
    }

    private static long oddSum(int i) {
        if (dp[i]!=0)return dp[i];
        int temp=i,base,pow=0,n=i;
        long sum=1,currentSum;

        while (lp[temp]%2==0){
            temp/=2;
        }
        while (temp>1){

            i=temp;

            while (temp%lp[i]==0){
                pow++;
                //System.out.println(temp+" "+i+" "+lp[i]);
                temp/=lp[i];
            }

            currentSum= (long) (Math.pow(lp[i],pow+1)-1)/(lp[i]-1);
            sum*=currentSum;
            pow=0;
            //System.out.println("c & cs"+sum+" "+currentSum);
        }
        dp[n]=sum;
        return dp[n];
    }

    //This is another sieve based solution that takes O(n logn) time to pre-compute sum of all odd divisor of number 1<=i<=m

    static void sieve2(){
        for (int i = 1; i <MAX_lIMIT ; i+=2) {
            for (int j = i; j <MAX_lIMIT ; j+=i) {
                f[j]+=i;
            }
        }
    }
    static long sieveBasedSolution(int l,int r){

        long sum=0;
        for (int i = l; i <=r; i++) {
            sum+=f[i];
        }
        return sum;
    }

}

package problems.codechef;

import java.io.BufferedInputStream;
import java.io.IOException;

/**
 * Created by Arpit on 16-Dec-15.
 */
public class SimpleSum {

    static final int MAX_lIMIT = 10000001;
    static int[]lp=new int[MAX_lIMIT];
    static void sieve(){
        for (int i=2;i<MAX_lIMIT;i+=2){
            lp[i]=2;
        }
        for (int i=3;i<MAX_lIMIT;i+=2){
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

    static long calculateSum(long n,long c){
        long temp1= (long) (Math.pow(n,2*c+1)+1);
        n++;
        return temp1/n;
    }

    static long readInput(){
        long ret = 0;
        try{

            BufferedInputStream b=new BufferedInputStream(System.in);
            char c = (char) b.read();
            while(c<'0' || c>'9') c = (char) b.read();

            while(c>='0' && c<='9') {
                ret = 10 * ret + c - 48;
                c = (char) b.read();
            }
            //b.close();
        }catch (IOException e) {

            e.printStackTrace();
        }
        return ret;
    }

    public static void main(String[] args) {
        sieve();
        long t=readInput();
        long ans,count;
        int n,i,temp;
        while(t-->0){
            n=(int)readInput();
            ans=1;
            if (n==lp[n])ans=n*(n-1)+1;
            else {
                temp=n;
                while (temp>1){
                    count=0;i=temp;
                    while (temp%lp[i]==0){
                        count++;
                        temp/=lp[i];
                    }
                    ans=ans*calculateSum(lp[i],count);
                }
            }
            System.out.println(ans);
        }
    }
}

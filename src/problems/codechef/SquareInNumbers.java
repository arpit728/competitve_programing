package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by hardCode on 6/25/2016.
 */
public class SquareInNumbers {

    static final int MAX_lIMIT = 1000001;
    static int[]lp=new int[MAX_lIMIT],hash=new int[MAX_lIMIT];
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

    public static void main(String[] args) throws IOException {
        int t,n,a[]=new int[MAX_lIMIT],temp,ans=0;
        String s[];
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        t=Integer.parseInt(br.readLine());

        while(t-->0){
            n=Integer.parseInt(br.readLine());
            s=br.readLine().split("\\s");

            for (int i = 0; i < n; i++) {
                a[i]=Integer.parseInt(s[i]);
            }

            for (int i = 0; i <n ; i++) {
                    temp=a[i];
                while(temp>0){
                    hash[lp[temp]]++;
                    if (hash[temp]>=2)ans=temp;
                    temp/=lp[temp];
                }
            }
            System.out.println(ans);
        }
    }

}

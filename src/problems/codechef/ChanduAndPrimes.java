package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by arpit on 23/1/16.
 */
public class ChanduAndPrimes {

    static boolean primes[];

    static void sieve(){

        for (int i = 4; i < 1000001; i++) {
            if (i%2==0)primes[i]=false;
        }

        for (int i = 3; i < 10001; i+=2) {
            for (int j = i*i; j < 1000001;j+=2*i) {
                if (j%i==0)primes[j]=false;
            }
        }
        primes[0]=false;
        primes[1]=false;
    }

    public static void main(String[] args) throws IOException {

        int q,l,r;
        String s[];
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        q=Integer.parseInt(br.readLine());
        primes=new boolean[1000001];
        Arrays.fill(primes,true);
        sieve();
        /*for (int i = 110; i <=114; i++) {
            System.out.print(primes[i]+" ");

        }*/

        System.out.println(q);
        while(q-->0){

            s=br.readLine().split("\\s");
            l=Integer.parseInt(s[0]);
            r=Integer.parseInt(s[1]);

            int ans=0;
            //System.out.println(l+" "+r);
            for (int i = l; i<=r; i++) {

                int temp=i,div=10,rem=0,rem1=0;
                //System.out.println(div);

                do
                {
                    //System.out.println("arpit");

                    rem=temp%div;
                    if (primes[rem]){
                        ans++;
                        break;
                    }

                    else div *= 10;

                }while(rem!=i);


            }
            System.out.println(ans);

        }

    }
}

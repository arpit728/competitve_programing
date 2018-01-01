package misc;

import java.util.Arrays;

import static java.lang.Math.sqrt;

/**
 * Created by hardCode on 3/7/2017.
 *
 * problem link :- http://www.geeksforgeeks.org/number-maximum-number-prime-factors/
 */
public class NumberWithMaximumPrimeFactorsLessThanN {

    static int primeFactors[]=new int[100000];
    static boolean composite[]=new boolean[51];
    public static void main(String[] args) {

        System.out.println(solve(40));
        System.out.println(solve1(40));
    }

    //function sieve1 and solve1 together work for the third approach which is more efficient one.

    private static int solve1(int n) {

        sieve1(n);
        int ans=1;
        for (int i = 2; i <n ; i++) {
            if (!composite[i]){
                if (ans*i<n){
                    ans*=i;
                }
                else return ans;
            }
        }
        return 0;
    }

    private static int sieve1(int n) {

        for (int i = 4 ; i <n ; i+=2) {
            if(i%2==0)
                composite[i] = true;
        }

        int p= (int) sqrt(n);

        for (int i = 3; i <= p; i++) {
            if (!composite[i]){
                for (int j = i * i; j < n; j += 2 * i) {
                    composite[j]=true;
                }
            }
        }

        return 0;
    }


    //This two function together contribute for the approach which is less efficient than the above one.
    private static int solve(int n) {

        sieve(n);
        int ans=0,maxFactor=1;

        for (int i = 2; i <n; i++) {

            if (primeFactors[i]>maxFactor){
                maxFactor=primeFactors[i];
                ans=i;
            }
        }
        return ans;
    }

    private static void sieve(int n) {

        for (int i = 2 ; i <n ; i+=2) {
            if(i%2==0)
                primeFactors[i]++;
        }
        int p= (int) sqrt(n);

        for (int i = 3; i <=p; i++) {

            if (primeFactors[i]==0)
                for (int j = i; j <n ; j+=i) {
                    primeFactors[j]++;
                }
        }
    }

}

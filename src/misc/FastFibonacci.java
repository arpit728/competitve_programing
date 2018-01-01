package misc;

import com.sun.org.apache.xpath.internal.operations.Mod;

/**
 * Created by arpit on 11/9/16.
 */
public class FastFibonacci {

    final static long MOD=1000000007;

    long x = 0, y = 1;

    public static void main(String[] args) {

        int A=3,B=4,N=5;

        System.out.println(new FastFibonacci().solution(A, B, N));
    }

    public long solution(int A,int B,int N){

        return ((mulmod(fib(N-1),A,MOD) + mulmod(fib(N),B,MOD))%MOD);

    }

    long mulmod(long a,long b, long m)
    {

        long q= (a * b) / m;
        long r=a*b-q*m;

        if(r>m)r%=m;
        if(r<0)r+=m;
        return r;
    }

    long fib( long n) {
        if (n==0){
            x= 0;
            y=1;
        }
        else {
            long a=0, b=1;
            fib(n >> 1);
            long z = (b << 1) - a;
            if (z < 0) z += MOD;
            x = mulmod(a, z, MOD);
            y = mulmod(a, a, MOD) + mulmod(b, b, MOD);
            if (y >= MOD) y -= MOD;
            if ((n&1)==1) {
                x += y;
                if (x >= MOD) x -= MOD;
                x ^= y ^= x ^= y;
            }
        }
        return x;
    }

}

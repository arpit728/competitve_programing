package misc;

/**
 * Created by arpit on 9/9/16.
 */
public class Fibonacci {

    static final int MOD=1000000007;

    public static void main (String args[])
    {
        int a=Integer.MAX_VALUE,b=Integer.MAX_VALUE,n =1000000000;
        System.out.println(solution(a,b,n));
    }

    static int fib(int a,int b,int n)
    {
        int F[][] = new int[][]{{1,1},{1,0}};
        if (n == 0)
            return a;
        if (n==1)return b;
        power(F, n-1);

        long ans=((((long)a*F[0][1])%MOD)+ (((long)b*F[0][0])%MOD))%MOD;

        return (int)(ans);
    }

    /* Helper function that multiplies 2 matrices F and M of size 2*2, and
    puts the multiplication result back to F[][] */
    static void multiply(int F[][], int M[][])
    {
        int x = (int)((((long)F[0][0]*M[0][0])%MOD + ((long)F[0][1]*M[1][0])%MOD)%MOD);
        int y = (int)((((long)F[0][0]*M[0][1])%MOD + ((long)F[0][1]*M[1][1])%MOD)%MOD);
        int z = (int)((((long)F[1][0]*M[0][0])%MOD + ((long)F[1][1]*M[1][0])%MOD)%MOD);
        int w = (int)((((long)F[1][0]*M[0][1])%MOD + ((long)F[1][1]*M[1][1])%MOD)%MOD);

        F[0][0] = x;
        F[0][1] = y;
        F[1][0] = z;
        F[1][1] = w;
    }

    /* Helper function that calculates F[][] raise to the power n and puts the
    result in F[][]
    Note that this function is designed only for fib() and won't work as general
    power function */
    static void power(int F[][], int n)
    {
        int i;
        int M[][] = new int[][]{{1,1},{1,0}};

        // n - 1 times multiply the matrix to {{1,0},{0,1}}
        for (i = 2; i <= n; i++)
            multiply(F, M);
    }

    /* Driver program to test above function */



    public static int solution(int A,int B,int N){

       /* if (N==0)return A;
        if (N==1)return B;*/
            return fib(A,B,N);
    }
}

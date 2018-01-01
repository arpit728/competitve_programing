package hiringchallenges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by bugkiller on 9/2/2017.
 */
public class PeopleStrongKilljeeAndEasyProblem1 {

    static int a[]=new int[100000];
    static long M=10000000011L;
    static long m[] = {3, 191, 17452007};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;
        String[]s;
        n = Integer.parseInt(br.readLine());
        s = br.readLine().split("\\s");

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(s[i]);
            a[i] = countSetBits(a[i]);
        }

        System.out.println(solve(n));
    }

    private static long solve(int n) {
        long sum=0;long temp=0;
        for (int i = 0; i < n; i++) {
            temp=0;
            for (int j = 0; j < 3; j++) {
                long b=powMod(a[i],i+1,m[j]);
                long y = M / m[j];
                long z = powMod(y, m[j] - 2,m[j]);

                System.out.println(b+" "+y+" "+z);
                temp=(temp+((((b%M)*y)%M)*z)%M)%M;
            }
            sum=(sum+temp)%M;
        }
        return sum;
    }

    public static long powMod(long a, long x,long M) {
        long result=1;
        if (x==0)return 1;
        if (x==1)return a;
        while (x > 0) {
            if ((x & 1) == 1) {
                result = (result*a)%M;
            }
            a = (a * a)%M;
            x >>=1;
        }
        return result;

    }

    private static int countSetBits(int n) {
        int cnt=0;
        for (int i = 0; i < 32; i++) {
            if (((1<<i)&n)>=1)
                cnt++;
        }

        return cnt;
    }

}

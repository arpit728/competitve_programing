package hiringchallenges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Created by bugkiller on 7/15/2017.
 */
public class PeopleStrongKilljeeAndEasyProblem {

    static int a[]=new int[100000];
    static long M=10000000011L;
    static BigInteger bigM=new BigInteger(10000000011L+"");
    static BigInteger zero = new BigInteger(0 + "");
    static BigInteger two = new BigInteger(2 + "");
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;
        String[]s;
        n = Integer.parseInt(br.readLine());
        s = br.readLine().split("\\s");

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(s[i]);
        }

        System.out.println(solve(n));
    }

    private static BigInteger solve(int n) {
        int cnt;
        BigInteger sum=new BigInteger(0+"");
        for (int i = 0; i < n; i++) {
            cnt=0;
            for (int j = 0; j < 32; j++) {
                if ((a[i] & (1 << j)) > 0) {
                    cnt++;
                }
            }
            sum=sum.add(moduloExp(new BigInteger(cnt + ""), new BigInteger(i + 1 + ""))).mod(bigM);
        }
        return sum;
    }

    public static BigInteger moduloExp(BigInteger  cnt, BigInteger exp) {

        BigInteger ans=new BigInteger(1+"");
        BigInteger bigCnt=new BigInteger(cnt+"");
        while (exp.compareTo(zero)>0){
            if (exp.mod(two).compareTo(zero)>0)
            {
                ans=ans.multiply(cnt).mod(bigM);
            }
            cnt=cnt.multiply(cnt).mod(bigM);
            exp=exp.shiftRight(1);
        }
        return ans;
    }
}

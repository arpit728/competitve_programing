package problems.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

/**
 * Created by hardCode on 4/14/2016.
 */
public class FiboncciModified {

    static BigInteger dp[];

    public static void main(String[] args) throws IOException {

        int n;
        BigInteger re=BigInteger.ONE;
        String s[]=new BufferedReader(new InputStreamReader(System.in)).readLine().split("\\s");
        dp=new BigInteger[22];
        Arrays.fill(dp,BigInteger.ZERO);
        dp[1]= re.multiply(BigInteger.valueOf(Integer.parseInt(s[0])));
        dp[2]= re.multiply(BigInteger.valueOf(Integer.parseInt(s[1])));
        n=Integer.parseInt(s[2]);

        System.out.println(solve(n));
        //System.out.println(Arrays.toString(dp));
    }

    static BigInteger solve(int n){

        if (n==1 && dp[n]==BigInteger.ZERO)return BigInteger.ZERO;
        else if (n==2 && dp[n]==BigInteger.ZERO)return BigInteger.ZERO;
        else if (n>0 && dp[n]!=BigInteger.ZERO)return dp[n];
        else {
            BigInteger result=solve(n-1);
            result=result.pow(2);
            result=result.add(solve(n-2));
            dp[n]=result;
            return dp[n];
        }

    }

}

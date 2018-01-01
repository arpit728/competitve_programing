package hiringchallenges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class MonkAndAtm {

    static final int MAX=33001;
    static boolean prime[]=new boolean[MAX];

    //if prime[i]=false it means i is the prime no.

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));

        int testCases,n;

        sieveOfEratosthenes();
        testCases=Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder=new StringBuilder();

        while (testCases-- > 0) {
            n=Integer.parseInt(bufferedReader.readLine());
            stringBuilder.append(solve(n) + "\n");
        }
        System.out.print(stringBuilder.toString());
    }

    private static int solve(int n) {

        int ans=0;
        for (int i = 1; i*i<=n ; i++) {

            if (n%i==0){
                int factor1=countFactors(n/i);
                int factor2=countFactors(i);
                if (isPowerOf2(factor1)){
                    return factor1;
                }

                else if (isPowerOf2(factor2)){
                    ans=Integer.max(ans,factor2);
                }
            }
        }

        return ans;
    }

    static int countFactors(int n){
        int exp=1,ans=1;
        if (n%2==0){
            while (n%2==0){
                n/=2;
                exp++;
            }
        }
        ans*=exp;
        for (int i = 3; i*i<= n; i+=2) {
            if (!prime[i] && n%i==0){
                exp=1;
                while (n%i==0){
                    n/=i;
                    exp++;
                }
                ans*=exp;
            }
        }

        if (n>1)ans*=2;

        return ans;
    }

    public static boolean isPowerOf2(int number) {
        if (number==1)
            return true;
        if ((number&1)==1 || number==0)
            return false;

        return isPowerOf2(number >> 1);
    }

    private static void sieveOfEratosthenes() {
        prime[0]=true;
        prime[1]=true;
        for (int i = 4; i <MAX; i+=2) {
            prime[i]=true;
        }
        for (int i = 3; i<MAX ; i++) {
            for (int j =i*i; j <MAX ; j+=2*i) {
                prime[j]=true;
            }
        }

    }

}

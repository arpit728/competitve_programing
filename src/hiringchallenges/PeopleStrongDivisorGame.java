package hiringchallenges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Integer.max;

/**
 * Created by bugkiller on 7/15/2017.
 */
public class PeopleStrongDivisorGame {

    static boolean notPrime[] = new boolean[330];
    static int a[] = new int[100001];
    static int[] pre = new int[100001];
    public static void main(String[] args) throws IOException {
        new Thread(null, new Runnable() {

            public void run() {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                int t,n;
                String[] s;
                try {


                t = Integer.parseInt(br.readLine());
                int p=1;
                while (t-- > 0) {
                    n = Integer.parseInt(br.readLine());
                    s = br.readLine().split("\\s");
                    for (int i = 1; i <=n; i++) {
                        a[i] = Integer.parseInt(s[i-1]);
                        a[i]=factorCount(a[i]);
                        pre[i] = pre[i-1] + a[i];
                    }

                            System.out.println(solve(a,n));

                }
                }
                catch (Exception e){

                }
            }
        }, "1", 1 << 25).start();
    }

    private static int solve(int[] a, int n) {

        return countScore(a,1,n);
    }

    private static int countScore(int[] a, int start, int end) {

        if (end>start) {
            //System.out.println(start+" "+end);
            int partIndex = findPartition(start, end);
            //System.out.println(partIndex);
            if (partIndex < 0) {
                return 0;
            }

            return max(countScore(a, start, partIndex), countScore(a, partIndex + 1, end)) + 1;
        }
        return 0;
    }

    private static int findPartition(int start, int end) {
        int segSum = pre[end] - pre[start - 1];
        int currSum=0;
        if (segSum%2==1)
            return -1;
        for (int i =end; i>=start ; i--) {
            segSum -= a[i];
            currSum += a[i];
            if (currSum == segSum) {
                return i - 1;
            }
        }
        return -1;
    }

    private static int factorCount(int x) {

        if (x==0)return 0;
        int n = (int) Math.sqrt(x);
        int cnt = 0;
        for (int i = 1; i <= n; i++) {

            if (x % i == 0) {
                cnt += 2;
            }
        }
        if (x== n * n) {
            cnt -= 1;
        }

        return cnt;
    }




    private static void sieve() {
        for (int i = 2; i <= 350; i++) {
            for (int j = 2*i; j <=350 ; j++) {
                if (j%i==0){
                    notPrime[i]=true;
                }
            }
        }
    }
}

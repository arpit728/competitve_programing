package hiringchallenges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by bugkiller on 7/8/2017.
 */
public class DelhiveryCountThePermutation {

    static long dynamicProgramming[] = new long[1001];
    static long M=1000000009;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t,a,s;
        String[]in;
        t = Integer.parseInt(br.readLine());
        while (t-->0){

            in = br.readLine().split("\\s");
            a = Integer.parseInt(in[0]);
            s =  Integer.parseInt(in[1]);

            Arrays.fill(dynamicProgramming,0, a + 1, 0);
            System.out.println(solve(a,s));
        }

    }

    public static long solve(int a, int s) {
        Arrays.fill(dynamicProgramming,0, a + 1, 0);

        dynamicProgramming[0]=1;
        if (s>a)return 0;
        int n = a - s + 1;
        int k=s;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= a; j++) {
                if (k<=j){
                    dynamicProgramming[j] =(dynamicProgramming[j]%M+ dynamicProgramming[j - k]%M)%M;
                }
            }
            k++;
        }
        return dynamicProgramming[a];
    }
}

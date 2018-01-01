package meetup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by bugkiller on 8/19/2017.
 */
public class SumMultiple3And5 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(solve(n));
    }

    private static int solve(int n) {

        int sum=0;
        for (int i = 3; i <=n; i++) {
            if (i%3==0 || i%5==0)
                sum+=i;
        }
        return sum;
    }
}

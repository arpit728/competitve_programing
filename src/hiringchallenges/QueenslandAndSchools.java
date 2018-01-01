package hiringchallenges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Integer.max;

/**
 * Created by bugkiller on 7/1/2017.
 */
public class QueenslandAndSchools {

    static final int MAX=1006;
    static int a[]=new int[MAX];
    static int[] b=new int[MAX];
    static int T[]=new int[MAX];

    //T is the dp array

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int x,n;
        String[]s;
        x = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            s = br.readLine().split("\\s");
            a[i] = Integer.parseInt(s[0]);
            b[i] = Integer.parseInt(s[1]);
        }

        System.out.println(mySolve(x,n));
    }

    private static int solve(int x, int n) {

        for (int i = 0; i <= x; ++i) {
            for (int j = 0; j < n; ++j) {
                if (a[j] <= i) {
                    T[i] = max(T[i], T[i - a[j]] + b[j]);
                }
            }
        }
        return T[x];
    }

    private static int mySolve(int x, int n) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= x; j++) {
                if (a[i] <= j) {
                    T[j] = max(T[j], T[j - a[i]] + b[i]);
                }
            }
        }
        return T[x];
    }
}

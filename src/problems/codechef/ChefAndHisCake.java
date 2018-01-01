package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChefAndHisCake {

    public static final char GREEN = 'G';
    public static final char RED = 'R';
    public static char a[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t,n,m;
        String s[];
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            s = br.readLine().split("\\s");
            n = Integer.parseInt(s[0]);
            m = Integer.parseInt(s[1]);
            a = new char[n][];
            for (int i = 0; i < n; i++) {
                a[i] = br.readLine().toCharArray();
            }
            System.out.println(solve(a, n, m));
        }
    }

    private static int solve(char[][] a, int n, int m) {
        return Integer.min(calculateCost(GREEN, a, n, m), calculateCost(RED, a, n, m));
    }

    private static int calculateCost(char startsWith, char[][] a, int n, int m) {
        int cost = 0;
        char expected;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                expected = startsWith;
            }
            else {
                if (startsWith == GREEN) {
                    expected = RED;
                } else {
                    expected = GREEN;
                }
            }
            for (int j = 0; j < m; j++) {
                if (a[i][j] != expected) {
                    if (a[i][j] == GREEN) {
                        cost += 3;
                    } else cost += 5;
                }
                if (expected == GREEN) {
                    expected = RED;
                } else expected = GREEN;
            }
        }
        return cost;
    }
}

package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Created by bugkiller on 9/3/2017.
 */
public class ShortestPathInBinaryTree {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, u, v;
        String[]s;
        n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            s = br.readLine().split("\\s");
            u = Integer.parseInt(s[0]);
            v = Integer.parseInt(s[1]);
            System.out.println(solve(u, v));
        }
    }

    private static int solve(int u, int v) {

        int cnt = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        while (true) {
            map.put(u, cnt);

            if (u==1)
                break;
            cnt++;
            u >>= 1;
        }
        cnt = 0;
        //System.out.println("I am working");
        while (!map.containsKey(v)) {
            cnt++;
            v >>= 1;
        }
        return cnt+map.get(v);
    }
}

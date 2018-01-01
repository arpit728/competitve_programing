package misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by bugkiller on 8/26/2017.
 */
public class MaxXorSubArrayWith2DTrie {

    static int a[] = new int[100000];
    static int pre[] = new int[100000];

    static int[][] trie = new int[2][10000000];

    static int idx= 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int n;
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(br.readLine());
            }
            System.out.println(solve(a,n));
        }
    }

    private static int solve(int[] a, int n) {
        int ans = 0;

        idx = 0;
        fillPrefix(a, n);
        Arrays.fill(trie[0], -1);
        Arrays.fill(trie[1], -1);

        insert(0);
        for (int i = 0; i < n; i++) {
            insert(pre[i]);
        }

        for (int i = 0; i < n; i++) {
            ans = Integer.max(ans, query(pre[i]));
        }

        return ans;
    }

    private static int query(int key) {

        int ans = 0, r = 0;

        for (int i = 31; i >= 0; i--) {

            int currBit = (key >> i) & 1;

            if (trie[1 - currBit][r] > 0) {
                r = trie[1 - currBit][r];
                ans |= ((1 - currBit) << i);
            }
            else if (trie[currBit][r]>0) {
                r=trie[currBit][r];
                ans |= (currBit << i);
            }
        }

        return ans ^ key;
    }

    private static void insert(int x) {

        int r = 0;
        for (int i = 31; i >= 0; i--) {

            int currBit = (x >> i) & 1;

            if (trie[currBit][r] > 0) {
                r = trie[currBit][r];
            }
            else {
                idx++;
                trie[currBit][r] = idx;
                r = idx;
            }
        }
    }



    private static void fillPrefix(int[] a, int n) {
        pre[0] = a[0];
        for (int i = 1; i < n; i++) {
            pre[i] = a[i] ^ pre[i - 1];
        }
    }
}

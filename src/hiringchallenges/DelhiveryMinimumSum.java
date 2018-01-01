package hiringchallenges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by bugkiller on 8/5/2017.
 */

public class DelhiveryMinimumSum {

    static int a[] = new int[100];

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t,n,k;
        String[]s;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            s = br.readLine().split("\\s");
            n = Integer.parseInt(s[0]);
            k = Integer.parseInt(s[1]);
            s = br.readLine().split("\\s");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(s[i]);
            }

            System.out.println(solve(a, n, k));
        }
    }

    private static int solve(int[] a, int n, int k) {
        int minSum = Integer.MAX_VALUE;

        ArrayList<Integer> in = new ArrayList<>(), out = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum=0;
                in.clear();
                out.clear();
                for (int l = 0; l < n; l++) {
                    if (l >= i && l <= j) {
                        in.add(a[l]);
                        sum += a[l];
                    }
                    else
                        out.add(a[l]);
                }
                Collections.sort(in);
                Collections.sort(out);
                int inPointer=in.size()-1;
                int outPointer = 0;
                int tempK=k;
                if (k > Integer.min(in.size(), out.size())) {
                    tempK = Integer.min(in.size(), out.size());
                }
                for (int l = 0; l < tempK; l++) {
                    if (in.get(inPointer) > out.get(outPointer)) {
                        sum = sum - (in.get(inPointer) - out.get(outPointer));
                        inPointer--;
                        outPointer++;
                    }
                    else {
                        break;
                    }
                }
                minSum = Integer.min(sum, minSum);
            }
        }
        return minSum;
    }
}

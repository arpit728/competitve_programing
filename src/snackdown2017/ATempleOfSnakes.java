package snackdown2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Long.min;
/**
 * Created by arpit on 28/5/17.
 */
public class ATempleOfSnakes {

    static final int MAX=100000;

    static int []prefix=new int[MAX],inclen=new int[MAX],declen=new int[MAX],a=new int[MAX];
    static long[]incop=new long[MAX],decop=new long[MAX];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t,n;
        String[]s;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            s = br.readLine().split("\\s");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(s[i]);
            }

            System.out.println(solve(a,n));
        }
    }

    private static long solve(int[] a, int n) {
        fillPrefix(a,n);
        fillSuffix(a, n);

        long minOperations=prefix[n-1]-1,op;
        int left,right;
        for (int i = 1; i < n - 1; i++) {
            op = 0;

            if (inclen[i - 1] < a[i] && a[i] > declen[i + 1]) {

                if (inclen[i - 1] > declen[i + 1]) {
                    op = decop[i + 1] + incop[i - 1] - incop[i - declen[i + 1] - 1];
                    op += (long) a[i] - (declen[i + 1] + 1);
                    op += (long) declen[i + 1] * (inclen[i - 1] - declen[i + 1]);
                    left = i - declen[i + 1];
                    right = i + declen[i + 1];
                }
                else if (inclen[i - 1] < declen[i + 1]) {
                    op = incop[i - 1] + decop[i + 1] - decop[i + inclen[i - 1] + 1];
                    op += (long) inclen[i - 1] * (declen[i + 1] - inclen[i - 1]);
                    op += a[i] - (inclen[i - 1] + 1);
                    left = i - inclen[i - 1];
                    right = i + inclen[i - 11];
                }
                else {
                    op = incop[i - 1] + decop[i + 1];
                    op += a[i] - (inclen[i - 1] + 1);
                    left = i - inclen[i - 1];
                    right = i + inclen[i - 1];
                }
            }
            else if (inclen[i - 1] < a[i] && a[i] < declen[i + 1]) {
                op = incop[i - 1] + decop[i + 1] - decop[i + inclen[i - 1] + 1];
                op += (long) inclen[i - 1] * (declen[i + 1] - inclen[i - 1]);
                op += a[i] - (inclen[i - 1] + 1);
                left = i - inclen[i - 1];
                right = i + inclen[i - 1];
            }
            else if (inclen[i - 1] > a[i] && a[i] > declen[i + 1]) {
                op = decop[i + 1] + incop[i - 1] - incop[i - declen[i + 1] - 1];
                op += (long) declen[i + 1] * (inclen[i - 1] - declen[i + 1]);
                op += a[i] - (decop[i + 1] + 1);
                left = i - declen[i + 1];
                right = i + declen[i + 1];
            }
            else if (inclen[i - 1] >= a[i] && a[i] <= declen[i + 1]) {
                op = incop[i - 1] - incop[i - a[i]];
                op += decop[i + 1] - decop[i + a[i]];
                op += ((long) a[i] - 1) * (inclen[i - 1] - a[i] + 1) + (declen[i + 1] - a[i] + 1) * ((long) a[i] - 1);
                left = i - a[i];
                right = i + a[i];
            }
            else if (a[i] > declen[i + 1]) {
                op = decop[i + 1] + incop[i - 1] - incop[i - declen[i + 1] - 1];
                op += a[i] - (declen[i + 1] + 1);
                op += (long) declen[i + 1] * (inclen[i - 1] - declen[i + 1]);
                left = i - declen[i + 1];
                right = i + declen[i + 1];
            }
            else {
                op = incop[i - 1] + decop[i + 1] - decop[i + inclen[i - 1] + 1];
                op += a[i] - (inclen[i - 1] + 1);
                op += (long) inclen[i - 1] * (declen[i + 1] - inclen[i - 1]);
                left = i - inclen[i - 1];
                right = i + inclen[i - 1];
            }
            //System.out.println(left+" "+right);
            if (left>0)
                op += prefix[n - 1] - (prefix[right] - prefix[left - 1]);
            else
                op+=prefix[n - 1] - prefix[right];
            minOperations = min(minOperations, op);
        }
        return minOperations;
    }

    private static void fillSuffix(int[] a, int n) {

        declen[n-1]=1;
        decop[n-1]=a[n-1]-1;
        for (int i = n - 1; i > 0; i--) {
            if (a[i] > declen[i + 1]) {
                declen[i]=declen[i+1]+1;
                decop[i] = decop[i + 1] + a[i] - declen[i];
            }
            else {
                declen[i] = 1;
                decop[i]=a[i]-1;
            }
        }
    }

    private static void fillPrefix(int[] a, int n) {
        prefix[0] = a[0];
        inclen[0]=1;
        incop[0]=a[0]-1;
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + a[i];
            if (a[i] > inclen[i - 1]) {
                inclen[i]=inclen[i-1]+1;
                incop[i] = incop[i - 1] + a[i] - inclen[i];
            }
            else {
                inclen[i]=1;
                incop[i]=a[i]-1;
            }
        }
    }
}

package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Integer.max;
import static java.lang.Integer.min;
/**
 * Created by hardCode on 2/25/2017.
 */
public class BearAndBribingTree {

    final static int MAX = 1<<17;
    static int[] a = new int[MAX];
    static BufferedReader br;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        int t,h,k,n;
        String[] s;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            s=br.readLine().split("\\s");
            h=Integer.parseInt(s[0]);
            k=Integer.parseInt(s[1]);
            n=1<<h;
            readArray(a, n);
            System.out.println(solve(a,n,h,k));
        }
    }



    private static int solve(int[] a, int n, int h, int k) {
        int bribe = 0;

        for (int i = 0; i < h; i++) {
            int p=1;
            if (a[1]>a[0]){
                if (a[1]-a[0]>k)
                    return -1;
                else bribe++;
            }
            for (int j =2; j <n-1 ; j+=2) {
                int max=max(a[j],a[j+1]);
                int min=min(a[j],a[j+1]);
                if (max<a[0])
                    a[j-p]=max;
                else if (max - min <= k) {
                    bribe++;
                    a[j-p]=min;
                }
                else a[j-p]=max;
                p++;
            }
            n>>>=1;
            for (int j = 0; j < n; j++) {
                System.out.print(a[j] + " ");
            }
            System.out.println();
        }
        return bribe;
    }

    private static void readArray(int[] a, int n) throws IOException {
        String[] s;
        s = br.readLine().split("\\s");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(s[i]);
        }
    }
}

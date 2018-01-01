package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by hardCode on 3/3/2017.
 */
public class XennyAndAlternatingTasks {

    final static int MAX = 100000, M = 1000000007;
    static int[] xenny = new int[MAX];
    static int[] yana = new int[MAX];
    static BufferedReader br;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        int t, n;
        String[] s;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            readArray(xenny, n);
            readArray(yana,n);
            System.out.println(solve(xenny,yana,n));
        }
    }

    private static int solve(int[] xenny, int[] yana, int n) {

        //total 1 is total time when xenny did first second task and total2 is total time when yana did the first task
        int total1=0,total2=0;
        for (int i = 0; i < n; i++) {
            if ((i&1)==1){
                total1+=yana[i];
                total2+=xenny[i];
            }
            else {
                total1+=xenny[i];
                total2+=yana[i];
            }
        }
        return Integer.min(total1,total2);
    }


    private static void readArray(int[] xenny, int n) throws IOException {
        String[] s;
        s = br.readLine().split("\\s");
        for (int i = 0; i < n; i++) {
            xenny[i] = Integer.parseInt(s[i]);
        }
    }
}

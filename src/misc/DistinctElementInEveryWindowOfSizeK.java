package misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Created by hardCode on 4/15/2017.
 */
public class DistinctElementInEveryWindowOfSizeK {

    final static int MAX = 100, M = 1000000007;
    static int[] a = new int[MAX];
    static BufferedReader br;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        int t, n,k;
        String[] s;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            s=br.readLine().split("\\s");
            n = Integer.parseInt(s[0]);
            k=Integer.parseInt(s[1]);
            readArray(a, n);
            solve(a,k,n);
        }
    }

    private static void solve(int[] a, int k, int n) {

        HashMap<Integer,Integer>map=new HashMap<>();
        int i;
        for ( i = 0; i < k && i<n; i++) {
            if (map.containsKey(a[i])){
                int temp=map.get(a[i]);
                temp++;
                map.put(a[i],temp);
            }
            else map.put(a[i],1);
        }
        System.out.print(map.size() + " ");
        if (i==n)return;
        int temp;
        for (; i <n ; i++) {
            if (map.containsKey(a[i])){
                temp=map.get(a[i]);
                temp++;
                map.put(a[i],temp);
            }
            else map.put(a[i],1);

            temp=map.get(a[i-k]);
            if (temp==1)
                map.remove(a[i - k]);
            else {
                temp--;
                map.put(a[i - k], temp);
            }
            System.out.print(map.size() + " ");
        }
        System.out.println();
    }

    private static void readArray(int[] a, int n) throws IOException {
        String[] s;
        s = br.readLine().split("\\s");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(s[i]);
        }
    }
}

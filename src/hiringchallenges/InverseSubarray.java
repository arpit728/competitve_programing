package hiringchallenges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by hardCode on 3/8/2017.
 */
public class InverseSubarray {

    final static int MAX = 100000;
    static int[] a = new int[MAX];
    static int[] temp = new int[MAX];
    static int[]last=new int[MAX];
    static BufferedReader br;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        int t, n;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            readArray(a, n);
            System.out.println(solve(a,n));
        }
    }

    private static int solve(int[] a, int n) {

        HashMap<Integer, Integer> map;
        int ans=0;
        System.arraycopy(a, 0, temp, 0, n);
        Arrays.sort(temp, 0, n);
        map=calculateRank(temp,n);
        replaceValuesWithRank(a,n,map);
        calculateLasOccurrence(a,n);
        lastOccurrencePrefix(last, n);
        for (int i = 0; i < n; i++) {
            ans=Integer.max(ans,last[a[i]]-i+1);
        }
        return ans;
    }

    private static void lastOccurrencePrefix(int[] last, int n) {

        for (int i = 1; i < n; i++)
            last[i] = Integer.max(last[i - 1], last[i]);
    }

    private static void calculateLasOccurrence(int[] a, int n) {
        for (int i = 0; i < n; i++) {
            last[a[i]]=i;
        }
    }

    private static void replaceValuesWithRank(int[] a, int n, HashMap<Integer, Integer> map) {
        for (int i = 0; i < n; i++) {
            a[i]=map.get(a[i]);
        }
    }


    private static HashMap<Integer, Integer> calculateRank(int[] temp, int n) {
        HashMap<Integer, Integer> map=new HashMap<>();
        int rank=0;
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(temp[i]))
                map.put(temp[i], rank++);
        }
        return map;
    }

    private static void readArray(int[] a, int n) throws IOException {
        String[] s;
        s = br.readLine().split("\\s");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(s[i]);
        }
    }
}

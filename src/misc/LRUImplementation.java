package misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 * Created by hardCode on 3/2/2017.
 */
public class LRUImplementation {

    final static int MAX = 10000000;
    static int[] a = new int[MAX];
    static BufferedReader br;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        int k, n;
        String[] s;
        s=br.readLine().split("\\s");
        n = Integer.parseInt(s[0]);
        k=Integer.parseInt(s[1]);
        readArray(a, n);
        solve(a, n, k);
    }

    private static void solve(int[] a, int n, int k) {

        LinkedList<Integer>cache=new LinkedList<>();
        int pageFault=0;

        for (int i = 0; i < n; i++) {
            if (cache.contains(a[i])){
                cache.remove((Integer)a[i]);
                cache.add(a[i]);
            }
            else if (cache.size()<k){
                cache.add(a[i]);
                pageFault++;
            }
            else {
                cache.remove(0);
                cache.add(a[i]);
                pageFault++;
            }
        }
        System.out.println(pageFault);
        for (int i =cache.size()-1; i>=0 ; i--) {
            System.out.print(cache.get(i)+" ");
        }
        System.out.println();
    }

    private static void readArray(int[] a, int n) throws IOException {
        String[] s;
        int count=0;
        int i = 0;
        s=br.readLine().split("\\s");

        for (i = 0; i < s.length; i++) {
            a[i]=Integer.parseInt(s[i]);
        }

        for (;i<n;i++){
            a[i]=Integer.parseInt(br.readLine());
        }

    }
}

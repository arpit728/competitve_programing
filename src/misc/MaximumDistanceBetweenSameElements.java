package misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by arpit on 14/12/16.
 */
public class MaximumDistanceBetweenSameElements {

    static int[]a=new int[1000];

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t,n;
        String[]s;
        t=Integer.parseInt(br.readLine());
        while (t-->0){
            n=Integer.parseInt(br.readLine());
            s=br.readLine().split("\\s");

            for (int i = 0; i < n; i++) {
                a[i]=Integer.parseInt(s[i]);
            }
            System.out.println(solve(n));
        }
    }

    private static int solve(int n) {

        int dis=0;
        HashMap<Integer,Integer>map=new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(a[i])){
                map.put(a[i],i);
            }
            else {
                dis=Integer.max(dis,i-map.get(a[i]));
            }
        }
        return dis;
    }
}

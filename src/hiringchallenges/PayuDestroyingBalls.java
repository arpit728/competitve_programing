package hiringchallenges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

/**
 * Created by bugkiller on 8/5/2017.
 */
public class PayuDestroyingBalls {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t,n;
        String[]s;
        t = Integer.parseInt(br.readLine());
        TreeMap<Integer,Integer>map=new TreeMap<>();
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            s = br.readLine().split("\\s");
            for (int i = 0; i < n; i++) {
                int temp = Integer.parseInt(s[i]);
                if (map.containsKey(temp)) {
                    int cnt=map.get(temp);
                    cnt++;
                    map.put(temp, cnt);
                }
                else map.put(temp, 1);
            }
            System.out.println(solve(map,n));
            map.clear();
        }
    }

    private static String solve(TreeMap<Integer, Integer> map, int n) {
        int maxValue;
        while (!map.isEmpty()) {
            maxValue=map.lastKey();
            int cnt=map.get(maxValue);
            map.remove(maxValue);
            if (map.ceilingKey(n - cnt + 1) != null) {
                return "NO";
            }
            n-=cnt;

        }
        return "YES";

    }
}

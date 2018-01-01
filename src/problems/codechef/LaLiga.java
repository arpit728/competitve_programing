package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by arpit on 21/5/17.
 */
public class LaLiga {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        String[] s;
        HashMap<String, Integer> map = new HashMap<>();
        while (t-- > 0) {
            for (int i = 0; i < 4; i++) {
                s = br.readLine().split("\\s");
                map.put(s[0], Integer.parseInt(s[1]));
            }
            System.out.println(solve(map));
        }

    }

    private static String solve(HashMap<String, Integer> map) {
        if (map.get("Barcelona")>map.get("Eibar") && map.get("RealMadrid")< map.get("Malaga"))
            return "Barcelona";
        else
            return "RealMadrid";
    }
}

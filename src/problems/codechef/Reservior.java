package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Jarvis on 1/14/2017.
 */
public class Reservior {

    static String[] res = new String[1000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t, n, m;
        String[] s;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            s = br.readLine().split("\\s");
            n = Integer.parseInt(s[0]);
            m = Integer.parseInt(s[1]);
            for (int i = 0; i < n; i++) {
                res[i] = br.readLine();
            }
            System.out.println(solve(res, n, m));
        }
    }

    private static String solve(String[] res, int n, int m) {

        //System.out.println(check1(res, n, m)+" "+check2(res, n, m)+" "+check3(res, n, m));

        if (check1(res, n, m) && check2(res, n, m) && check3(res, n, m))
            return "yes";

        return "no";
    }

    private static boolean check3(String[] res, int n, int m) {

        boolean d1=true,d2=true;

        for (int i = 1; i < n-1; i++) {
            for (int j = 1; j <m-1 ; j++) {
                if (res[i].charAt(j)=='W')
                    if (res[i].charAt(j-1)=='A' || res[i].charAt(j+1)=='A' || res[i+1].charAt(j)=='A')
                        d1= false;
            }
        }
        for (int j = 1; j <m-1 ; j++) {
            if (res[n-1].charAt(j)=='W')
                if (res[n-1].charAt(j-1)=='A' || res[n-1].charAt(j+1)=='A')
                    d2=false;

            if (res[0].charAt(j)=='W')
                if (res[0].charAt(j-1)=='A' || res[0].charAt(j+1)=='A')
                    d2=false;
        }
        if (d1 && d2)return true;
        return false;
    }

    private static boolean check2(String[] res, int n, int m) {

        for (int i = 0; i <n ; i++) {
            if (res[i].charAt(0)=='W' || res[i].charAt(m-1)=='W')
                return false;
        }
        return true;
    }


    private static boolean check1(String[] res, int n, int m) {
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((res[i].charAt(j) == 'A' || res[i].charAt(j) == 'W') && res[i - 1].charAt(j) == 'B')
                    return false;
            }
        }
        return true;
    }

}

package snackdown2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Integer.min;
import static java.lang.Integer.max;
/**
 * Created by arpit on 22/5/17.
 */
public class SameSnake {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x1, y1, x2, y2, x3, y3, x4, y4, t;
        String[]s;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            s=br.readLine().split("\\s");
            x1 = Integer.parseInt(s[0]);
            y1 = Integer.parseInt(s[1]);
            x2 = Integer.parseInt(s[2]);
            y2 = Integer.parseInt(s[3]);

            s=br.readLine().split("\\s");
            x3 = Integer.parseInt(s[0]);
            y3 = Integer.parseInt(s[1]);
            x4 = Integer.parseInt(s[2]);
            y4 = Integer.parseInt(s[3]);
            String temp = solve(x1, y1, x2, y2,x3,y3,x4,y4, true);
            if (!"rep".equals(temp)) {
                System.out.println(temp);
            }
            else {
                System.out.println(solve(y1, x1, y2, x2,y3,x3,y4,x4, false));
            }
        }
    }

    private static String solve(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4, boolean b) {
        if (x1 == x2) {
            if (x3 == x4) {
                if (x1 == x3) {
                    if (min(y1, y2) >= min(y3, y4) && min(y1, y2)<=max(y3,y4)) {

                        return "yes";
                    }
                    if (min(y3, y4) >= min(y1, y2) && min(y3, y4) <= max(y1,y2)) {

                        return "yes";
                    }
                    return "no";
                }
                return "no";
            }

            if (y1 == y2) {
                if (y1 == y3 && (x1 >= min(x3, x4) && x1 <= max(x3, x4))) {
                    return "yes";
                }
            }


            if ((y3 == y1) && (((x1 == x3) || (x1 == x4)))) {
                return "yes";
            }
            if ((y4 == y2) && ((x2 == x4) || (x2 == x3))) {
                return "yes";
            }

            return "no";
        }
        if (b) return "rep";
        return "no";

    }
}

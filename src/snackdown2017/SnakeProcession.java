package snackdown2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by arpit on 21/5/17.
 */
public class SnakeProcession {

    static char[] a = new char[500];



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int r, l;
        r = Integer.parseInt(br.readLine());
        while (r-- > 0) {
            l = Integer.parseInt(br.readLine());
            br.read(a, 0, l);
            br.read();
            System.out.println(solve(a, l));
        }
    }

    private static String solve(char[] a, int l) {
        char expected='H';
        boolean flag =false;

        for (int i = 0; i < l; i++) {
            if (a[i] == '.') continue;
            if (a[i] == expected) {
                if (a[i] == 'H') {
                    expected = 'T';
                }
                else expected = 'H';
            }
            else {
                flag=true;
                break;
            }
        }

        if (!flag && expected=='H')
            return "Valid";

        return "Invalid";
    }
}


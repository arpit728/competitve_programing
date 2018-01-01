package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by bugkiller on 6/6/2017.
 */
public class AGoodSet {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t,n;
        t = Integer.parseInt(br.readLine());
        StringBuilder sbr = new StringBuilder();
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            for (int i = 0,k=1; i < n; i++,k+=2) {
                sbr.append(k + " ");
            }
            System.out.println(sbr);
            sbr.setLength(0);
        }
    }
}

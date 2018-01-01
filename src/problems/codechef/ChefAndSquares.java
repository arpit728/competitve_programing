package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by hardCode on 12/1/2016.
 */

public class ChefAndSquares {


    public static void main(String[] args) throws IOException {

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int t,k;
        t=Integer.parseInt(br.readLine());
        while(t-->0){
            k=Integer.parseInt(br.readLine());

            System.out.print(solve(k));
        }
    }

    private static String solve(int k) {

        StringBuilder sbr = new StringBuilder();
        int start, ind;
        if (k == 1) {
            return "1";
        }
        start = k - (k / 2) + 1;

        for (int i = 0; i < k; i++) {

            ind = start;
            for (int j = 0; j < k; j++) {

                sbr.append(ind + " ");
                ind++;
                if (ind > k) ind = 1;
            }
            start++;
            if (start > k) start = 1;
            sbr.append("\n");
        }

        return sbr.toString();
    }
}

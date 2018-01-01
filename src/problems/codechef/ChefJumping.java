package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

/**
 * Created by arpit on 24/12/16.
 */
public class ChefJumping {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        long a=Long.parseLong(br.readLine());
        System.out.println(solve(a));
    }

    private static String solve(long a) {

        if (((a % 6) == 0) || ((a % 6) == 1) || ((a % 6) == 3))return "yes";

        return "no";
    }
}

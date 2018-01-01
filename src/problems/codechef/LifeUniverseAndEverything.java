package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by hardCode on 1/26/2016.
 */
public class LifeUniverseAndEverything {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n;
        n=Integer.parseInt(br.readLine());
        while (n!=42) {
            System.out.println(n);
            n=Integer.parseInt(br.readLine());
        }
    }
}

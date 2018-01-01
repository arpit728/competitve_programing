package meetup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by bugkiller on 8/19/2017.
 */
public class VowelConsonant {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s=br.readLine();

        System.out.println(solve(s));
    }

    private static int solve(String s) {

        int sum=0;
        HashSet<Character> hash = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        for (int i = 0; i < s.length(); i++) {

            if (hash.contains(s.charAt(i))) {
                sum++;
            }
            else sum+=2;
        }
        return sum;
    }
}

package hiringchallenges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * Created by arpit on 9/2/17.
 */

public class LexicalAnalyzer {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(br.readLine());

        HashSet<String>set=new HashSet<>();

        String s;

        for (int i = 0; i < n; i++) {
            s=br.readLine();
            set.add(s.substring(0,s.indexOf("=")));
        }

        System.out.println(set.size());
    }
}

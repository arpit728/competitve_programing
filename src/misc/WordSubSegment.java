package misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * Created by bugkiller on 8/28/2017.
 */
public class WordSubSegment {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<String> wordList = new HashSet<>();
        String[]paragraph;
        String[]s;
        s = br.readLine().split("\\s");

        paragraph = br.readLine().split("\\s");
        for (int i = 0; i < s.length; i++) {
            wordList.add(s[i]);
        }

        System.out.println(solve(paragraph,wordList));


    }

    private static int solve(String[] paragraph, HashSet<String> wordList) {
        int minLength=Integer.MAX_VALUE,cnt;
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < paragraph.length; i++) {
            cnt = 0;
            for (int j = i; j < paragraph.length; j++) {
                if (wordList.contains(paragraph[i]) && !set.contains(paragraph[i])) {
                    cnt++;
                }

                if (cnt == wordList.size()) {
                    minLength = Integer.min(minLength,j-i+1);
                    break;
                }
            }
        }
        return minLength;
    }
}

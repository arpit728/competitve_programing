package hiringchallenges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Integer.max;
/**
 * Created by bugkiller on 7/1/2017.
 */
public class MonkAndChocolates {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s[],chocolateString;

        int testCases,magicMoves,chocolates;

        testCases = Integer.parseInt(br.readLine());
        while (testCases-- > 0) {
            s = br.readLine().split("\\s");
            chocolates = Integer.parseInt(s[0]);
            magicMoves = Integer.parseInt(s[1]);
            chocolateString = br.readLine();
            System.out.println(solve(chocolates, magicMoves, chocolateString));
        }
    }

    private static int solve(int chocolates, int magicMoves, String chocolateString) {

        int ans = 0;

        for (int c = 0; c < 26; ++c) {
            int letterCount = 0,nonLetterCount = 0;
            int remove = 0;
            for (int k = 0; k < chocolateString.length(); ++k) {

                if(chocolateString.charAt(k) == (char)(c + 'a')){
                    letterCount++;
                }
                else
                    nonLetterCount++;

                if (nonLetterCount <= magicMoves) {
                    ans = max(ans, nonLetterCount + letterCount);
                }
                else {
                    if(chocolateString.charAt(remove++) == (char) (c + 'a')){
                        letterCount--;
                    }
                    else
                        nonLetterCount--;
                }
            }

        }
        for (int c = 0; c < 26; ++c) {
            int letterCount = 0, nonLetterCount = 0;
            int remove = 0;
            for (int k = 0; k < chocolateString.length(); ++k) {
                if(chocolateString.charAt(k) ==(char) (c + 'A')){
                    letterCount++;
                }
                else
                    nonLetterCount++;

                if (nonLetterCount <= magicMoves) {
                    ans = max(ans, nonLetterCount + letterCount);
                }
                else {
                    if(chocolateString.charAt(remove++) ==(char) (c + 'A')){
                        letterCount--;
                    }
                    else
                        nonLetterCount--;
                }
            }

        }
        return ans;
    }
}

package meetup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by bugkiller on 8/19/2017.
 */
public class PalindromicPermutation {

    static int hash[] = new int[26];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        s=br.readLine();
        System.out.println(existPalindromicPermutation(s));
    }

    private static boolean existPalindromicPermutation(String s) {
        int oddCount=0;
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i)-'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (hash[i]%2==1)
                oddCount++;
        }
        if (oddCount>1)
            return false;

        return true;
    }
}

package ctci;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by bugkiller on 8/15/2017.
 */
public class URLify {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s=br.readLine();
        char[] str = new char[100];
        for (int i = 0; i < s.length(); i++) {
            str[i] = s.charAt(i);
        }
        System.out.println(urlIfy(str,s.length()));
    }

    private static String urlIfy(char[] s, int length) {
        int cnt=countSpace(s);
        int prevEnd=length-1;
        int newEnd=prevEnd+2*cnt;
        for (int i=prevEnd,j=newEnd;i>=0 && j>=0;i--,j--) {
            if (s[i] == ' ') {
                s[j--] = '0';
                s[j--] = '2';
                s[j] = '%';
                continue;
            }
            s[j] = s[i];
        }
        return String.valueOf(s);
    }

    private static int countSpace(char[] s) {
        int cnt=0;
        for (char c :s) {
            if (c == ' ')cnt++;
        }
        return cnt;
    }
}

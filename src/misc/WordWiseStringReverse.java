package misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by hardCode on 4/16/2017.
 */
public class WordWiseStringReverse {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int t;
        char[]s;
        t=Integer.parseInt(br.readLine());
        while (t-->0){
            s=br.readLine().toCharArray();
            solve(s,s.length);
            System.out.println(String.valueOf(s));
        }
    }

    private static void solve(char[] s, int n) {
        int start=0;

        while (start<n && s[start]=='.')
            start++;

        for (int i = start; i < n; i++) {

            if (s[i]=='.'){
                reverseWord(s,start,i-1);
                start=i+1;
            }

        }
        reverseWord(s,start,n-1);
        reverseWord(s,0,n-1);
    }

    private static void reverseWord(char[] s, int start, int end) {

        char temp;
        while (start<end){
            temp=s[start];
            s[start]=s[end];
            s[end]=temp;
            start++;
            end--;
        }

    }
}

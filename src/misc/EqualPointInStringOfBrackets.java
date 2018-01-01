package misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by hardCode on 4/12/2017.
 */
public class EqualPointInStringOfBrackets {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        char[]s;

        while (t-- > 0) {

            s = br.readLine().toCharArray();
            System.out.println(solve(s, s.length));
        }
    }

    private static int solve(char[] s, int n) {
        int prefix[]=new int[n];
        int suffix[] = new int[n];
        fillPrefix(s,prefix,n);
        fillSuffix(s,suffix,n);

        //System.out.println(Arrays.toString(prefix)+" "+Arrays.toString(suffix));
        if (suffix[0]==0)return 0;
        if (prefix[n-1]==0)return n;
        for (int i = 1; i < n; i++) {
            if (suffix[i]==prefix[i-1])
                return i;

        }
        return 0;
    }

    private static void fillSuffix(char[] s, int[] suffix, int n) {

        if (s[n-1]==')')
            suffix[n-1]=1;
        for (int i = n - 2; i >= 0; i--) {
            suffix[i]=suffix[i+1];
            if (s[i]==')')
                suffix[i]++;
        }
    }

    private static void fillPrefix(char[] s, int[] prefix, int n) {

        if (s[0]=='(')
            prefix[0]=1;
        for (int i = 1; i <n ; i++) {
            prefix[i]=prefix[i-1];
            if (s[i]=='(')
                prefix[i]++;
        }
    }

}

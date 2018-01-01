package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by hardCode on 3/4/2016.
 */
public class PalindromicSubstring {
    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        t=Integer.parseInt(br.readLine());
        String s1,s2;
        boolean hash[];
        while (t-->0){
            hash=new boolean[127];
            s1=br.readLine();
            s2=br.readLine();
            String ans="No";
            for (int i = 0; i < s1.length(); i++) {
                char ch=s1.charAt(i);
                if (!hash[ch]) {
                    if (s2.indexOf(ch) != -1) {

                        ans = "Yes";
                        break;
                    }
                    hash[ch] = true;
                }
            }
            System.out.println(ans);
        }
    }
}

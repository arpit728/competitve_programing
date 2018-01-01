package problems.codejam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by hardCode on 4/16/2016.
 */
public class TheLastWord {

    public static void main(String[] args) throws IOException {
        int t;
        char s[];
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        t=Integer.parseInt(br.readLine());
        int i=1;
        while (t-->0){
            s=br.readLine().toCharArray();
            System.out.println("Case #"+i+": "+solve(s));
            i++;
        }
    }

    private static String solve(char[] s) {
        int n=s.length;
        StringBuilder sbr= new StringBuilder();
        sbr.append(s[0]);
        for (int i = 1; i < n ; i++) {
            if (s[i]>=sbr.charAt(0))sbr.insert(0,s[i]);
            else sbr.append(s[i]);

            //System.out.print(sbr+" ");
        }

        return sbr.toString();
    }
}

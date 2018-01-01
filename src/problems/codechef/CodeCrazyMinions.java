package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by arpit on 3/1/17.
 */
public class CodeCrazyMinions {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int t;
        char[]ch;
        t=Integer.parseInt(br.readLine());
        while (t-->0){
            ch=br.readLine().toCharArray();
            System.out.println(solve(ch,ch.length));
        }
    }

    private static String solve(char[] ch, int l) {
        int cnt=2;

        for (int i = 1 ; i <l ; i++) {

            if (ch[i]==ch[i-1])cnt++;

            else if (ch[i]>ch[i-1])cnt+=ch[i]-ch[i-1]+1;

            else cnt+='z'-ch[i-1]+1+ch[i]-'a'+1;

            //
        }
        System.out.println(cnt);
        if (cnt<=(11*l)) return "YES";

        return "NO";

    }
}

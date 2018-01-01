package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by arpit on 25/12/16.
 */
public class TheBallAndCups {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t,n,c,q;
        String[]s;
        t=Integer.parseInt(br.readLine());
        while (t-->0){
            s=br.readLine().split("\\s");
            n=Integer.parseInt(s[0]);
            c=Integer.parseInt(s[1]);
            q=Integer.parseInt(s[2]);

            for (int i = 0; i < q; i++) {
                s=br.readLine().split("\\s");
                int l=Integer.parseInt(s[0]);
                int r=Integer.parseInt(s[1]);
                if (c>=l && c<=r){
                    c=r-(c-l);
                }
            }
            System.out.println(c);
        }
    }
}

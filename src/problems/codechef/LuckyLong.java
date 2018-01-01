package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Created by arpit on 30/12/16.
 */
public class LuckyLong {

    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int t= Integer.parseInt(br.readLine());
        while (t-->0){
            solve();
        }
    }

    private static void solve() throws IOException {

        long ans=0;
        char c;
        while ((c= (char) br.read())!='\n'){

            if ((c>='0' && c<='9') && c!='4' && c!='7')
                ans++;
        }
        System.out.println(ans);

    }
}

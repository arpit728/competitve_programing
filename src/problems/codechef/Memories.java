package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by arpit on 17/1/16.
 */
public class Memories {

    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t,n,p,ans,pair[][];
        String s[];
        t= Integer.parseInt(br.readLine());
        boolean hash[];

        while (t-->0) {

            s = br.readLine().split("\\s");
            n = Integer.parseInt(s[0]);
            p = Integer.parseInt(s[1]);
            pair = new int[p][2];

            ans = (int) Math.pow(2, n);
            ans--;

            hash=new boolean[ans+1];

            for (int i = 0; i < p; i++) {
                s = br.readLine().split("\\s");
                pair[i][0] = Integer.parseInt(s[0]);
                pair[i][1] = Integer.parseInt(s[1]);
                pair[i][0]--;
                pair[i][1]--;
            }
            int temp=ans;

            for (int i = 0; i < p; i++)

                for (int j = 1; j <= temp; j++) {

                    int f1 =j&(1<<0), f2 = (j & (1 << pair[i][1]));

                    if (!hash[j])

                    {
                        if ((f1 !=0) & (f2 != 0)) {

                            ans--;
                            hash[j] = true;

                        }
                    }

                }
            System.out.println(ans);
        }

    }
}

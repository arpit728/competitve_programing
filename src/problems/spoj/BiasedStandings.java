package problems.spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Arpit on 20-Dec-15.
 */
public class BiasedStandings {
    public static void main(String[] args) {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        try {
            int t=Integer.parseInt(br.readLine()),n,ans,rank;
            while (t-->0){
                ans=0;
                br.readLine();
                n=Integer.parseInt(br.readLine());
                String s[],name;
                for (int i = 1; i <=n; i++) {
                    s=br.readLine().split("\\s");
                    name=s[0];
                    rank=Integer.parseInt(s[1]);
                    ans=ans+Math.abs(rank-i);
                }
                System.out.println(ans);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

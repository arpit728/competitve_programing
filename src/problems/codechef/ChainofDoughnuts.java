package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by Arpit on 04-Jan-16.
 */
public class ChainofDoughnuts {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t,m,n,sum,chain[],ans;
        String s[];
        t=Integer.parseInt(br.readLine());
        while(t-->0){
            s=br.readLine().split("\\s");
            n= Integer.parseInt(s[0]);
            m=Integer.parseInt(s[1]);
            sum=0;ans=0;
            chain=new int[m];
            s=br.readLine().split("\\s");

            int flag=0;
            for (int i = 0; i < m; i++) {
                chain[i]=Integer.parseInt(s[i]);
                if (chain[i]>1)flag=1;
            }

            if (flag==1) {
                Arrays.sort(chain);
                for (int i = 1; i <= m; i++) {
                    sum += chain[i - 1];
                    if (sum > m - i - 1) {
                        ans=m-i;
                        break;
                    } else if (sum == m - i - 1) {
                        ans=m - i - 1;
                        break;
                    }

                }
            }
            else ans=m/2;
            System.out.println(ans);
        }
    }
}

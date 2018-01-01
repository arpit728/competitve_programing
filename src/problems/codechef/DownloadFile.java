package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by hardCode on 2/19/2017.
 */
public class DownloadFile {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int tc,n,k,timeSum,ans;
        String[]s;
        tc = Integer.parseInt(br.readLine());

        while (tc-->0){

            ans=0;
            timeSum=0;
            s=br.readLine().split("\\s");
            n=Integer.parseInt(s[0]);
            k=Integer.parseInt(s[1]);

            for (int i = 0; i < n; i++) {

                s=br.readLine().split("\\s");
                int t=Integer.parseInt(s[0]);
                int d=Integer.parseInt(s[1]);

                if (timeSum==k)ans+=t*d;

                else if (timeSum+t>k){
                    ans+=(t-(k-timeSum))*d;
                    timeSum=k;
                }

                else timeSum+=t;
            }
            System.out.println(ans);

        }

    }
}

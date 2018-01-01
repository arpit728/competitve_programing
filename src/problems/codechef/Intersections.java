package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by hardCode on 3/9/2016.
 */
public class Intersections {

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine()),n;
        while (t-->0){
            n=Integer.parseInt(br.readLine());
            int ans;
            if (n==1) ans=0;
            else if (n==2)ans=2;
            else if (n==3)ans=3;
            else {
                n-=2;
                ans=n*2;
            }
            System.out.println(ans);

        }
    }
}
